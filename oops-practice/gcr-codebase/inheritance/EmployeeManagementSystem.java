class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.printf("Salary: $%.2f%n", salary);
    }
}

class Manager extends Employee {
    int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Manager");
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Developer");
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    String specialization;

    public Intern(String name, int id, double salary, String specialization) {
        super(name, id, salary);
        this.specialization = specialization;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Intern");
        System.out.println("Specialization: " + specialization);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Manager manager = new Manager("Alice", 101, 90000, 10);
        Developer developer = new Developer("Bob", 102, 80000, "Java");
        Intern intern = new Intern("Charlie", 103, 30000, "AI/ML");

        System.out.println("Employee Details :");
        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }
}
