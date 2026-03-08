import java.util.*;

public class Q8 {

    public static String DectoNBase(int n, int num) {

        if(num == 0)
            return "0";

        String result = "";

        while(num > 0) {

            int rem = num % n;

            if(rem < 10)
                result = rem + result;
            else
                result = (char)('A' + rem - 10) + result;

            num = num / n;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num = sc.nextInt();

        String res = DectoNBase(n, num);

        System.out.println(res);
    }
}