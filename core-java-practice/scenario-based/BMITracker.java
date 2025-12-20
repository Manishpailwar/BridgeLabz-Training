import java.util.*;
public class BMITracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Maya's BMI Fitness Tracker ---");

        // Input: Weight in Kilograms
        System.out.print("Enter weight in kg: ");
        double weightInKg = scanner.nextDouble();

        // Input: Height in Meters
        System.out.print("Enter height in meters: ");
        double heightInMeters = scanner.nextDouble();

        // Validate input to prevent division by zero or negative values
        if (weightInKg > 0 && heightInMeters > 0) {
            // Calculation: BMI = weight / (height * height)
            double bmiValue = weightInKg / (heightInMeters * heightInMeters);

            // Output the calculated BMI
            System.out.println("Your BMI is: " + String.format("%.2f", bmiValue));

            // Determine BMI Category
            if (bmiValue < 18.5) {
                System.out.println("Category: Underweight");
            } else if (bmiValue >= 18.5 && bmiValue <= 24.9) {
                System.out.println("Category: Normal Weight");
            } else {
                System.out.println("Category: Overweight");
            }
        } else {
            System.out.println("Invalid input. Height and weight must be positive numbers.");
        }

        scanner.close();
    }
}