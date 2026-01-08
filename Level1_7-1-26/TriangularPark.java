import java.util.Scanner;
class TriangularPark {
    public static int rounds(int a, int b , int c) {
        return (a + b + c)/500;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int side1 = scanner.nextInt();
        int side2 = scanner.nextInt();
        int side3 = scanner.nextInt();
        System.out.println("Rounds in 5km : " + rounds(side1, side2, side3));
        scanner.close();
    }    
}
