package Level3_05_02_2026;

public class NestedTryCatchDemo {
    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30 };
        int index = 2;
        int divisor = 0;

        try {
            try {
                int value = numbers[index];
                System.out.println("Value at index " + index + ": " + value);

                int result = value / divisor;
                System.out.println("Result of division: " + result);

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
    }
}
