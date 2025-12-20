import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter weight in kg:");
        double weight = sc.nextDouble();
        
        System.out.println("Enter height in cm:");
        double heightCm = sc.nextDouble();
        
        // Convert height from cm to meters
        double heightM = heightCm / 100;
        
        if (weight > 0 && heightM > 0) {
            double bmi = weight / (heightM * heightM);
            System.out.println("Your BMI is: " + bmi);
            
            if (bmi < 18.5) System.out.println("Status: Underweight");
            else if (bmi < 25) System.out.println("Status: Normal weight");
            else if (bmi < 30) System.out.println("Status: Overweight");
            else System.out.println("Status: Obese");
        } else {
            System.out.println("Invalid input. Weight and height must be positive.");
        }
        sc.close();
    }
}
