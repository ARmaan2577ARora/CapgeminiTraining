import java.util.Scanner;

class EvenAndOddDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num  = sc.nextInt();
        int even = 0, odd = 0;
        while (num > 0) {
            int dig = num%10;
            if(dig%2 == 0) even++;
            else odd++;
            num /= 10;
        }
        sc.close();
        System.out.println(even + " , " + odd);
    }    
}
