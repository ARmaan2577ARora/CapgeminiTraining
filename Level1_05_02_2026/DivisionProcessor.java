package Level1_05_02_2026;

public class DivisionProcessor {
    public static void main(String[] args) {
        try {
            processDivision(10, 0);
        } catch (ArithmeticException e) {
            System.err.println("Main method caught the rethrown exception: " + e.getMessage());
        }
    }

    public static void processDivision(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("DivisionProcessor caught ArithmeticException. Logging and rethrowing...");
            // Rethrowing the exception
            throw e;
        }
    }
}
