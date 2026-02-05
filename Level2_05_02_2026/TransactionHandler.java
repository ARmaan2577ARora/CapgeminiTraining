package Level2_05_02_2026;

class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }
}

class InvalidTransactionException extends TransactionException {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

public class TransactionHandler {
    public void processTransaction(double amount) throws TransactionException {
        if (amount < 0) {
            throw new InvalidTransactionException("Negative amount: " + amount);
        }
        // Simulate other operations
        if (amount == 0) {
            throw new TransactionException("Zero amount is not allowed");
        }
    }

    public void handleTransaction(double amount) throws TransactionException {
        try {
            processTransaction(amount);
        } catch (InvalidTransactionException e) {
            throw new TransactionException("Failed processing transaction: " + e.getMessage());
        } catch (TransactionException e) {
            System.err.println("Transaction error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TransactionHandler handler = new TransactionHandler();
        try {
            handler.handleTransaction(-100);
        } catch (TransactionException e) {
            System.err.println("Caught in main: " + e.getMessage());
        }
    }
}
