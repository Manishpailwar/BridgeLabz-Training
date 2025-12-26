import java.util.Scanner;

public class TrigFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double degrees = scanner.nextDouble();
        
        double[] results = calculateTrigonometricFunctions(degrees);
        System.out.println("Sine: " + results[0]);
        System.out.println("Cosine: " + results[1]);
        System.out.println("Tangent: " + results[2]);
        scanner.close();
    }

    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        return new double[]{Math.sin(radians), Math.cos(radians), Math.tan(radians)};
    }
}