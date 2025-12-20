import java.util.*;
public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = sc.nextInt();
        if (num > 0){
            long factorial = 1;
            int i = 1;
            while (i <= num) {
                factorial *= i;
                i++;
            }
            System.out.println("The factorial of "+num+" is "+factorial);
        }
        else
            System.out.println("The number "+num+" is not a positive integer");
        sc.close();
    }
}
