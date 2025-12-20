import java.util.*;
public class SumOfNaturalNumbers2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        if (n > 0){
            int sumFormula = n*(n + 1) /2;
            int sumLoop = 0;
            int i = 1;
            while (i <= n) {
                sumLoop += i;
                i++;
            }
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using while loop: " + sumLoop);
            if (sumFormula == sumLoop){
                System.out.println("Both computations are correct.");
            }
            else
                System.out.println("Computations differ.");
        }
        else
            System.out.println("The number " + n + " is not a natural number");
        sc.close();
    }
}
