import java.util.*;

// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public abstract int getLoanDuration();
}

// Interface Reservable
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Book subclass
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days loan period
    }

    @Override
    public void reserveItem() {
        System.out.println("Book reserved successfully.");
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

// Magazine subclass
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days loan period
    }
}

// DVD subclass
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days loan period
    }

    @Override
    public void reserveItem() {
        System.out.println("DVD reserved successfully.");
    }

    @Override
    public boolean checkAvailability() {
        return false;
    }
}

// Main class to test the library system
public class LibraryManagementTest {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("B001", "Java Programming", "James Gosling"));
        items.add(new Magazine("M001", "Tech Today", "Editorial Team"));
        items.add(new DVD("D001", "Inception", "Christopher Nolan"));

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem();
                System.out.println("Availability: " + ((Reservable) item).checkAvailability());
            }
            System.out.println();
        }
    }
}
