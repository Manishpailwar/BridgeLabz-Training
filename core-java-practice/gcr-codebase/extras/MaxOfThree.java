import java.util.Scanner;

public class MaxOfThree {
    public static void main(String[] args) {
        int[] numbers = getInput();
        int max = findMax(numbers[0], numbers[1], numbers[2]);
        System.out.println("The maximum number is: " + max);
    }

    public static int[] getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three integers:");
        int[] nums = new int[3];
        nums[0] = scanner.nextInt();
        nums[1] = scanner.nextInt();
        nums[2] = scanner.nextInt();
        scanner.close();
        return nums;
    }

    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}