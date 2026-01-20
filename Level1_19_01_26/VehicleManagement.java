package Level1_19_01_26;
class Vehicle{
    int maxSpeed;
    String model;
    Vehicle(int maxSpeed,String model){
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}
interface Refuelable{
    void refuel();
}
class PetrolVehicle extends Vehicle implements Refuelable{
    PetrolVehicle(int maxSpeed,String model){
        super(maxSpeed,model);
    }
    @Override
    public void refuel(){
        System.out.println("Petrol Vehicle Refueled");
    }
}
class ElectricVehicle extends Vehicle{
    ElectricVehicle(int maxSpeed,String model){
        super(maxSpeed,model);
    }
    void charge(){
        System.out.println("Electric Vehicle Charged");
    }
}
class VehicleManagement {
    public static void main(String[] args) {
        PetrolVehicle p1 = new PetrolVehicle(120,"Model X");
        p1.refuel();
        ElectricVehicle e1 = new ElectricVehicle(120,"Model X");
        e1.charge();
    }
}
