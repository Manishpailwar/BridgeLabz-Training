import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        System.out.println("Enter numbers (enter 0 or negative to stop):");
        while (true) {
            if (index >= 10) break; // Stop if array is full

            double input = sc.nextDouble();
            if (input <= 0) break; // Stop on invalid input

            numbers[index] = input;
            index++;
        }

        System.out.println("Numbers entered:");
        // Calculate sum of entered numbers
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }
        System.out.println("Total sum: " + total);
        sc.close();
    }
}