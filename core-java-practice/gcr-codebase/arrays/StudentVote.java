import java.util.Scanner;

public class StudentVote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10]; // Array to store ages of 10 students

        System.out.println("Enter ages for 10 students:");
        // Loop to capture user input
        for (int i = 0; i < ages.length; i++) {
            ages[i] = sc.nextInt();
        }

        // Check eligibility for each student
        for (int age : ages) {
            if (age < 0) {
                System.out.println("Invalid age entered.");
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }
        sc.close();
    }
}