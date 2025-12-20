import java.util.*;
public class SumUntilZero2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        while (true) {
            System.out.println("Enter a number");
            double number = sc.nextDouble();
            if (number <= 0)
            break;
            total += number;
        }
        System.out.println("The total value is "+total);
        sc.close();
    }
}
