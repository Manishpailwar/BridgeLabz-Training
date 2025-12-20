import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number and power:");
        int number = sc.nextInt();
        int power = sc.nextInt();

        if (number > 0 && power >= 0) {
            long result = 1;
            for (int i = 1; i <= power; i++) {
                result *= number;
            }
            System.out.println("Result: " + result);
        } else {
             System.out.println("Please enter positive integers.");
        }
        sc.close();
    }
}