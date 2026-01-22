package Level1_22_01_2026;
import java.util.ArrayList;
class Bank{
    ArrayList<Customer> customers = new ArrayList<>();
    public void openAccount(Customer c){
        customers.add(c);
    }
}
class Customer{
    String name;
    ArrayList<Integer> balances = new ArrayList<>();
    public Customer(String name) {
        this.name = name;
    }
    public void addBalance(int balance){
        balances.add(balance);
    }
    public void viewBalance(){
        for(int bal : balances){
            System.out.println(name + " balance: " + bal);
        }   
    }
}
class BankAndAccountHolders{
    public static void main(String[] args) {
        Bank b = new Bank();
        Customer c1 = new Customer("Ram lal");
        Customer c2 = new Customer("Shyam tiwari");
        b.openAccount(c1);
        b.openAccount(c2);

        c1.addBalance(1000);
        c1.addBalance(500);
        c2.addBalance(2000);
        
        c1.viewBalance();
        c2.viewBalance();     
    }
}