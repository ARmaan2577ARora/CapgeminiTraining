import java.util.Scanner;

class EdgeOfThree {
    public static int[] edgeOfThree(int a, int b, int c) {
        int[] edges = new int[2];
        edges[0] = Math.min(a, Math.min(b, c));
        edges[1] = Math.max(a, Math.max(b, c));
        return edges;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();  
        int[] result = edgeOfThree(a, b, c);
        System.out.println(result[0] + " " + result[1]);
        scanner.close();
    }    
}
