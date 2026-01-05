import java.util.Scanner;
public class SumOfNaturalUsingFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = 0;
        if (number < 0) {
            System.out.println("The number " + number + " is not a natural number.");
            scanner.close();
            return;
        }
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        int sum1 = number*(number+1)/2;
        System.out.println("Sum of the first " + number + " natural numbers using for loop is " + sum);
        System.out.println("Sum of the first " + number + " natural numbers using formula is " + sum1);
        scanner.close();
    }
}
