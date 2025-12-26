
public class EmployeeBonus {
    public static void main(String[] args) {
        // 10 employees, 2 columns: Salary, Years
        double[][] employeeData = generateEmployeeData();
        double[][] newData = calculateBonus(employeeData);

        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("ID\tOld Salary\tYears\tBonus\tNew Salary");
        for (int i = 0; i < 10; i++) {
            double oldSal = employeeData[i][0];
            double years = employeeData[i][1];
            double newSal = newData[i][0];
            double bonus = newData[i][1];

            totalOldSalary += oldSal;
            totalNewSalary += newSal;
            totalBonus += bonus;

            System.out.printf("%d\t%.2f\t%.0f\t%.2f\t%.2f\n", (i + 1), oldSal, years, bonus, newSal);
        }

        System.out.println("\nTotal Old Salary: " + String.format("%.2f", totalOldSalary));
        System.out.println("Total Bonus Payout: " + String.format("%.2f", totalBonus));
        System.out.println("Total New Salary: " + String.format("%.2f", totalNewSalary));
        
    }

    public static double[][] generateEmployeeData() {
        double[][] data = new double[10][2];
        for (int i = 0; i < 10; i++) {
            data[i][0] = 10000 + (int)(Math.random() * 90000); // Salary 10k-99k
            data[i][1] = (int)(Math.random() * 15); // Years 0-14
        }
        return data;
    }

    public static double[][] calculateBonus(double[][] data) {
        double[][] result = new double[10][2]; // Col 0: New Salary, Col 1: Bonus
        for (int i = 0; i < 10; i++) {
            double bonusRate = (data[i][1] > 5) ? 0.05 : 0.02;
            double bonus = data[i][0] * bonusRate;
            result[i][1] = bonus;
            result[i][0] = data[i][0] + bonus;
        }
        return result;
    }
}