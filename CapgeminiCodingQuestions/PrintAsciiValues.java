import java.util.Scanner;
public class PrintAsciiValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            System.out.println(c + " : " + (int) c);
        }
        scanner.close();
    }
}
