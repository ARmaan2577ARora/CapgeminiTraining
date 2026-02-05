package Level3_05_02_2026;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankSystemDemo {
    private double balance;

    public BankSystemDemo(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    public static void main(String[] args) {
        BankSystemDemo account = new BankSystemDemo(1000);

        try {
            System.out.println("Attempting to withdraw 1500...");
            account.withdraw(1500);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nAttempting to withdraw -50...");
            account.withdraw(-50);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nAttempting to withdraw 500...");
            account.withdraw(500);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
