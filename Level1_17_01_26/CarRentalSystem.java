package Level1_16_01_26;

class Car{
    String customerName;
    String carModel;
    int rentalDays;

    Car(String name, String model,int days){
        this.customerName = name;
        this.carModel = model;
        this.rentalDays = days;

        totalCost(days);
    }

    private void totalCost(int days) {
        double costPerDay = 1000;
        double cost = costPerDay * days ;
        System.out.println(cost);

    }
}
public class CarRentalSystem {
    public static void main(String[] args) {
        Car c1 = new Car("Khushi","hero",5);

    }
}
