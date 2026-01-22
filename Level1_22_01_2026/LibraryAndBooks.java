package Level1_22_01_2026;
import java.util.ArrayList;
class Library{
    ArrayList<Book> books = new ArrayList<>();
    public void addBook(Book b){
        books.add(b);
    }
}
class Book{
    String title;
    String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    @Override
    public String toString(){
        return title + " " + author;
    }
}
class LibraryAndBooks{
    public static void main(String[] args) {
        Book b1 = new Book("The road not taken", "Robert frost");
        Book b2 = new Book("The Blind Love", "William Ray");
        Library lib1 = new Library();
        Library lib2 = new Library();
        lib1.addBook(b1);
        lib2.addBook(b2);
        lib2.addBook(b1);
        System.out.println(lib1.books.toString());
        System.out.println(lib2.books.toString());
    }
}