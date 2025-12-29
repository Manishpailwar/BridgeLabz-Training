import java.time.LocalDate;

public class DateComparison {
    public static void main(String[] args) {
        // Define two dates for comparison
        LocalDate date1 = LocalDate.of(2023, 12, 25);
        LocalDate date2 = LocalDate.now();

        System.out.println("Date 1: " + date1);
        System.out.println("Date 2: " + date2);

        if (date1.isBefore(date2)) {
            System.out.println("Date 1 is before Date 2");
        } else if (date1.isAfter(date2)) {
            System.out.println("Date 1 is after Date 2");
        } else {
            System.out.println("Date 1 is equal to Date 2");
        }
    }
}
