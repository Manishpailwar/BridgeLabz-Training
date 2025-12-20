import java.util.*;
public class SumOfNaturalNumbers3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        if (n > 0){
            int sumFormula = n * (n + 1) / 2;
            int sumLoop = 0;
            for (int i = 1; i <= n; i++) {
                sumLoop += i;
            }
            System.out.println("Sum using formula: "+sumFormula);
            System.out.println("Sum using for loop: "+sumLoop);
        }
        else 
            System.out.println("The number "+n+" is not a natural number");
        sc.close();
    }
}
