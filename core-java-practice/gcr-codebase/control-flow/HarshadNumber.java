import java.util.*;
public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = sc.nextInt();
        int temp = number;
        int sum = 0;
        while (temp != 0) {
            int remainder = temp % 10;
            sum += remainder;
            temp /= 10;
        }
        if (sum != 0 && number % sum == 0)
            System.out.println(number + " is a Harshad Number");
        else
            System.out.println(number + " is not a Harshad Number");
        sc.close();
    }
}
