import java.util.Scanner;
public class StudentGrades2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[][] marks = new int[number][3];
        double[] percentages = new double[number];
        String[] grades = new String[number];
        for (int i = 0; i < number; i++) {
            int p = scanner.nextInt();
            int c = scanner.nextInt();
            int m = scanner.nextInt();
            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Enter positive values");
                i--;
                continue;
            }
            marks[i][0] = p;
            marks[i][1] = c;
            marks[i][2] = m;
            percentages[i] = (p + c + m) / 3.0;
            if (percentages[i] >= 90)
                grades[i] = "A";
            else if (percentages[i] >= 80)
                grades[i] = "B";
            else if (percentages[i] >= 70)
                grades[i] = "C";
            else if (percentages[i] >= 60)
                grades[i] = "D";
            else
                grades[i] = "F";
        }
        for (int i = 0; i < number; i++) {
            System.out.println("Marks: " + marks[i][0] + ", " + marks[i][1] + ", " + marks[i][2] + " Percentage: "
            + percentages[i] + " Grade: " + grades[i]);
        }
        scanner.close();
    }
}
