package level2_15_01_26;
class MovieTicket {
    String movieName;
    int seatNumber;
    double price;

    void bookTicket(int seat, double ticketPrice) {
        seatNumber = seat;
        price = ticketPrice;
        System.out.println("Ticket Booked Successfully");
    }

    void displayTicketDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.movieName = "Border 2";
        ticket.bookTicket(10, 450.00);
        ticket.displayTicketDetails();
    }
}
