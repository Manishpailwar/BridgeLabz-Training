
 // Program to Handle Book Details
 // Stores and displays title, author, and price.
 
class Book {
    String title;
    String author;
    double price;

    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }
}

public class BookDetails {
    public static void main(String[] args) {
        Book b1 = new Book("2States", "Chetan Bhagat", 500.0);
        b1.displayDetails();

        Book b2 = new Book("Wings Of Fire", "Abdul kalam.A.P.J", 500.0);
        b2.displayDetails();
    }
}