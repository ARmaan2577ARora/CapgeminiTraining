import java.util.Scanner;
class GCDAndHCF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int a = num1;
        int b = num2;
        while (num1%num2 != 0) {
            int c = num1;
            num1 = num2;
            num2 = c%num1;
        }
        int lcm = (a*b)/num2;
        sc.close();
        System.out.println(lcm + " " + num2);
    }    
}
