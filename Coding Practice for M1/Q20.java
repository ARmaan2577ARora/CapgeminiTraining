import java.util.*;

public class Q20 {

    public static int FindAutoCount(String n) {

        if(n == null)
            return 0;

        int len = n.length();
        int[] freq = new int[10];

        for(int i = 0; i < len; i++) {
            freq[n.charAt(i) - '0']++;
        }

        for(int i = 0; i < len; i++) {
            int digit = n.charAt(i) - '0';
            if(freq[i] != digit)
                return 0;
        }

        int distinct = 0;
        for(int i = 0; i < 10; i++) {
            if(freq[i] > 0)
                distinct++;
        }

        return distinct;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();

        System.out.println(FindAutoCount(n));
    }
}