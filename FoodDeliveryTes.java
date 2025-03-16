import java.util.*;

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

// Interface Discountable
interface Discountable {
    void applyDiscount(double percentage);
    double getDiscountDetails();
}

// VegItem subclass
class VegItem extends FoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() - getDiscountDetails();
    }

    @Override
    public void applyDiscount(double percentage) {
        this.discount = (getPrice() * getQuantity()) * (percentage / 100);
    }

    @Override
    public double getDiscountDetails() {
        return discount;
    }
}

// NonVegItem subclass
class NonVegItem extends FoodItem implements Discountable {
    private double additionalCharge;
    private double discount;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.additionalCharge = 20; // Extra charge for non-veg items
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity() + additionalCharge) - getDiscountDetails();
    }

    @Override
    public void applyDiscount(double percentage) {
        this.discount = (getPrice() * getQuantity()) * (percentage / 100);
    }

    @Override
    public double getDiscountDetails() {
        return discount;
    }
}

// Main class to test the food delivery system
public class FoodDeliveryTes {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        VegItem vegBurger = new VegItem("Veg Burger", 100, 2);
        NonVegItem chickenPizza = new NonVegItem("Chicken Pizza", 300, 1);

        vegBurger.applyDiscount(10);
        chickenPizza.applyDiscount(5);

        order.add(vegBurger);
        order.add(chickenPizza);

        for (FoodItem item : order) {
            item.getItemDetails();
            System.out.println("Total Price after Discount: " + item.calculateTotalPrice());
            System.out.println();
        }
    }
}
