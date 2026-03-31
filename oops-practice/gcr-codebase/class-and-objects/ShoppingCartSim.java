
 // Program to Simulate a Shopping Cart Item
 // Manages quantity and total cost of a specific item.
 
class CartItem {
    String itemName;
    double price;
    int quantity;

    public CartItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = 0;
    }

    // Add items to the cart
    public void add(int count) {
        this.quantity += count;
        System.out.println("Added " + count + " of " + itemName + " to the cart.");
    }

    // Remove items from the cart
    public void remove(int count) {
        if (quantity >= count) {
            this.quantity -= count;
            System.out.println("Removed " + count + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove. Not enough items in cart.");
        }
    }

    // Display total cost
    public void displayTotalCost() {
        double total = price * quantity;
        System.out.println("Total cost: $" + total);
    }
    
    public void displayStatus() {
         System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }
}

public class ShoppingCartSim {
    public static void main(String[] args) {
        CartItem item = new CartItem("Laptop", 999.99);
        
        item.add(1); 
        
        item.displayStatus();
        
        item.add(2);
        item.remove(1);
        item.displayTotalCost();
    }
}