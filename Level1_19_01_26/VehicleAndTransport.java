package Level1_19_01_26;
class Vehicle{
    int maxSpeed;
    String fuelType;
    void displayDetails(){
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
    };
    Vehicle(int maxSpeed,String fuelType){
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    };
}
class Car extends Vehicle{
    int seatCapacity;
    @Override
    void displayDetails(){
        super.displayDetails();
        System.out.println("Seat Capacity: " + seatCapacity);
    };
    Car(int maxSpeed,String fuelType,int seatCapacity){
        super(maxSpeed,fuelType);
        this.seatCapacity = seatCapacity;
    };
}
class Truck extends Vehicle{
    int loadCapacity;
    @Override
    void displayDetails(){
        super.displayDetails();
        System.out.println("Load Capacity: " + loadCapacity);
    };
    Truck(int maxSpeed,String fuelType,int loadCapacity){
        super(maxSpeed,fuelType);
        this.loadCapacity = loadCapacity;
    };
}
class Motorcycle extends Vehicle{
    int engineCC;
    @Override
    void displayDetails(){
        super.displayDetails();
        System.out.println("Engine CC: " + engineCC);
    };
    Motorcycle(int maxSpeed,String fuelType,int engineCC){
        super(maxSpeed,fuelType);
        this.engineCC = engineCC;
    };
}
class VehicleAndTransport {
    public static void main(String[] args) {
        Car car = new Car(120,"CNG",5);
        car.displayDetails();
        Truck truck = new Truck(100,"Diesel",100);
        truck.displayDetails();
        Motorcycle motorcycle = new Motorcycle(200,"Petrol",250);
        motorcycle.displayDetails();
    }    
}
