package Level1_16_01_26;

class HotelBooking{
    String guestName;
    String roomType;
    int nights;

    HotelBooking(){
        System.out.println("Default Constructor");
    }

    HotelBooking(String name, String type,int nights){
        this.guestName =name;
        this.roomType = type;
        this.nights = nights;

    }

    HotelBooking(HotelBooking h2){
        this.guestName =h2.guestName;
        this.roomType = h2.roomType;
        this.nights = h2.nights;
    }

}
public class HotelBookingSystem {
    public static void main(String[] args) {
        HotelBooking h1 = new HotelBooking();
        HotelBooking h2 = new HotelBooking("asdf","wer",2);
        HotelBooking h3 = new HotelBooking(h2);

        System.out.println(h2.guestName+" "+h2.roomType+" "+h2.nights);
        System.out.println(h3.guestName+" " +h3.roomType+" "+h3.nights);

    }
}

