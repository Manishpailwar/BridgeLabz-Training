
 // Program to Handle Mobile Phone Details
 // Stores brand, model, and price.
 
class MobilePhone {
    String brand;
    String model;
    double price;

    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Brand of mobile: " + brand);
        System.out.println("Model of mobile: " + model);
        System.out.println("Price of mobile: " + price);
        System.out.println("------------------------------");
    }
}

public class MobileDetails {
    public static void main(String[] args) {
        MobilePhone m1 = new MobilePhone("VIVO", "VIVO V29", 15999.0);
        m1.displayDetails();

        MobilePhone m2 = new MobilePhone("ONE PLUS", "ONE PLUS nord4", 39999.0);
        m2.displayDetails();

        MobilePhone m3 = new MobilePhone("APPLE", "iphone pro16", 79999.0);
        m3.displayDetails();
    }
}