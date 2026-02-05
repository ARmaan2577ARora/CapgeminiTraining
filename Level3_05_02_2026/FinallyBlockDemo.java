package Level3_05_02_2026;

import java.util.Scanner;

public class FinallyBlockDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int num2 = scanner.nextInt();

            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero error!");
        } finally {
            System.out.println("Operation completed");
            scanner.close();
        }
    }
}
