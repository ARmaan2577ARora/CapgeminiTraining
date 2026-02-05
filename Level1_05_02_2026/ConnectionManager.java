package Level1_05_02_2026;

class DatabaseConnection {
    public void open() {
        System.out.println("Connection opened successfully.");
    }

    public void executeQuery() {
        System.out.println("Executing query...");
        // Simulating an error during query execution
        throw new RuntimeException("Query execution failed due to network error.");
    }

    public void close() {
        System.out.println("Connection closed successfully.");
    }
}

public class ConnectionManager {
    public static void main(String[] args) {
        DatabaseConnection conn = new DatabaseConnection();
        try {
            conn.open();
            conn.executeQuery();
        } catch (RuntimeException e) {
            System.err.println("Error caught: " + e.getMessage());
        } finally {
            // This block will always run, ensuring the connection is closed
            System.out.println("Starting cleanup in finally block...");
            conn.close();
        }

        System.out.println("Program execution finished.");
    }
}
