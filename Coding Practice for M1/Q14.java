import java.util.*;

public class Q14 {

    public static int Calculate(int m, int n) {

        int sum = 0;

        for(int i = m; i <= n; i++) {
            if(i % 15 == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int result = Calculate(m, n);

        System.out.println(result);
    }
}