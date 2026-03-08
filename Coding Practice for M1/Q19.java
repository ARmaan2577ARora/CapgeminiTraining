import java.util.*;

public class Q19 {

    public static void MaxInArray(int arr[], int length) {
        
        int max = arr[0];
        int index = 0;

        for(int i = 1; i < length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int[] arr = new int[length];

        for(int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

        MaxInArray(arr, length);
    }
}