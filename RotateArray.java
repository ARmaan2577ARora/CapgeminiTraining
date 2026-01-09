import java.util.Scanner;
public class RotateArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        String direction = scanner.next();
        scanner.close();
        if (direction.equals("left")) {
            for (int i = 0; i < k; i++) {
                int first = arr[0];
                for (int j = 0; j < n - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[n - 1] = first;
            }
        } else if (direction.equals("right")) {
            for (int i = 0; i < k; i++) {
                int last = arr[n - 1];
                for (int j = n - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = last;
            }
        } else System.out.println("Invalid direction");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
