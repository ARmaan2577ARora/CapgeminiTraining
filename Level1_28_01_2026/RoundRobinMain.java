class Process {
    int pid, burst;
    Process next;
    Process(int p,int b){
        pid=p;
        burst=b;
    }
}

class Scheduler {
    Process head;

    void add(int p,int b){
        Process n=new Process(p,b);
        if(head==null){
            head=n;
            n.next=n;
            return;
        }
        Process t=head;
        while(t.next!=head)
            t=t.next;
        t.next=n;
        n.next=head;
    }

    void run(int q){
        Process c=head;
        while(c!=null){
            if(c.burst>0){
                int exec=Math.min(q,c.burst);
                c.burst-=exec;
                System.out.println("P"+c.pid+" ran "+exec);
            }
            c=c.next;
            if(c==head && done()) break;
        }
    }

    boolean done(){for(Process t=head;t!=null;){if(t.burst>0)return false;t=t.next;if(t==head)break;}return true;}
}

public class RoundRobinMain {
    public static void main(String[] args){
        Scheduler s=new Scheduler();
        s.add(1,10); s.add(2,5); s.add(3,8);
        s.run(3);
    }
}
