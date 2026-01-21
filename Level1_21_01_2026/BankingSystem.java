interface Loanable {
    void applyForLoan(double amount);

    boolean calculateLoanEligibility(double amount);
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " to account " + accountNumber);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + " from account " + accountNumber);
        } else {
            System.out.println("Invalid amount for withdrawal.");
        }
    }

    public abstract double calculateInterest();

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility(amount)) {
            System.out.println("Loan approved for " + amount);
        } else {
            System.out.println("Minimum balance requirement not met.");
        }
    }

    @Override
    public boolean calculateLoanEligibility(double amount) {
        return getBalance() >= amount * 0.2;
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return 0;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[2];
        accounts[0] = new SavingsAccount("SAV123", "Alice", 10000);
        accounts[1] = new CurrentAccount("CUR456", "Bob", 5000);

        System.out.println("--- Banking System ---");
        for (BankAccount acc : accounts) {
            if (acc != null) {
                acc.displayAccountInfo();
                double interest = acc.calculateInterest();
                System.out.println("Calculated Interest: " + interest);
                if (acc instanceof Loanable) {
                    ((Loanable) acc).applyForLoan(5000);
                }
            }
        }
    }
}
