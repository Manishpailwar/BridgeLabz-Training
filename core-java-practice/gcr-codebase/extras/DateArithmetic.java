import java.time.LocalDate;

public class DateArithmetic {
    public static void main(String[] args) {
        // Taking current date as input
        LocalDate inputDate = LocalDate.now();
        System.out.println("Input Date: " + inputDate);

        // Add 7 days, 1 month, and 2 years
        LocalDate intermediateDate = inputDate.plusDays(7)
                                              .plusMonths(1)
                                              .plusYears(2);
        System.out.println("After adding 7 days, 1 month, 2 years: " + intermediateDate);

        // Subtract 3 weeks from the result
        LocalDate finalDate = intermediateDate.minusWeeks(3);
        System.out.println("After subtracting 3 weeks: " + finalDate);
    }
}