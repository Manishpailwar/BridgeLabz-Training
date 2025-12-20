import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        String numStr = Integer.toString(Math.abs(number));
        int[] digits = new int[numStr.length()];
        int temp = Math.abs(number);

        // Store digits
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        System.out.print("Reversed Array: ");
        // Print in reverse order
        for (int i = digits.length - 1; i >= 0; i--) {
            System.out.print(digits[i] + " ");
        }
        sc.close();
    }
}