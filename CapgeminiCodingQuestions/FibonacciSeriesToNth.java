import java.util.Scanner;
class FibonacciSeriesToNth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;
        int b = 1;
        for(int i = 0; i < n; i++){
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }   sc.close();
    }
}
