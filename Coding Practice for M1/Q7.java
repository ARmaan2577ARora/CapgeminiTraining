import java.util.*;

public class Q7 {

    public static int ProductSmallestPair(int sum, int[] arr) {

        int n = arr.length;

        if(n < 2)
            return -1;

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {

            if(arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i] < secondSmallest) {
                secondSmallest = arr[i];
            }
        }

        if(smallest + secondSmallest <= sum)
            return smallest * secondSmallest;
        else
            return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sum = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int result = ProductSmallestPair(sum, arr);

        System.out.println(result);
    }
}