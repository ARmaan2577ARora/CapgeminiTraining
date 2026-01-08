import java.util.Scanner;
public class StringLength {
    static int toFindLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int customLength = toFindLength(text);
        int builtInLength = text.length();
        System.out.println(customLength);
        System.out.println(builtInLength);
        sc.close();
    }
}
