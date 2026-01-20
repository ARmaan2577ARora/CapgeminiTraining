package Level1_19_01_26;
class Person{
    String name;
    int id;
    Person(String name,int id){
        this.name = name;
        this.id = id;
    }
}
interface Worker{
    void performDuties();
}
class Chef extends Person implements Worker{
    Chef(String name,int id){
        super(name,id);
    }
    public void performDuties(){
        System.out.println("Chef is cooking");
    }
}
class Waiter extends Person implements Worker{
    Waiter(String name,int id){
        super(name,id);
    }
    public void performDuties(){
        System.out.println("Waiter is serving");
    }
}
class RestaurantManagement {
    public static void main(String[] args) {
        Chef c1 = new Chef("Chef",1);
        Waiter w1 = new Waiter("Waiter",2);
        c1.performDuties();
        w1.performDuties();
    }
}
