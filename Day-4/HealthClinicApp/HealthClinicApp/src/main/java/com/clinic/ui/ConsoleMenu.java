package com.clinic.ui;

import com.clinic.dao.*;
import com.clinic.dto.*;
import com.clinic.service.AppointmentService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Floor 4 — what the receptionist actually sees.
 * This file never contains SQL. It only ever asks a DAO or the Service layer to do things.
 */
public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);

    private final PatientDAO patientDAO = new PatientDAOImpl();
    private final DoctorDAO doctorDAO = new DoctorDAOImpl();
    private final SpecializationDAO specializationDAO = new SpecializationDAOImpl();
    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final BillingDAO billingDAO = new BillingDAOImpl();
    private final VisitHistoryDAO visitHistoryDAO = new VisitHistoryDAOImpl();
    private final AppointmentService appointmentService = new AppointmentService();

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATETIME_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public void start() {
        System.out.println("=== Health Clinic Console ===");
        boolean running = true;
        while (running) {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Patients");
            System.out.println("2. Doctors");
            System.out.println("3. Specializations");
            System.out.println("4. Appointments");
            System.out.println("5. Complete Appointment (bill + visit record)");
            System.out.println("6. Billing");
            System.out.println("7. Visit History");
            System.out.println("0. Exit");
            switch (readInt("Choose: ")) {
                case 1 -> patientMenu();
                case 2 -> doctorMenu();
                case 3 -> specializationMenu();
                case 4 -> appointmentMenu();
                case 5 -> completeAppointment();
                case 6 -> billingMenu();
                case 7 -> visitHistoryMenu();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
        System.out.println("Goodbye!");
    }

    // ---------------------------------------------------------------- PATIENTS
    private void patientMenu() {
        System.out.println("\n-- Patients --");
        System.out.println("1. Register  2. View All  3. View By ID  4. Update  5. Deactivate  0. Back");
        switch (readInt("Choose: ")) {
            case 1 -> registerPatient();
            case 2 -> listAll("Patients", patientDAO.getAllPatients());
            case 3 -> System.out.println(patientDAO.getPatientById(readInt("Patient ID: ")));
            case 4 -> updatePatient();
            case 5 -> System.out.println(patientDAO.deletePatient(readInt("Patient ID: "))
                        ? "Patient deactivated." : "Failed - check the ID.");
            case 0 -> {}
            default -> System.out.println("Invalid choice.");
        }
    }

    private void registerPatient() {
        System.out.print("First name: "); String first = scanner.nextLine();
        System.out.print("Last name: "); String last = scanner.nextLine();
        System.out.print("Date of birth (yyyy-MM-dd, blank to skip): ");
        String dobStr = scanner.nextLine();
        LocalDate dob = dobStr.isBlank() ? null : LocalDate.parse(dobStr, DATE_FMT);
        System.out.print("Gender (Male/Female/Other, blank to skip): "); String gender = scanner.nextLine();
        System.out.print("Phone: "); String phone = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();

        Patient p = new Patient(first, last, dob, gender.isBlank() ? null : gender, phone, email);
        int id = patientDAO.insertPatient(p);
        System.out.println(id > 0 ? "Registered with ID: " + id : "Registration failed.");
    }

    private void updatePatient() {
        int id = readInt("Patient ID to update: ");
        Patient existing = patientDAO.getPatientById(id);
        if (existing == null) { System.out.println("No patient with that ID."); return; }
        System.out.print("New phone (blank to keep '" + existing.getPhoneNumber() + "'): ");
        String phone = scanner.nextLine();
        if (!phone.isBlank()) existing.setPhoneNumber(phone);
        System.out.print("New email (blank to keep '" + existing.getEmail() + "'): ");
        String email = scanner.nextLine();
        if (!email.isBlank()) existing.setEmail(email);
        System.out.println(patientDAO.updatePatient(existing) ? "Updated." : "Update failed.");
    }

    // ---------------------------------------------------------------- DOCTORS
    private void doctorMenu() {
        System.out.println("\n-- Doctors --");
        System.out.println("1. Register  2. View All  3. View By ID  4. Update  5. Deactivate");
        System.out.println("6. Assign Specialization  7. View Specializations  0. Back");
        switch (readInt("Choose: ")) {
            case 1 -> registerDoctor();
            case 2 -> listAll("Doctors", doctorDAO.getAllDoctors());
            case 3 -> System.out.println(doctorDAO.getDoctorById(readInt("Doctor ID: ")));
            case 4 -> updateDoctor();
            case 5 -> System.out.println(doctorDAO.deleteDoctor(readInt("Doctor ID: "))
                        ? "Doctor deactivated." : "Failed - check the ID.");
            case 6 -> {
                int docId = readInt("Doctor ID: ");
                int specId = readInt("Specialization ID: ");
                System.out.println(doctorDAO.assignSpecialization(docId, specId) ? "Assigned." : "Assign failed.");
            }
            case 7 -> {
                List<Specialization> specs = doctorDAO.getSpecializationsForDoctor(readInt("Doctor ID: "));
                specs.forEach(System.out::println);
                if (specs.isEmpty()) System.out.println("(none)");
            }
            case 0 -> {}
            default -> System.out.println("Invalid choice.");
        }
    }

    private void registerDoctor() {
        System.out.print("First name: "); String first = scanner.nextLine();
        System.out.print("Last name: "); String last = scanner.nextLine();
        System.out.print("Phone: "); String phone = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        int id = doctorDAO.insertDoctor(new Doctor(first, last, phone, email));
        System.out.println(id > 0 ? "Registered with ID: " + id : "Registration failed.");
    }

    private void updateDoctor() {
        int id = readInt("Doctor ID to update: ");
        Doctor existing = doctorDAO.getDoctorById(id);
        if (existing == null) { System.out.println("No doctor with that ID."); return; }
        System.out.print("New phone (blank to keep '" + existing.getPhoneNumber() + "'): ");
        String phone = scanner.nextLine();
        if (!phone.isBlank()) existing.setPhoneNumber(phone);
        System.out.print("New email (blank to keep '" + existing.getEmail() + "'): ");
        String email = scanner.nextLine();
        if (!email.isBlank()) existing.setEmail(email);
        System.out.println(doctorDAO.updateDoctor(existing) ? "Updated." : "Update failed.");
    }

    // ---------------------------------------------------------------- SPECIALIZATIONS
    private void specializationMenu() {
        System.out.println("\n-- Specializations --");
        System.out.println("1. Add  2. View All  3. Update  4. Delete  0. Back");
        switch (readInt("Choose: ")) {
            case 1 -> {
                System.out.print("Name: "); String name = scanner.nextLine();
                System.out.print("Description: "); String desc = scanner.nextLine();
                int id = specializationDAO.insertSpecialization(new Specialization(name, desc));
                System.out.println(id > 0 ? "Added with ID: " + id : "Add failed.");
            }
            case 2 -> listAll("Specializations", specializationDAO.getAllSpecializations());
            case 3 -> {
                int id = readInt("Specialization ID: ");
                Specialization s = specializationDAO.getSpecializationById(id);
                if (s == null) { System.out.println("Not found."); break; }
                System.out.print("New name (blank to keep '" + s.getName() + "'): ");
                String name = scanner.nextLine();
                if (!name.isBlank()) s.setName(name);
                System.out.print("New description (blank to keep current): ");
                String desc = scanner.nextLine();
                if (!desc.isBlank()) s.setDescription(desc);
                System.out.println(specializationDAO.updateSpecialization(s) ? "Updated." : "Update failed.");
            }
            case 4 -> System.out.println(specializationDAO.deleteSpecialization(readInt("Specialization ID: "))
                        ? "Deleted." : "Delete failed.");
            case 0 -> {}
            default -> System.out.println("Invalid choice.");
        }
    }

    // ---------------------------------------------------------------- APPOINTMENTS
    private void appointmentMenu() {
        System.out.println("\n-- Appointments --");
        System.out.println("1. Book  2. View All  3. View By Patient  4. View By Doctor  5. Cancel  0. Back");
        switch (readInt("Choose: ")) {
            case 1 -> bookAppointment();
            case 2 -> listAll("Appointments", appointmentDAO.getAllAppointments());
            case 3 -> listAll("Appointments", appointmentDAO.getAppointmentsByPatient(readInt("Patient ID: ")));
            case 4 -> listAll("Appointments", appointmentDAO.getAppointmentsByDoctor(readInt("Doctor ID: ")));
            case 5 -> System.out.println(appointmentDAO.cancelAppointment(readInt("Appointment ID: "))
                        ? "Cancelled." : "Cancel failed.");
            case 0 -> {}
            default -> System.out.println("Invalid choice.");
        }
    }

    private void bookAppointment() {
        int patientId = readInt("Patient ID: ");
        int doctorId = readInt("Doctor ID: ");
        System.out.print("Date & time (yyyy-MM-dd HH:mm): ");
        LocalDateTime dt = LocalDateTime.parse(scanner.nextLine(), DATETIME_FMT);
        Appointment a = new Appointment(patientId, doctorId, dt);
        int id = appointmentDAO.insertAppointment(a);
        System.out.println(id > 0 ? "Booked with ID: " + id : "Booking failed - check patient/doctor IDs exist.");
    }

    // ---------------------------------------------------------------- COMPLETE APPOINTMENT (Service layer)
    private void completeAppointment() {
        int id = readInt("Appointment ID: ");
        System.out.print("Bill amount: ");
        BigDecimal amount;
        try {
            amount = new BigDecimal(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount, cancelled.");
            return;
        }
        System.out.print("Diagnosis: ");
        String diagnosis = scanner.nextLine();

        boolean success = appointmentService.completeAppointment(id, amount, diagnosis);
        System.out.println(success ? "Appointment completed! Bill and visit record created." : "Something went wrong - no changes were saved.");
    }

    // ---------------------------------------------------------------- BILLING
    private void billingMenu() {
        System.out.println("\n-- Billing --");
        System.out.println("1. View All  2. View By Appointment  3. Mark Paid  0. Back");
        switch (readInt("Choose: ")) {
            case 1 -> listAll("Billing", billingDAO.getAllBillings());
            case 2 -> System.out.println(billingDAO.getBillingByAppointmentId(readInt("Appointment ID: ")));
            case 3 -> System.out.println(billingDAO.markAsPaid(readInt("Bill ID: ")) ? "Marked paid." : "Failed.");
            case 0 -> {}
            default -> System.out.println("Invalid choice.");
        }
    }

    // ---------------------------------------------------------------- VISIT HISTORY
    private void visitHistoryMenu() {
        System.out.println("\n-- Visit History --");
        System.out.println("1. View All  2. View By Appointment  0. Back");
        switch (readInt("Choose: ")) {
            case 1 -> listAll("Visit History", visitHistoryDAO.getAllVisitHistories());
            case 2 -> System.out.println(visitHistoryDAO.getVisitByAppointmentId(readInt("Appointment ID: ")));
            case 0 -> {}
            default -> System.out.println("Invalid choice.");
        }
    }

    // ---------------------------------------------------------------- HELPERS
    private <T> void listAll(String label, List<T> items) {
        System.out.println("-- " + label + " (" + items.size() + ") --");
        if (items.isEmpty()) { System.out.println("(none)"); return; }
        items.forEach(System.out::println);
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = Integer.parseInt(scanner.nextLine().trim());
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }
}
