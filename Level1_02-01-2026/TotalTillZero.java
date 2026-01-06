import java.util.Scanner;

public class TotalTillZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        double sum = 0;
        while (n != 0) {
            sum += n;
            n = scanner.nextDouble();
        }
        System.out.println("The sum of the numbers is " + sum);
        scanner.close();
    }
}
