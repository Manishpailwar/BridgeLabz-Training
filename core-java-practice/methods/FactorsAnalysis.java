import java.util.Scanner;

public class FactorsAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] factors = findFactors(number);
        System.out.print("Factors: ");
        for(int f : factors) System.out.print(f + " ");
        System.out.println();

        System.out.println("Greatest Factor: " + findGreatestFactor(factors));
        System.out.println("Sum of Factors: " + sumFactors(factors));
        System.out.println("Product of Factors: " + productFactors(factors));
        System.out.println("Product of Cube of Factors: " + productCubeFactors(factors));
        scanner.close();
    }

    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) factors[idx++] = i;
        }
        return factors;
    }

    public static int findGreatestFactor(int[] factors) {
        int max = factors[0];
        for (int f : factors) if (f > max) max = f;
        return max;
    }

    public static int sumFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    public static long productFactors(int[] factors) {
        long prod = 1;
        for (int f : factors) prod *= f;
        return prod;
    }

    public static double productCubeFactors(int[] factors) {
        double prod = 1;
        for (int f : factors) prod *= Math.pow(f, 3);
        return prod;
    }
}