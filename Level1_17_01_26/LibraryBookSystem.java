package Level1_16_01_26;

class BookC{
    String title;
    String author;
    int price;
    boolean availability;

    BookC(String title, String author, int price,boolean availability){
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

        void borrow() {
            if (availability) {
                System.out.println("Book issued successfully!");
                availability = false;
            } else {
                System.out.println("Sorry, the book is not available.");
            }
        }
}
public class LibraryBookSystem {
    public static void main(String[] args) {
        BookC b1 = new BookC("Java Basics", "John Doe", 500, true);

        b1.borrow();

        b1.borrow();
    }
}
