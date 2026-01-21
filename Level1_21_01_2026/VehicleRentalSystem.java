interface Insurable {
    double calculateInsurance();

    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public void displayVehicleInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: " + rentalRate + "/day");
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }
}

class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy: " + insurancePolicyNumber + " , Cost: " + calculateInsurance();
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.5;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy: " + insurancePolicyNumber + " (Cost: " + calculateInsurance() + ")";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] fleet = new Vehicle[3];
        fleet[0] = new Car("KA-01-1234", 1500, "INS-CAR-001");
        fleet[1] = new Bike("KA-02-5678", 500);
        fleet[2] = new Truck("KA-03-9012", 5000, "INS-TRK-002");

        int rentalDays = 5;
        System.out.println("--- Vehicle Rental System ---");
        for (Vehicle v : fleet) {
            if (v != null) {
                v.displayVehicleInfo();
                System.out
                        .println("Total Rental Cost for " + rentalDays + " days: " + v.calculateRentalCost(rentalDays));
                if (v instanceof Insurable) {
                    System.out.println(((Insurable) v).getInsuranceDetails());
                } else {
                    System.out.println("Insurance: Not Applicable");
                }
            }
        }
    }
}
