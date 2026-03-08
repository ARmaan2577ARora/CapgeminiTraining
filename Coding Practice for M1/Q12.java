import java.util.*;

public class Q12 {

    public static int OperationChoices(int c, int n, int a, int b) {

        if(c == 1)
            return a + b;
        else if(c == 2)
            return a - b;
        else if(c == 3)
            return a * b;
        else if(c == 4)
            return a / b;

        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = OperationChoices(c, 0, a, b);

        System.out.println(result);
    }
}