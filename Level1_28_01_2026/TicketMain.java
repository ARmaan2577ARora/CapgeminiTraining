class Ticket {
    int id; 
    String customer,movie; 
    Ticket next;
    Ticket(int i,String c,String m){
        id=i;
        customer=c;
        movie=m;
    }
}

class TicketSystem {
    Ticket head;

    void add(int id,String c,String m){
        Ticket t=new Ticket(id,c,m);
        if(head==null){
            head=t;
            t.next=t;
            return;
        }
        Ticket temp=head;
        while(temp.next!=head)
            temp=temp.next;
        temp.next=t;
        t.next=head;
    }

    void delete(int id){
        Ticket c=head,p=null;
        do{
            if(c.id==id){
                if(p!=null)p.next=c.next;
                else{Ticket t=head;while(t.next!=head)t=t.next;head=c.next;t.next=head;}
                return;
            }
            p=c;c=c.next;
        }while(c!=head);
    }

    void display(){
        if(head==null)return;
        Ticket t=head;
        do{System.out.println(t.id+" "+t.customer+" "+t.movie);t=t.next;}
        while(t!=head);
    }
}

public class TicketMain {
    public static void main(String[] args){
        TicketSystem ts=new TicketSystem();
        ts.add(1,"A","Movie1");
        ts.add(2,"B","Movie2");
        ts.display();
    }
}
