import java.util.Scanner;

public class FactorialUsingWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number < 0) {
            System.out.println("The number " + number + " is not a positive number.");
            scanner.close();
            return;
        }
        int number1 = number;
        int factorial = 1;
        while (number1 > 0) {
            factorial *= number1;
            number1--;
        }
        System.out.println("Factorial of " + number + " is " + factorial);
        scanner.close();
    }
}
