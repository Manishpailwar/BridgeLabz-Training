
 // Program to Track Inventory of Items
 // Manages item code, name, and price.
 
class Item {
    String itemCode;
    String itemName;
    double price;

    public Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item details
    public void displayDetails() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + price);
        System.out.println("itemName : " + itemName);
        System.out.println("----------------------------");
    }

    public void calculateTotalCost(int quantity) {
        System.out.println("Total cost for " + quantity + " items: " + (price * quantity));
    }
}

public class InventoryTracker {
    public static void main(String[] args) {
        Item i1 = new Item("01AA", "Water bottle", 500.0);
        i1.displayDetails();

        Item i2 = new Item("01BB", "Rice", 700.0);
        i2.displayDetails();

        Item i3 = new Item("02AA", "blackboard", 400.0);
        i3.displayDetails();
    }
}