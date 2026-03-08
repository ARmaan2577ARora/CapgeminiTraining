import java.util.*;

public class Q10 {

    public static int NumberOfCarries(int num1, int num2) {

        int carry = 0;
        int count = 0;

        while(num1 > 0 || num2 > 0) {

            int d1 = num1 % 10;
            int d2 = num2 % 10;

            int sum = d1 + d2 + carry;

            if(sum >= 10) {
                carry = 1;
                count++;
            } 
            else {
                carry = 0;
            }

            num1 = num1 / 10;
            num2 = num2 / 10;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int result = NumberOfCarries(num1, num2);

        System.out.println(result);
    }
}