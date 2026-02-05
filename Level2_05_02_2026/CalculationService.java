package Level2_05_02_2026;

class CalculationException extends Exception {
    public CalculationException(String message) {
        super(message);
    }
}

public class CalculationService {
    public void performCalculation(int value) throws CalculationException {
        if (value < 0) {
            throw new CalculationException("Value must be non-negative");
        }
        // Simulate calculation
        if (value == 0) {
            throw new CalculationException("Calculation resulted in zero");
        }
        System.out.println("Calculation result: " + (value * 2));
    }

    public void process() {
        try {
            performCalculation(-5);
        } catch (CalculationException e) {
            System.err.println("Exception caught in process: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CalculationService service = new CalculationService();
        service.process();
    }
}
