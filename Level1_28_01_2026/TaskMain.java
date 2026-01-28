import java.util.Scanner;

class TaskNode {
    int id;
    String name;
    TaskNode next;

    TaskNode(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class TaskList {
    TaskNode head;

    void addTask(int id, String name) {
        TaskNode n = new TaskNode(id, name);
        if (head == null) {
            head = n;
            n.next = head;
            return;
        }
        TaskNode temp = head;
        while (temp.next != head)
            temp = temp.next;
        temp.next = n;
        n.next = head;
    }

    void deleteTask(int id) {
        if (head == null) return;
        TaskNode curr = head, prev = null;

        do {
            if (curr.id == id) {
                if (prev != null) prev.next = curr.next;
                else {
                    TaskNode temp = head;
                    while (temp.next != head) temp = temp.next;
                    head = curr.next;
                    temp.next = head;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    void display() {
        if (head == null) return;

        TaskNode temp = head;
        do {
            System.out.println(temp.id + " " + temp.name);
            temp = temp.next;
        } while (temp != head);
    }

    void nextTask() {
        if (head != null)
            head = head.next;
    }
}

public class TaskMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskList list = new TaskList();

        while (true) {
            System.out.println("\n1 Add Task\n2 Delete Task\n3 Next Task\n4 Display\n5 Exit");
            int ch = sc.nextInt();

            if (ch == 1)
                list.addTask(sc.nextInt(), sc.next());
            else if (ch == 2) 
                list.deleteTask(sc.nextInt());
            else if (ch == 3) 
                list.nextTask();
            else if (ch == 4) 
                list.display();
            else 
                break;
        }
        sc.close();
    }
}
