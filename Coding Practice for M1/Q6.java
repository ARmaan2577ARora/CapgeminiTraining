import java.util.*;

public class Q6 {

    public static int findSum(int[] arr) {

        int n = arr.length;

        if(n == 0 || n <= 3)
            return 0;

        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(i % 2 == 0)
                even.add(arr[i]);
            else
                odd.add(arr[i]);
        }

        Collections.sort(even);
        Collections.sort(odd);

        int secondLargestEven = even.get(even.size() - 2);
        int secondSmallestOdd = odd.get(1);

        return secondLargestEven + secondSmallestOdd;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(findSum(arr));
    }
}