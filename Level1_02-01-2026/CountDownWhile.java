import java.util.Scanner;
public class CountDownWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n >= 1) {
            System.out.println(n);
            n--;
        }
        System.out.println("Rocket launch!");
        scanner.close();
    }
}
