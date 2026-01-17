package Level1_16_01_26;

class Vehicle{
    String ownerName;
    String vehicleType;

    static int registrationFee = 500;

    Vehicle(String name,String type){
        this.ownerName = name;
        this.vehicleType = type;
    }
    void displayVehicleDetails(){
        System.out.println(ownerName);
        System.out.println(vehicleType);
        System.out.println(registrationFee);
    }
    static void updateRegistrationFee(){
        registrationFee = 5000;
    }
}
public class VehicleRegistration {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("khushi","hero");

        v1.displayVehicleDetails();
        Vehicle.updateRegistrationFee();
        v1.displayVehicleDetails();

    }
}
