import java.util.Scanner;

class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.nextLine();
        int decimal = 0;
        int power = 1;
        for (int i = binary.length()-1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += power;
            }
            power *= 2;
        }
        sc.close();
        System.out.println(decimal);
    }
}
