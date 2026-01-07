import java.util.Scanner;

class QuotientAndRemainder {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int[] result = new int[2];
        result[0] = number % divisor; 
        result[1] = number / divisor; 
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int divisor = scanner.nextInt();
        int[] result = findRemainderAndQuotient(number, divisor);
        System.out.println(result[0] + " " + result[1]);
        scanner.close();
    }    
}
