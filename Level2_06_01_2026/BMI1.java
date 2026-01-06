import java.util.Scanner;
public class BMI1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        double[] weights = new double[number];
        double[] heights = new double[number];
        double[] bmis = new double[number];
        String[] status = new String[number];
        for (int i = 0; i < number; i++) {
            weights[i] = scanner.nextDouble();
            heights[i] = scanner.nextDouble();
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            if (bmis[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmis[i] < 25) {
                status[i] = "Normal";
            } else if (bmis[i] < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        for (int i = 0; i < number; i++) {
            System.out.println(
                    "Height: " + heights[i] + " Weight: " + weights[i] + " BMI: " + bmis[i] + " Status: " + status[i]);
        }
        scanner.close();
    }
}
