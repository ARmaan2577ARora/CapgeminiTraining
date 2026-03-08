import java.util.*;

public class Q15 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for(int i = 0; i < n; i++) {

            if(i % 2 == 0)
                even.add(arr[i]);
            else
                odd.add(arr[i]);
        }

        Collections.sort(even);
        Collections.sort(odd);

        int secondLargestEven = even.get(even.size() - 2);
        int secondLargestOdd = odd.get(odd.size() - 2);

        System.out.println(secondLargestEven + secondLargestOdd);
    }
}