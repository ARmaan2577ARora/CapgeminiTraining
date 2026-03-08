import java.util.*;

public class Q17 {

    public static boolean isPalindrome(int num) {
        int original = num;
        int rev = 0;

        while(num > 0) {
            int d = num % 10;
            rev = rev * 10 + d;
            num /= 10;
        }

        return original == rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int low = sc.nextInt();
        int high = sc.nextInt();

        boolean first = true;

        for(int i = low; i <= high; i++) {
            if(isPalindrome(i)) {
                if(!first) System.out.print(", ");
                System.out.print(i);
                first = false;
            }
        }

        System.out.println(".");
    }
}