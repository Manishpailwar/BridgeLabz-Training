import java.util.Scanner;

public class TriangularPark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the three sides of the triangular park (in meters):");
        double s1 = scanner.nextDouble();
        double s2 = scanner.nextDouble();
        double s3 = scanner.nextDouble();
        
        double rounds = calculateRounds(s1, s2, s3);
        System.out.println("Rounds needed to complete 5km: " + Math.ceil(rounds));
        scanner.close();
    }

    public static double calculateRounds(double s1, double s2, double s3) {
        double perimeter = s1 + s2 + s3;
        return 5000 / perimeter;
    }
}