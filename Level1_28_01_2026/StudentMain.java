import java.util.Scanner;

class StudentNode {
    int roll;
    String name;
    int age;
    String grade;
    StudentNode next;

    StudentNode(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    StudentNode head;

    void addFirst(int roll, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    void addLast(int roll, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    void delete(int roll) {
        if (head == null) return;

        if (head.roll == roll) {
            head = head.next;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null && temp.next.roll != roll)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    void search(int roll) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Found: " + temp.name + " " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student Not Found");
    }

    void updateGrade(int roll, String grade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = grade;
                System.out.println("Grade Updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student Not Found");
    }

    void display() {
        if (head == null) {
            System.out.println("No Records");
            return;
        }
        StudentNode temp = head;
        while (temp != null) {
            System.out.println(temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();

        while (true) {
            System.out.println("\n1 Add First\n2 Add Last\n3 Delete\n4 Search\n5 Update Grade\n6 Display\n7 Exit");
            int ch = sc.nextInt();

            if (ch == 1) {
                list.addFirst(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
            }
            else if (ch == 2) {
                list.addLast(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
            }
            else if (ch == 3) {
                list.delete(sc.nextInt());
            }
            else if (ch == 4) {
                list.search(sc.nextInt());
            }
            else if (ch == 5) {
                list.updateGrade(sc.nextInt(), sc.next());
            }
            else if (ch == 6) {
                list.display();
            }
            else {
                break;
            }
        }
    }
}
