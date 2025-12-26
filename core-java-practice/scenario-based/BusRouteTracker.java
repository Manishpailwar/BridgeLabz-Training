import java.util.Scanner;

public class BusRouteTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalDistance = 0.0;

        System.out.println("--- Bus Route Distance Tracker ---");
        System.out.println("Bus has started. Enter distance for each stop.");

        // Loop to track journey
        while (true) {
            System.out.print("\nEnter distance to next stop (km): ");

            if (scanner.hasNextDouble()) {
                double distance = scanner.nextDouble();

                if (distance < 0) {
                    System.out.println("Distance cannot be negative. Please try again.");
                    continue;
                }

                totalDistance += distance;
                System.out.println("Arrived at stop. Total distance covered: " + String.format("%.2f", totalDistance) + " km");

                System.out.print("Do you want to get off here? (yes/no): ");
                String response = scanner.next();

                if (response.equalsIgnoreCase("yes")) {
                    System.out.println("Journey ended. Total distance travelled: " + String.format("%.2f", totalDistance) + " km. Thank you!");
                    break;
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value for distance.");
                scanner.next(); // Clear invalid input
            }
        }
        scanner.close();
    }
}