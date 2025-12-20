import java.util.*;
public class CoffeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double GST_RATE = 0.18; // 18% GST
        System.out.println("Welcome to The Coffee Counter Chronicles!");
        System.out.println("Available Menu: Espresso, Latte, Cappuccino, Mocha");

        // Loop to handle multiple customers
        while (true) {
            System.out.println("\n------------------------------------------------");
            System.out.print("Enter coffee type (or type 'exit' to close): ");
            String coffeeType = scanner.next();

            // Check for exit condition to break the loop
            if (coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Closing the counter. Have a great day!");
                break;
            }
            double pricePerCup = 0;
            boolean validOrder = true;

            // Determine price based on coffee type
            switch (coffeeType.toLowerCase()) {
                case "espresso":
                    pricePerCup = 150.00;
                    break;
                case "latte":
                    pricePerCup = 200.00;
                    break;
                case "cappuccino":
                    pricePerCup = 220.00;
                    break;
                case "mocha":
                    pricePerCup = 250.00;
                    break;
                default:
                    System.out.println("Sorry, we don't serve that. Please choose from the menu.");
                    validOrder = false;
            }

            // If the order is valid, proceed to quantity and billing
            if (validOrder) {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();

                if (quantity > 0) {
                    double basePrice = pricePerCup * quantity;
                    double gstAmount = basePrice * GST_RATE;
                    double totalBill = basePrice + gstAmount;

                    System.out.println("\n--- Bill Details ---");
                    System.out.println("Item: " + coffeeType);
                    System.out.println("Base Price: " + basePrice);
                    System.out.println("GST (18%): " + String.format("%.2f", gstAmount));
                    System.out.println("Total Payable: " + String.format("%.2f", totalBill));
                } else {
                    System.out.println("Invalid quantity. Please try again.");
                }
            }
        }
        scanner.close();
    }
}