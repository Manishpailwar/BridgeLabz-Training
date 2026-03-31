import java.util.Scanner;

public class CollinearPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x1 y1: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        System.out.println("Enter x2 y2: ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        System.out.println("Enter x3 y3: ");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        boolean slopeCollinear = checkCollinearSlope(x1, y1, x2, y2, x3, y3);
        boolean areaCollinear = checkCollinearArea(x1, y1, x2, y2, x3, y3);

        System.out.println("Collinear (Slope Method): " + slopeCollinear);
        System.out.println("Collinear (Area Method): " + areaCollinear);
        scanner.close();
    }

    public static boolean checkCollinearSlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        // (y2 - y1) / (x2 - x1) == (y3 - y2) / (x3 - x2)
        // To avoid division by zero, use cross multiplication: (y2-y1)*(x3-x2) == (y3-y2)*(x2-x1)
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }

    public static boolean checkCollinearArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Area = 0.5 * |x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2)|
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return Math.abs(area) < 1e-9; // Check if close to 0
    }
}