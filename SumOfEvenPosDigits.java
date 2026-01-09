import java.util.Scanner;
class SumOfEvenPosDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res = 0;
        while (num > 0) {
            res += num%10;
            num/=100;
        }
        sc.close();
        System.out.println(res);
    }    
}
