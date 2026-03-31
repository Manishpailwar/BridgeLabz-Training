
 // Program to Display Employee Details
 // This program defines an Employee class and displays their details.
 
class Employee {
    String name;
    int id;
    double salary;

    // Constructor to initialize the employee object
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.printf("Employee Salary: %.0f.\n", salary);
    }
}

public class EmployeeDetail {
    public static void main(String[] args) {
        Employee emp = new Employee("Rohan", 1, 500000);
        emp.displayDetails();
    }
}