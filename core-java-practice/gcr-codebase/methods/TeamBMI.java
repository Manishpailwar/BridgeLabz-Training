import java.util.Scanner;

public class TeamBMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 10 rows, 3 columns: Weight, Height, BMI
        double[][] data = new double[10][3];

        System.out.println("Enter details for 10 team members:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Height (cm): ");
            data[i][1] = scanner.nextDouble();
        }

        calculateBMI(data);

        System.out.println("\n--- BMI Report ---");
        System.out.printf("%-10s %-10s %-10s %-10s %-15s%n", "Person", "Weight", "Height", "BMI", "Status");
        for (int i = 0; i < 10; i++) {
            String status = getBMIStatus(data[i][2]);
            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-15s%n", 
                (i + 1), data[i][0], data[i][1], data[i][2], status);
        }
        scanner.close();
    }

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0; // Convert cm to meters
            
            if (heightM > 0) {
                double bmi = weight / (heightM * heightM);
                data[i][2] = bmi;
            } else {
                data[i][2] = 0;
            }
        }
    }

    public static String getBMIStatus(double bmi) {
        if (bmi <= 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}