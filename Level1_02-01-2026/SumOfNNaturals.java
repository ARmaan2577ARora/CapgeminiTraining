import java.util.Scanner;

public class SumOfNNaturals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int number1=number;
        int sum1 = 0;
        if (number < 0) {
            System.out.println("The number " + number + " is not a natural number.");
            scanner.close();
            return;
        }
        while (number > 0) {
            sum1 += number;
            number--;
        }
        int sum2 = (number1 * (number1 + 1)) / 2;
        System.out.println("Sum of the first " + number1 + " natural numbers using while loop is " + sum1);
        System.out.println("Sum of the first " + number1 + " natural numbers using formula is " + sum2);
        scanner.close();
    }
}
