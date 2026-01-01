
 // Program to Model a Movie Ticket Booking System
 // Handles booking logic and prevents double booking.
 
class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked;

    public MovieTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isBooked = false; // Initially not booked
    }

    public void bookTicket() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
        System.out.println(); // Spacing
    }
    
    public void checkStatus() {
        if(!isBooked) {
             System.out.println("Ticket have not booked yet....");
        }
    }
}

public class MovieBooking {
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Dragon", "A10", 120.0);

        ticket.checkStatus();
        
        ticket.bookTicket();
        ticket.bookTicket();
        ticket.bookTicket();
        
        System.out.println("Price: $" + ticket.price);
        System.out.println();
        
        System.out.println("Ticket booked for movie: " + ticket.movieName);
        System.out.println("Seat Number: " + ticket.seatNumber);
        System.out.println("Price: $" + ticket.price);
    }
}