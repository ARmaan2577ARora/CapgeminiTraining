import java.util.Scanner;

public class MultipleSixToNine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 6; i < 10; i++) {
            System.out.println(number + " * " + i + " = " + number * i);
        } 
        scanner.close();
    }
}
