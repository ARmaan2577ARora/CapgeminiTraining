import java.util.Scanner;
class NumberCheck {
    public static int typeOfNumber(int num) {
        if (num > 0) {
            System.out.println("1");
        } else if (num < 0) {
            System.out.println("-1");
        } else {
            System.out.println("0");
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        typeOfNumber(num);
        scanner.close();
    }    
}
