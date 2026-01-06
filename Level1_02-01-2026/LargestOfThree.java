import java.util.Scanner;

public class LargestOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();
        System.out.println("Is the first number largest? " + (number1 > number2 && number1 > number3));
        System.out.println("Is the second number largest? " + (number2 > number1 && number2 > number3));
        System.out.println("Is the third number largest? " + (number3 > number1 && number3 > number2));
        scanner.close();
    }
}
