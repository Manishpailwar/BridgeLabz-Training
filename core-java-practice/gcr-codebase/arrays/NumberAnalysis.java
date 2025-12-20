import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        // Iterate to check properties of each number
        for (int num : numbers) {
            if (num > 0) {
                // Nested check for even/odd on positive numbers
                if (num % 2 == 0) System.out.println(num + " is Positive and Even");
                else System.out.println(num + " is Positive and Odd");
            } else if (num < 0) {
                System.out.println(num + " is Negative");
            } else {
                System.out.println("Number is Zero");
            }
        }

        // Compare first and last elements
        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        if (first == last) System.out.println("First and last elements are equal.");
        else if (first > last) System.out.println("First element is greater than last.");
        else System.out.println("First element is less than last.");
        sc.close();
    }
}