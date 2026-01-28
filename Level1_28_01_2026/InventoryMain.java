import java.util.Scanner;

class Item {
    int id, qty; String name; double price; Item next;
    Item(int id,String n,int q,double p){this.id=id;name=n;qty=q;price=p;}
}

class Inventory {
    Item head;

    void add(int id,String n,int q,double p){
        Item x=new Item(id,n,q,p);
        x.next=head;
        head=x;
    }
    void delete(int id){
        Item t=head,p=null;
        while(t!=null){
            if(t.id==id){
                if(p==null)head=t.next;
                else p.next=t.next;
                return;
            }
            p=t;
            t=t.next;
        }
    }
    void update(int id,int q){
        for(Item t=head;t!=null;t=t.next)
        if(t.id==id)t.qty=q;
    }
    void search(int id){
        for(Item t=head;t!=null;t=t.next)
        if(t.id==id)System.out.println(t.name+" "+t.qty);
    }
    void total(){
        double sum=0;
        for(Item t=head;t!=null;t=t.next)
        sum+=t.qty*t.price;
        System.out.println(sum);
    }
    void display(){
        for(Item t=head;t!=null;t=t.next)
        System.out.println(t.id+" "+t.name);
    }
}

public class InventoryMain {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Inventory i=new Inventory();
        while(true){
            System.out.println("1 Add 2 Delete 3 Update 4 Search 5 Total 6 Display 7 Exit");
            int ch=sc.nextInt();
            if(ch==1)
                i.add(sc.nextInt(),sc.next(),sc.nextInt(),sc.nextDouble());
            else if(ch==2)
                i.delete(sc.nextInt());
            else if(ch==3)
                i.update(sc.nextInt(),sc.nextInt());
            else if(ch==4)
                i.search(sc.nextInt());
            else if(ch==5)
                i.total();
            else if(ch==6)
                i.display();
            else 
                break;
        }
        sc.close();
    }
}
