class FoodOrder {
    private String customerName;
    private String foodItem;
    private int quantity;
    private double price;

    // Fixed rate for all food items
    private static final double FIXED_RATE = 150.0;

    // 1. Default constructor → assigns "Unknown" order
    public FoodOrder() {
        this.customerName = "Unknown";
        this.foodItem = "Unknown";
        this.quantity = 0;
        this.price = 0.0;
    }

    // 2. Constructor with food item → sets quantity = 1, price = default
    public FoodOrder(String foodItem) {
        this.customerName = "Unknown";
        this.foodItem = foodItem;
        this.quantity = 1;
        this.price = FIXED_RATE; // default price
    }

    // 3. Constructor with food item and quantity → price = quantity × fixedRate
    public FoodOrder(String foodItem, int quantity) {
        this.customerName = "Unknown";
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = quantity * FIXED_RATE;
    }

    // 4. Full constructor (optional if customerName is needed)
    public FoodOrder(String customerName, String foodItem, int quantity) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = quantity * FIXED_RATE;
    }

    // Method: printBill
    public void printBill() {
        System.out.println("🍔 Food Order Bill");
        System.out.println("Customer: " + customerName);
        System.out.println("Food Item: " + foodItem);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: ₹" + price);
        System.out.println("-------------------------");
    }
}

// Main class
public class FoodDeliverySystem {
    public static void main(String[] args) {
        // Creating orders with different constructors
        FoodOrder order1 = new FoodOrder();  // Default
        FoodOrder order2 = new FoodOrder("Burger");  // Food only
        FoodOrder order3 = new FoodOrder("Pizza", 3);  // Food + Quantity
        FoodOrder order4 = new FoodOrder("Aayati", "Pasta", 2);  // Full details

        // Print bills
        order1.printBill();
        order2.printBill();
        order3.printBill();
        order4.printBill();
    }
}
