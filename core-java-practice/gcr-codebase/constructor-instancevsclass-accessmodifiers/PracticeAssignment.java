// --- 1. Constructors ---

// Simple Book Class
class Book {
    String title;
    String author;
    double price;

    // Default Constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    // Parameterized Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

// Circle Class with Constructor Chaining
class Circle {
    double radius;

    public Circle() {
        this(1.0); // Default radius via chaining
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}

// Person Class with Copy Constructor
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy Constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }
}

// Hotel Booking System
class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    public HotelBooking() {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }
}

// Library Book System (Renamed to LibraryBook)
class LibraryBook {
    String title;
    String author;
    double price;
    boolean availability;

    public LibraryBook(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    public void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("You have borrowed: " + title);
        } else {
            System.out.println("Sorry, " + title + " is not available.");
        }
    }
}

// Car Rental System
class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate = 50.0; // Assumed rate

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }
}

// --- 2. Instance vs. Class Variables and Methods ---

// Problem 1: Product Inventory
class Product {
    String productName;
    double price;
    static int totalProducts = 0;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    public void displayProductDetails() {
        System.out.println("Product: " + productName + ", Price: " + price);
    }

    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
}

// Problem 2: Online Course Management
class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "BridgeLabz Institute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Institute: " + instituteName);
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}

// Problem 3: Vehicle Registration
class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 500.0;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName + ", Type: " + vehicleType + ", Reg Fee: " + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

// --- 3. Access Modifiers ---

// Problem 1: University Management System
class Student {
    public int rollNumber;
    protected String name;
    private double cgpa;

    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    public double getCGPA() {
        return cgpa;
    }

    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }
}

class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double cgpa) {
        super(rollNumber, name, cgpa);
    }

    public void displayInfo() {
        // Accessing protected member 'name' directly from subclass
        System.out.println("PG Student Name: " + name);
    }
}

// Problem 2: Book Library System (Renamed to AccessBook)
class AccessBook {
    public String isbn;
    protected String title;
    private String author;

    public AccessBook(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends AccessBook {
    public EBook(String isbn, String title, String author) {
        super(isbn, title, author);
    }

    public void showDetails() {
        // Accessing public ISBN and protected title
        System.out.println("EBook ISBN: " + isbn);
        System.out.println("EBook Title: " + title);
    }
}

// Problem 3: Bank Account Management
class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displayAccountInfo() {
        // Accessing public and protected members
        System.out.println("Savings Account: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
    }
}

// Problem 4: Employee Records
class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void showManagerDetails() {
        // Accessing public and protected members
        System.out.println("Manager ID: " + employeeID);
        System.out.println("Department: " + department);
    }
}

// Main class to run and test the code
public class PracticeAssignment {
    public static void main(String[] args) {
        System.out.println("Practice Assignment Classes Loaded Successfully.");
        
        // Example: Testing Product static variable
        Product p1 = new Product("Laptop", 1200.00);
        Product p2 = new Product("Mouse", 25.00);
        Product.displayTotalProducts(); // Should print 2
    }
}
