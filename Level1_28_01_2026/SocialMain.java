class User {
    int id; String name; User next;
    int[] friends=new int[5]; int count=0;
    User(int id,String n){this.id=id;name=n;}
}

class Social {
    User head;

    void addUser(int id,String name){
        User u=new User(id,name);
        u.next=head;
        head=u;
    }

    void addFriend(int id,int fid){
        for(User u=head;u!=null;u=u.next)
            if(u.id==id)
                u.friends[u.count++]=fid;
    }

    void showFriends(int id){
        for(User u=head;u!=null;u=u.next)
            if(u.id==id)
                for(int i=0;i<u.count;i++)
                    System.out.print(u.friends[i]+" ");
    }
}

public class SocialMain {
    public static void main(String[] args){
        Social s=new Social();
        s.addUser(1,"A"); 
        s.addUser(2,"B");
        s.addFriend(1,2);
        s.showFriends(1);
    }
}

