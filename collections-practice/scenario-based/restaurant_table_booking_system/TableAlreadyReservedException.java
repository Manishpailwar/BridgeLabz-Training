package restaurant_table_booking_system;

public class TableAlreadyReservedException extends Exception {

    public TableAlreadyReservedException(String message) {
        super(message);
    }

    
}