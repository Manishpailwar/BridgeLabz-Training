import java.util.Scanner;

public class MetroSmartCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Metro Smart Card System ---");

        // Initialize balance
        System.out.print("Enter initial smart card balance: ");
        double balance = scanner.nextDouble();

        while (true) {
            System.out.println("\nCurrent Balance: Rs. " + balance);
            
            // Check if balance is exhausted (assuming minimum fare is 10)
            if (balance < 10) {
                System.out.println("Balance insufficient for minimum fare. Please recharge.");
                break;
            }

            System.out.print("Enter distance traveled in km (or -1 to exit): ");
            double distance = scanner.nextDouble();

            if (distance == -1) {
                System.out.println("Exiting station.");
                break;
            }

            if (distance < 0) {
                System.out.println("Invalid distance.");
                continue;
            }

            // Calculate fare using ternary operator
            // Logic: < 5km = Rs 10, 5km to 15km = Rs 20, > 15km = Rs 40
            double fare = (distance < 5) ? 10 : ((distance <= 15) ? 20 : 40);

            if (balance >= fare) {
                balance -= fare;
                System.out.println("Fare of Rs. " + fare + " deducted.");
            } else {
                System.out.println("Insufficient balance for this trip (Required: Rs. " + fare + ").");
            }
        }
        scanner.close();
    }
}
