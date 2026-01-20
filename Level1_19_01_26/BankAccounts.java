package Level1_19_01_26;
class BankAccount{
    int accountNumber;
    double balance;
    BankAccount(int accountNumber,double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    void displayAccountType(){
        System.out.println("Account Number");
    }
}
class SavingsAccount extends BankAccount{
    double interestRate;
    SavingsAccount(int accountNumber,double balance,double interestRate){
        super(accountNumber,balance);
        this.interestRate = interestRate;
    }
    @Override
    void displayAccountType(){
        System.out.println("Account Type: Savings Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + interestRate);
    }
}
class CheckingAccount extends BankAccount{
    double withdrawalLimit;
    CheckingAccount(int accountNumber,double balance,double withdrawalLimit){
        super(accountNumber,balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    @Override
    void displayAccountType(){
        System.out.println("Account Type: Checking Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}
class BankAccounts {
    public static void main(String[] args) {
        SavingsAccount s1 = new SavingsAccount(1,1000,5);
        s1.displayAccountType();
        CheckingAccount c1 = new CheckingAccount(2,2000,10);
        c1.displayAccountType();
    }    
}
