import java.util.Scanner;

public class FactorialRecursion {
    public static void main(String[] args) {
        int number = getInput();
        long result = calculateFactorial(number);
        displayOutput(number, result);
    }

    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();
        return n;
    }

    public static long calculateFactorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * calculateFactorial(n - 1);
    }

    public static void displayOutput(int n, long result) {
        System.out.println("Factorial of " + n + " is " + result);
    }
}