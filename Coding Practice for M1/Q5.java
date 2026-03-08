import java.util.*;

public class Q5 {

    public static int differenceofSum(int n, int m) {

        int sumDivisible = 0;
        int sumNotDivisible = 0;

        for(int i = 1; i <= m; i++) {

            if(i % n == 0) {
                sumDivisible += i;
            } 
            else {
                sumNotDivisible += i;
            }
        }

        return sumNotDivisible - sumDivisible;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int result = differenceofSum(n, m);

        System.out.println(result);
    }
}