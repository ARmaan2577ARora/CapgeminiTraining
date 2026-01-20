package Level1_19_01_26;
class Book{
    String title;
    int publicationYear;
    Book(String title,int publicationYear){
        this.title = title;
        this.publicationYear = publicationYear;
    };
    void display(){
        System.out.println(title + " " + publicationYear);
    }
}
class Author extends Book{
    String name;
    String bio;
    Author(String title,int publicationYear,String name,String bio){
        super(title,publicationYear);
        this.name = name;
        this.bio = bio;
    };
    void display(){
        super.display();
        System.out.println(name + " " + bio);
    }
}
class LibraryManagement {
    public static void main(String[] args) {
        Author a1 = new Author("The Alchemist",2001,"Paulo Coelho","A Brazilian author");
        a1.display();
    }    
}
