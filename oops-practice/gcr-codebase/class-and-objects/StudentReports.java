
 // Program to Simulate Student Report
 // Calculates grade based on marks and displays report.
 
class Student {
    String name;
    String rollNumber;
    double[] marks;

    public Student(String name, String rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate grade based on average
    public char calculateGrade() {
        double sum = 0;
        for (double m : marks) {
            sum += m;
        }
        double avg = sum / marks.length;

        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 50) return 'C';
        else return 'F';
    }

    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Mark" + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Grade " + calculateGrade());
    }
}

public class StudentReports {
    public static void main(String[] args) {
        double[] marks1 = {80.0, 70.0, 75.0};
        Student s1 = new Student("Thamarai", "ECE001", marks1);
        s1.displayDetails();

        double[] marks2 = {60.0, 65.0, 50.0};
        Student s2 = new Student("Kannan", "CSC002", marks2);
        s2.displayDetails();
    }
}