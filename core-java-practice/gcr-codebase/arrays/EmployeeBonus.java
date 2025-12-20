import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] years = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        // Input loop with validation
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary and years of service for employee " + (i + 1) + ": ");
            double s = sc.nextDouble();
            double y = sc.nextDouble();
            if (s <= 0 || y < 0) {
                System.out.println("Invalid input. Please enter positive values.");
                i--; // Decrement index to retry this iteration
                continue;
            }
            salaries[i] = s;
            years[i] = y;
        }

        // Calculate bonus and totals
        for (int i = 0; i < 10; i++) {
            double bonusPct = (years[i] > 5) ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusPct;
            newSalaries[i] = salaries[i] + bonuses[i];
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        sc.close();
    }
}