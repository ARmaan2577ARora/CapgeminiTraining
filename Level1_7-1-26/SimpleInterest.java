import java.util.Scanner;
class SimpleInterest {
    public static int calculateSimpleInterest(int principal, int rate, int time) {
        return (principal * rate * time) / 100;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int r = sc.nextInt();
        int t = sc.nextInt();
        System.out.println("The Simple Interest is: " + calculateSimpleInterest(p, r, t) + "for Principal: " + p + ", Rate of Interest " + r + " and time " + t);
        sc.close();
    }
}