import java.util.Scanner;

class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        if (m1 != n2) {
            System.out.println("Not possible");
            sc.close();
            return;
        }
        int[][] a = new int[n1][m1];
        int[][] b = new int[n2][m2];
        int[][] res = new int[n1][m2];
        for (int i = 0; i < n1; i++) {
            for(int j = 0;j < m1;j++){
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n2; i++) {
            for(int j = 0;j < m2;j++){
                b[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < m1; k++) {
                    res[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }    
}
