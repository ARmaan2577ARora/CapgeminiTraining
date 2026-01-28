class State {
    String text;
    State prev,next;
    State(String t){
        text=t;
    }
}

class Editor {
    State current;

    void add(String t){
        State s=new State(t);
        if(current!=null){
            current.next=s;
            s.prev=current;
        }
        current=s;
    }

    void undo(){
        if(current!=null && current.prev!=null)
        current=current.prev;
    }
    void redo(){
        if(current!=null && current.next!=null)
        current=current.next;
    }

    void show(){
        if(current!=null)
        System.out.println(current.text);
    }
}

public class EditorMain {
    public static void main(String[] args){
        Editor e=new Editor();
        e.add("Hello World");
        e.add("Hello");
        e.undo();
        e.show();
    }
}
