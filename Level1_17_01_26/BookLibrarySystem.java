package Level1_17_01_26;

class LibraryItem {
    public String ISBN;
    protected String title;
    private String author;

    LibraryItem(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    String getAuthor() {
        return author;
    }

    void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends LibraryItem {
    String format;
    EBook(String ISBN, String title, String author, String format) {
        super(ISBN, title, author);
        this.format = format;
    }

    void displayDetails() {
        System.out.println(ISBN);
        System.out.println(title);
        System.out.println(getAuthor());
        System.out.println(format);
    }
}

public class BookLibrarySystem {
    public static void main(String[] args) {
        EBook book = new EBook("928-17365", "Java OOPS", "James frost", "PDF");
        book.displayDetails();

        book.setAuthor("Jimmy");
        System.out.println(book.getAuthor());
    }
}
