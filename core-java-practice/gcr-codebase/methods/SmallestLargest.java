import java.util.Scanner;

public class SmallestLargest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 3 numbers:");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        
        int[] result = findSmallestAndLargest(n1, n2, n3);
        System.out.println("Smallest: " + result[0]);
        System.out.println("Largest: " + result[1]);
        scanner.close();
    }

    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int min = Math.min(number1, Math.min(number2, number3));
        int max = Math.max(number1, Math.max(number2, number3));
        
        return new int[]{min, max};
    }
}