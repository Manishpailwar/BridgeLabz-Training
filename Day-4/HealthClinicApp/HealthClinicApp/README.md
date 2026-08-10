# Health Clinic Console App

A layered Java console app for a clinic receptionist: register patients & doctors, assign
doctor specializations, book appointments, and complete an appointment (which atomically
creates a bill + visit record).

## Layers
```
ui/       -> ConsoleMenu.java        (Floor 4 - what the receptionist types into)
service/  -> AppointmentService.java (Floor 3 - all-or-nothing multi-table writes)
dao/      -> *DAO.java + *DAOImpl.java (Floor 2 - the only place SQL lives)
dto/      -> Patient, Doctor, Specialization, Appointment, Billing, VisitHistory (Floor 1 - data boxes)
config/   -> HikariConnectionPool.java (pooled connections to MySQL)
database/ -> health_clinic_schema.sql  (run this once in MySQL before starting the app)
```

## Setup

1. **Create the database.** In MySQL:
   ```
   mysql -u root -p < database/health_clinic_schema.sql
   ```
   This creates `health_clinic_db`, all tables, the audit-log triggers, a dedicated
   `clinic_app_user` login, and a few rows of sample data.

2. **Check the credentials match.** `config/HikariConnectionPool.java` connects as
   `clinic_app_user` / `StrongPassword123!` to `jdbc:mysql://localhost:3306/health_clinic_db`.
   Change these three values if your MySQL setup differs — nothing else in the app needs
   to change, since every DAO goes through this one class.

3. **Build & run** (requires Java 17+ and Maven):
   ```
   mvn clean package
   java -jar target/HealthClinicApp.jar
   ```
   `mvn package` uses the shade plugin to bundle the MySQL driver and HikariCP into one
   runnable jar, so there's nothing extra to put on the classpath.

## Using the app

The main menu has one section per entity (Patients, Doctors, Specializations,
Appointments), each with full CRUD, plus:

- **Complete Appointment** — the one action that isn't a simple single-table write. It
  calls `AppointmentService.completeAppointment()`, which marks the appointment
  `Completed`, inserts a `billing` row, and inserts a `visit_history` row, all inside one
  database transaction. If any of the three fails, all three are rolled back — you'll never
  end up with a bill for an appointment that didn't actually get marked complete.
- **Billing** / **Visit History** — read/update views into the rows the Service layer
  creates behind the scenes.

## Notes on choices made to keep this shippable

- `deletePatient` / `deleteDoctor` are **soft deletes** (they flip `is_active` to `false`)
  rather than `DELETE FROM`, since real rows are referenced by appointments/bills and a hard
  delete would violate foreign keys (or silently orphan history).
- `AppointmentDAO.updateStatus(...)` and `BillingDAO.insertBilling(Connection, ...)` /
  `VisitHistoryDAO.insertVisitHistory(Connection, ...)` are connection-aware overloads used
  only by `AppointmentService`, so the three writes in "complete appointment" share one
  transaction instead of each DAO opening its own connection.
- Input parsing in `ConsoleMenu` is intentionally simple (blank line = "keep existing
  value" on updates); it's a console tool for a single receptionist, not a public API, so it
  favors clarity over exhaustive validation.

## Suggested next hardening pass (Step 8 from the build plan)

- Wrap the console loop in a top-level try/catch so a bad date/number format doesn't crash
  the whole app mid-session.
- Add a uniqueness check before insert for patient/doctor email & phone (currently the DB's
  `UNIQUE` constraint is the only thing stopping duplicates, so a failed insert just prints
  a raw SQL error).
- Add pagination to `listAll` once the sample data grows past a page.
