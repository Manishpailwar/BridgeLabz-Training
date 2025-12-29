import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        System.out.println("Think of a number between 1 and 100.");
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int low = 1;
        int high = 100;
        boolean guessed = false;
        Random random = new Random();

        while (!guessed) {
            if (low > high) {
                System.out.println("Something went wrong. The range is invalid. Did you make a mistake in feedback?");
                break;
            }
            
            // Generate a random guess within the current range
            int guess = low + random.nextInt(high - low + 1);
            System.out.println("Is your number " + guess + "? (Enter 'high' if guess is too high, 'low' if too low, 'correct' if correct)");
            String feedback = scanner.next();

            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Computer guessed your number!");
                guessed = true;
            } else if (feedback.equalsIgnoreCase("high")) {
                // Guess was too high, so the number must be smaller
                high = guess - 1;
            } else if (feedback.equalsIgnoreCase("low")) {
                // Guess was too low, so the number must be larger
                low = guess + 1;
            } else {
                System.out.println("Please enter valid feedback: 'high', 'low', or 'correct'.");
            }
        }
        scanner.close();
    }
}