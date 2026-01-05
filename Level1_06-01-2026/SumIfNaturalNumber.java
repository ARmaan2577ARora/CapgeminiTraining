import java.util.Scanner;

public class SumIfNaturalNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number > 0) {
            System.out.println("The sum of " + number + " natural numbers is " + (number * (number + 1)) / 2);
        } else {
            System.out.println("The number" + number + " is not a natural number.");
        }
        scanner.close();
    }
}
