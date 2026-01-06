import java.util.Scanner;
class DivisibleByFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Is the number " + num + " divisible by 5? " + (num % 5 == 0));
        scanner.close();
    }
}