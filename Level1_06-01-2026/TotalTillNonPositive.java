import java.util.Scanner;

public class TotalTillNonPositive {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        double n= scanner.nextDouble();
        double sum= 0;
        while (true) {
            sum+= n;
            n= scanner.nextDouble();
            if (n<=0) {
                break;
            }
        }
        System.out.println("Sum of the input numbers is " + sum);
        scanner.close();
    }
}
