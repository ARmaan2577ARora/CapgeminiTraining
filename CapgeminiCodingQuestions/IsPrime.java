import java.util.Scanner;
class IsPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean isPrime = true;
        for (int i = 2; i < num/2; i++) {
            if (num%i == 0) {
                isPrime = false;
                break;
            }
        }
        sc.close();
        System.out.println(isPrime?"Prime":"Not Prime");
    }    
}
