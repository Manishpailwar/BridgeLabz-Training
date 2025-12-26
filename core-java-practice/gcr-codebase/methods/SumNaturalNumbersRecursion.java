import java.util.Scanner;

public class SumNaturalNumbersRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number n: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a natural number (greater than 0).");
        } else {
            int sumRec = sumRecursive(n);
            int sumForm = sumFormula(n);

            System.out.println("Sum using Recursion: " + sumRec);
            System.out.println("Sum using Formula: " + sumForm);

            if (sumRec == sumForm) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("Discrepancy found.");
            }
        }
        scanner.close();
    }

    public static int sumRecursive(int n) {
        if (n == 1) return 1;
        return n + sumRecursive(n - 1);
    }

    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }
}