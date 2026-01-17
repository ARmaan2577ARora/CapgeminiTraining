package Level1_17_01_26;
class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(int accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    void displayDetails() {
        System.out.println(accountNumber);
        System.out.println(accountHolder);
        System.out.println(getBalance());
        System.out.println(interestRate);
    }
}

public class BankAccountManagement {

    public static void main(String[] args) {

        SavingsAccount account =
                new SavingsAccount(123456, "Amit Kumar", 5000.0, 4.5);

        account.displayDetails();

        account.setBalance(7500.0);

        System.out.println(account.getBalance());
    }
}
