interface GPS {
    String getCurrentLocation();

    void updateLocation(String location);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per KM: " + ratePerKm);
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }
}

class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
        System.out.println("Car location updated to: " + location);
    }
}

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
        System.out.println("Bike location updated to: " + location);
    }
}

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 30;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
        System.out.println("Auto location updated to: " + location);
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle[] rides = new Vehicle[3];
        rides[0] = new Car("C1", "Sam", 12);
        rides[1] = new Bike("B1", "Leo", 5);
        rides[2] = new Auto("A1", "Raj", 8);

        double distance = 10.5;
        System.out.println("--- Ride-Hailing Application ---");
        for (Vehicle v : rides) {
            if (v != null) {
                v.getVehicleDetails();
                System.out.println("Fare for " + distance + " km: " + v.calculateFare(distance));
                if (v instanceof GPS) {
                    GPS g = (GPS) v;
                    g.updateLocation("Point A");
                    System.out.println("Current Location: " + g.getCurrentLocation());
                }
            }
        }
    }
}
