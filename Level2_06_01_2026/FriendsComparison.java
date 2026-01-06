import java.util.Scanner;
public class FriendsComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[3]; 
        double[] heights = new double[3];
        String[] names = { "Amar", "Akbar", "Anthony" };
        for (int i = 0; i < 3; i++) {
            ages[i] = scanner.nextInt();
            heights[i] = scanner.nextDouble();
        }
        int minAge = ages[0];
        int youngIndex = 0;
        double maxHeight = heights[0];
        int tallIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngIndex = i;
            }
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallIndex = i;
            }
        }
        System.out.println("Youngest: " + names[youngIndex]);
        System.out.println("Tallest: " + names[tallIndex]);
        scanner.close();
    }
}
