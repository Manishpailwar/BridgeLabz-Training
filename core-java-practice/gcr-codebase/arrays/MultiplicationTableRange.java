import java.util.Scanner;

public class MultiplicationTableRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int[] results = new int[4]; // Stores results for 6, 7, 8, 9

        // Loop from 6 to 9
        for (int i = 6; i <= 9; i++) {
            results[i - 6] = number * i;
        }

        // Display stored results
        for (int i = 0; i < results.length; i++) {
            System.out.println(number + " * " + (i + 6) + " = " + results[i]);
        }
        sc.close();
    }
}