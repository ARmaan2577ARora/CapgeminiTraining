import java.util.Scanner;

class ChocolateDistribtion {
    public static int[] distributeChocolates(int totalChocolates, int students) {
        int[] distribution = new int[2];
        distribution[0] = totalChocolates / students; 
        distribution[1] = totalChocolates % students; 
        return distribution;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalChocolates = scanner.nextInt();
        int students = scanner.nextInt();
        int[] result = distributeChocolates(totalChocolates, students);
        System.out.println("Chocolates per head: " + result[0] + " ,chocolates left:" + result[1]);
        scanner.close();
    }    
}
