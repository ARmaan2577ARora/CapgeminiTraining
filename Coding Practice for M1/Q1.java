import java.util.*;

public class Q1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int unit = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        int total = r*unit;
        int sum = 0;
        int cnt = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            cnt++;
            if(sum >= total){
                System.out.println(cnt);
                return;
            };
        }
        System.out.println(cnt);
    }
}