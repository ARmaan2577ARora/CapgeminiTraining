import java.util.Scanner;

public class FactorialUsingFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number < 0) {
            System.out.println("The number " + number + " is not a positive number.");
            scanner.close();
            return;
        }
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + number + " is " + factorial);
        scanner.close();
    }
}
