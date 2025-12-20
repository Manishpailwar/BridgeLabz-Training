import java.util.*;
public class OddEvenRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = sc.nextInt();
        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0)
                    System.out.println(i + " is even");
                else
                    System.out.println(i + " is odd");
            }
        }
        else
            System.out.println("The number " + number + " is not a natural number");
        sc.close();
    }
}
