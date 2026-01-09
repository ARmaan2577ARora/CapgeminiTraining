import java.util.Scanner;
class FactorialOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        int num = sc.nextInt();
        int res = 1;
        for(int i = num; i > 0;i--){
            res *= i;
        }
        sc.close();
        System.out.println(res);
    }    
}
