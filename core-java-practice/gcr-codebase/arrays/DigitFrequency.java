import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = sc.nextLong();
        long temp = Math.abs(number);
        
        // Count digits
        int count = (temp == 0) ? 1 : 0;
        long t = temp;
        while (t > 0) { t /= 10; count++; }

        // Store digits in array
        int[] digits = new int[count];
        t = temp;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = (int)(t % 10);
            t /= 10;
        }

        // Calculate frequency
        int[] frequency = new int[10];
        for (int d : digits) frequency[d]++;

        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) System.out.println("Frequency of " + i + " = " + frequency[i]);
        }
        sc.close();
    }
}