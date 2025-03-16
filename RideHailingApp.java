// Abstract class Vehicle
abstract class Vehicle1 {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle1(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
    }
}

// Interface GPS
interface GPS {
    void getCurrentLocation();
    void updateLocation(String newLocation);
}

// Subclass Car
class Car1 extends Vehicle1 implements GPS {
    public Car1(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 12; // Rate for Car
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Fetching current location of Car...");
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Car location updated to: " + newLocation);
    }
}

// Subclass Bike
class Bike1 extends Vehicle1 implements GPS {
    public Bike1(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 8; // Rate for Bike
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Fetching current location of Bike...");
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Bike location updated to: " + newLocation);
    }
}

// Subclass Auto
class Auto1 extends Vehicle1 implements GPS {
    public Auto1(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 10; // Rate for Auto
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Fetching current location of Auto...");
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Auto location updated to: " + newLocation);
    }
}

// Main class to test the application
public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle1 car = new Car1("C123", "John Doe", 12);
        Vehicle1 bike = new Bike1("B456", "Alice Smith", 8);
        Vehicle1 auto = new Auto1("A789", "Bob Brown", 10);

        car.getVehicleDetails();
        System.out.println("Fare for 10 km: " + car.calculateFare(10));
        System.out.println();

        bike.getVehicleDetails();
        System.out.println("Fare for 10 km: " + bike.calculateFare(10));
        System.out.println();

        auto.getVehicleDetails();
        System.out.println("Fare for 10 km: " + auto.calculateFare(10));
    }
}
