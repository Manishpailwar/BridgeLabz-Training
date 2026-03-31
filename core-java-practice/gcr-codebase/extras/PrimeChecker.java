import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        int number = getInput();
        boolean isPrime = checkPrime(number);
        System.out.println(number + (isPrime ? " is a prime number." : " is not a prime number."));
    }

    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();
        return n;
    }

    public static boolean checkPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}