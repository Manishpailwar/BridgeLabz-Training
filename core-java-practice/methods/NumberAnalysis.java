import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\nAnalysis:");
        for (int num : numbers) {
            if (isPositive(num)) {
                if (isEven(num)) {
                    System.out.println(num + " is Positive and Even");
                } else {
                    System.out.println(num + " is Positive and Odd");
                }
            } else {
                System.out.println(num + " is Negative");
            }
        }

        int comparison = compare(numbers[0], numbers[numbers.length - 1]);
        System.out.print("\nComparison of First (" + numbers[0] + ") and Last (" + numbers[numbers.length - 1] + "): ");
        if (comparison == 1) {
            System.out.println("First is Greater");
        } else if (comparison == -1) {
            System.out.println("First is Smaller");
        } else {
            System.out.println("Both are Equal");
        }
        scanner.close();
    }

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int n1, int n2) {
        if (n1 > n2) return 1;
        if (n1 < n2) return -1;
        return 0;
    }
}