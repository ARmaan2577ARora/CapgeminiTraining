package Level1_05_02_2026;
// Custom Transaction Exception
class TransactionException extends Exception {
    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class TransactionProcessor {
    public static void main(String[] args) {
        try {
            processTransaction("TX1001", 500.0);
        } catch (TransactionException e) {
            System.err.println("Transaction Failed: " + e.getMessage());
            System.err.println("Root Cause: " + e.getCause());
        }
    }

    public static void processTransaction(String txId, double amount) throws TransactionException {
        try {
            // Simulating a database error
            simulateDatabaseError();
        } catch (RuntimeException e) {
            // Rethrowing with custom context
            String contextMessage = String.format("Error processing transaction [ID: %s, Amount: %.2f]", txId, amount);
            throw new TransactionException(contextMessage, e);
        }
    }

    private static void simulateDatabaseError() {
        throw new RuntimeException("Connection timed out");
    }
}
