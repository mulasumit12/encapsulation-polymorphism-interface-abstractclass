import java.util.*;

// Abstract class Product
abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();

    public double getFinalPrice() {
        return price - calculateDiscount();
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Discount: " + calculateDiscount());
    }
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics subclass
class Electronics extends Product implements Taxable {
    private double discountRate = 0.10;
    private double taxRate = 0.15;

    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + (taxRate * 100) + "%";
    }
}

// Clothing subclass
class Clothing extends Product {
    private double discountRate = 0.20;

    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }
}

// Groceries subclass
class Groceries extends Product implements Taxable {
    private double taxRate = 0.05;

    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return 0; // No discount for groceries
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + (taxRate * 100) + "%";
    }
}

// Main class to test the system
public class ECommercePlatformTest {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Electronics("P001", "Laptop", 60000));
        products.add(new Clothing("P002", "T-Shirt", 1000));
        products.add(new Groceries("P003", "Rice", 500));

        for (Product product : products) {
            product.displayDetails();
            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }
            double finalPrice = product.getFinalPrice();
            if (product instanceof Taxable) {
                finalPrice += ((Taxable) product).calculateTax();
            }
            System.out.println("Final Price (after discount and tax): " + finalPrice);
            System.out.println();
        }
    }
}
