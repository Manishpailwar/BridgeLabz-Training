import java.util.Scanner;

public class PowerWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number and power:");
        int number = sc.nextInt();
        int power = sc.nextInt();

        if (number > 0 && power >= 0) {
            long result = 1;
            int counter = 0;
            while (counter < power) {
                result *= number;
                counter++;
            }
            System.out.println("Result: " + result);
        } else {
             System.out.println("Please enter positive integers.");
        }
        sc.close();
    }
}