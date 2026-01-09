import java.util.Scanner;
class RangeOfPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        while (start < end) {
            boolean isPrime = true;
            for (int i = 2; i < start/2; i++) {
                if (start%i == 0) {
                    isPrime =false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(start);
            }
            start++;
        }
        sc.close();
    }    
}
