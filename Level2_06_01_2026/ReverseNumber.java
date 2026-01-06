import java.util.Scanner;
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int absNumber = Math.abs(number);
        String numStr = String.valueOf(absNumber);
        int len = numStr.length();
        int[] digits = new int[len];
        int temp = absNumber;
        for (int i = 0; i < len; i++) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }
        int[] reverse = new int[len];
        for (int i = 0; i < len; i++) {
            reverse[i] = digits[i];
        }
        for (int val : reverse) {
            System.out.print(val);
        }   
        scanner.close();
    }
}
