import java.util.Scanner;

public class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Diwali Mela Festival Lucky Draw ---");
        System.out.println("Enter your ticket number to see if you won! (Type 'exit' to close)");

        // Loop for multiple visitors
        while (true) {
            System.out.print("\nEnter Ticket Number: ");

            // Check if input is an integer
            if (scanner.hasNextInt()) {
                int ticketNumber = scanner.nextInt();

                if (ticketNumber <= 0) {
                    System.out.println("Invalid ticket number. Please enter a positive integer.");
                    continue;
                }

                // Winning condition: Divisible by both 3 and 5
                if (ticketNumber % 3 == 0 && ticketNumber % 5 == 0) {
                    System.out.println("🎉 Congratulations! Ticket " + ticketNumber + " wins a special gift!");
                } else {
                    System.out.println("Better luck next time!");
                }
            } else {
                // Handle non-integer input (check for exit or invalid)
                String input = scanner.next();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Lucky Draw Counter Closed. Happy Diwali!");
                    break;
                }
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        scanner.close();
    }
}