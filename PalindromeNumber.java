import java.util.Scanner;
class PalindromeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int temp = number;
        int revv = 0;
        while (temp > 0) {
            revv = revv*10 + temp%10;
            temp = temp/10;
        }
        if (number == revv) {
            System.out.println("Palindrome");
        }
        else System.out.println("Not Palindrome");
        sc.close();
    }    
}