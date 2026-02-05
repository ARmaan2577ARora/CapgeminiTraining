package Level3_05_02_2026;

public class MultipleCatchDemo {
    public static void main(String[] args) {
        int[] numbers = null; // Scenario 1: Null
        try {
            System.out.println("Accessing array...");
            // Simulate NullPointerException
            // System.out.println(numbers[0]);

            numbers = new int[] { 10, 20, 30 };
            int index = 5; // Scenario 2: Out of bounds
            System.out.println("Value at index " + index + ": " + numbers[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }

        // Let's re-run with null to show the other message in a single run logic?
        // Actually the problem asks for specific behaviors.
        System.out.println("\nTesting with null array:");
        numbers = null;
        try {
            if (numbers == null)
                throw new NullPointerException();
            System.out.println(numbers[0]);
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
