import java.util.Scanner;
class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int temp = num;
        int sum = 0;
        int dig =(int)Math.log10(num)+1;
        while (temp > 0) {
           sum += (int)Math.pow(temp%10, dig); 
           temp/= 10;
        }
        sc.close();
        System.out.println(sum==num?"Armstrong":"Not Armstrong");
    }
}