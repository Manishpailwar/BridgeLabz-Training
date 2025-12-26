import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year (>= 1582): ");
        int year = scanner.nextInt();

        if (year < 1582) {
            System.out.println("The LeapYear program only works for year >= 1582.");
        } else {
            if (checkLeapYear(year)) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is not a Leap Year.");
            }
        }
        scanner.close();
    }

    public static boolean checkLeapYear(int year) {
        // Divisible by 4 AND (not divisible by 100 OR divisible by 400)
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }
}