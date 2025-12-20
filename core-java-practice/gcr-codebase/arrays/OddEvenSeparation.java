import java.util.Scanner;

public class OddEvenSeparation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Error: Not a natural number.");
            sc.close();
            return;
        }

        // Calculate required size (approx half + 1 to be safe)
        int size = number / 2 + 1;
        int[] oddNumbers = new int[size];
        int[] evenNumbers = new int[size];
        int oddCount = 0, evenCount = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) evenNumbers[evenCount++] = i;
            else oddNumbers[oddCount++] = i;
        }

        System.out.print("Odd Numbers: ");
        for (int i = 0; i < oddCount; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        System.out.println();

        System.out.print("Even Numbers: ");
        for (int i = 0; i < evenCount; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        sc.close();
    }
}