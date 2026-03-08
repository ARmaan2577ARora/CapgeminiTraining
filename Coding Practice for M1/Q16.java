import java.util.*;

public class Q16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int sum = 0;

        for(int i = 1; i <= 10; i++) {
            int val = n * i;
            System.out.print(val);
            if(i < 10) System.out.print(", ");
            sum += val;
        }

        System.out.println();
        System.out.println(sum);
    }
}