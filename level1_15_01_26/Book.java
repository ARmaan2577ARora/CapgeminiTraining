package level1_15_01_26;
class Book {
    String title;
    String author;
    double price;
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
    public static void main(String[] args) {
        Book b = new Book();
        b.title = "Java Programming";
        b.author = "Jimmy Doe";
        b.price = 499.99;
        b.displayDetails();
    }
}
