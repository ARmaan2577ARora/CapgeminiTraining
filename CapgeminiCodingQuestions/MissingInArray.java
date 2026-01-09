import java.util.Scanner;

class MissingInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int xor1 = 0,xor2 = 0;
        for (int i = 1; i <= arr.length+1; i++) {
            xor1 ^= i;
        }
        for (int i : arr) {
            xor2 ^= i;
        }
        sc.close();
        System.out.println(xor1^xor2);
    }
}
