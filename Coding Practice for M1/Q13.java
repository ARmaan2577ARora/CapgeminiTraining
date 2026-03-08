import java.util.*;

public class Q13 {

    public static int MaxExponents(int a, int b) {

        int maxExponent = -1;
        int result = a;

        for (int i = a; i <= b; i++) {

            int num = i;
            int count = 0;

            while (num % 2 == 0) {
                count++;
                num = num / 2;
            }

            if (count > maxExponent) {
                maxExponent = count;
                result = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int res = MaxExponents(a, b);

        System.out.println(res);
    }
}