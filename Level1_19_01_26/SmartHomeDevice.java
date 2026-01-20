package Level1_19_01_26;
class Device {
    int deviceID;
    String status;
    Device(int deviceID,String status){
        this.deviceID = deviceID;
        this.status = status;
    }
    void display(){
        System.out.println(deviceID + " " + status);
    }
}
class Thermostat extends Device{
    int temperatureSetting;
    Thermostat(int deviceID,String status,int temperatureSetting){
        super(deviceID,status);
        this.temperatureSetting = temperatureSetting;
    }
    void display(){
        super.display();
        System.out.println(temperatureSetting);
    }
}
class SmartHomeDevice {
    public static void main(String[] args) {
        Thermostat t1 = new Thermostat(1,"On",25);
        t1.display();
    }
}
