import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();

        // Define formatters
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Display formatted dates
        System.out.println("Format 1 (dd/MM/yyyy): " + currentDate.format(fmt1));
        System.out.println("Format 2 (yyyy-MM-dd): " + currentDate.format(fmt2));
        System.out.println("Format 3 (EEE, MMM dd, yyyy): " + currentDate.format(fmt3));
    }
}