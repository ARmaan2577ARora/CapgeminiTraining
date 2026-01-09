import java.util.Scanner;
public class RemoveSpecialCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = input.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(result);
        scanner.close();
    }
}
