import java.util.Scanner;

class Book {
    int id; String title, author; boolean available;
    Book prev,next;
    Book(int id,String title,String author,boolean available){
        this.id=id;
        this.title=title;
        this.author=author;
        this.available=available;
    }
}

class Library {
    Book head,tail;

    void add(int id,String t,String a,boolean av){
        Book b=new Book(id,t,a,av);
        if(head==null)head=tail=b;
        else{tail.next=b;b.prev=tail;tail=b;}
    }

    void delete(int id){
        for(Book c=head;c!=null;c=c.next)
            if(c.id==id){
                if(c.prev!=null)c.prev.next=c.next; else head=c.next;
                if(c.next!=null)c.next.prev=c.prev; else tail=c.prev;
                return;
            }
    }

    void displayF(){
        for(Book c=head;c!=null;c=c.next)
            System.out.println(c.title);
    }
    void displayR(){
        for(Book c=tail;c!=null;c=c.prev)
            System.out.println(c.title);
    }
}

public class LibraryMain {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Library l=new Library();
        while(true){
            System.out.println("1 Add 2 Delete 3 DisplayF 4 DisplayR 5 Exit");
            int ch=sc.nextInt();
            if(ch==1)
                l.add(sc.nextInt(),sc.next(),sc.next(),sc.nextBoolean());
            else if(ch==2)
                l.delete(sc.nextInt());
            else if(ch==3)
                l.displayF();
            else if(ch==4)
                l.displayR();
            else 
                break;
        }
        sc.close();
    }
}
