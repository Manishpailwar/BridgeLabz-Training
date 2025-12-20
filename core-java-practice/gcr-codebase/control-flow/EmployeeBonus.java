import java.util.*;
public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter salary");
        double salary = sc.nextDouble();
        System.out.println("Enter years of service");
        int years = sc.nextInt();
        if (years > 5)
            System.out.println("Bonus amount is " + (salary * 0.05));
        else
            System.out.println("Bonus amount is 0");
        sc.close();
    }
}
