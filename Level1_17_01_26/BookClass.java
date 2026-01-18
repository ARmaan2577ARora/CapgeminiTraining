package Level1_17_01_26;

class Book{
    String title;
    String author;
    int price;

    Book(){
        System.out.println("Default Constructor");
    }

    Book(String title,String author,int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
public class BookClass {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Flamingo","arthur",6);
        System.out.println(b2.price+" "+ b2.title+" "+b2.author);
    }
}
