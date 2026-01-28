import java.util.Scanner;

class MovieNode {
    String title, director;
    int year;
    double rating;
    MovieNode prev, next;

    MovieNode(String t, String d, int y, double r) {
        title = t;
        director = d;
        year = y;
        rating = r;
    }
}

class MovieList {
    MovieNode head, tail;

    void addFirst(String t, String d, int y, double r) {
        MovieNode n = new MovieNode(t, d, y, r);
        if (head == null) {
            head = tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    void addLast(String t, String d, int y, double r) {
        MovieNode n = new MovieNode(t, d, y, r);
        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    void delete(String title) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                if (temp.prev != null) 
                    temp.prev.next = temp.next;
                else 
                    head = temp.next;

                if (temp.next != null) 
                    temp.next.prev = temp.prev;
                else 
                    tail = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }

    void updateRating(String title, double rating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = rating;
                return;
            }
            temp = temp.next;
        }
    }

    void searchByDirector(String director) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equals(director)) {
                System.out.println(temp.title + " " + temp.rating);
            }
            temp = temp.next;
        }
    }

    void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " + temp.rating);
            temp = temp.next;
        }
    }

    void displayReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieList list = new MovieList();

        while (true) {
            System.out.println("\n1 Add First\n2 Add Last\n3 Delete\n4 Update Rating\n5 Search Director\n6 Display Fwd\n7 Display Rev\n8 Exit");
            int ch = sc.nextInt();

            if (ch == 1) 
                list.addFirst(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
            else if (ch == 2) 
                list.addLast(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
            else if (ch == 3) 
                list.delete(sc.next());
            else if (ch == 4) 
                list.updateRating(sc.next(), sc.nextDouble());
            else if (ch == 5) 
                list.searchByDirector(sc.next());
            else if (ch == 6) 
                list.displayForward();
            else if (ch == 7) list.displayReverse();
            else break;
        }
        sc.close();
    }
}
