package level3_02_01_26;

import java.util.*;
public class GradeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Physics marks: ");
        int physics = sc.nextInt();

        System.out.print("Enter Chemistry marks: ");
        int chemistry = sc.nextInt();

        System.out.print("Enter Maths marks: ");
        int maths = sc.nextInt();

        int total = physics + chemistry + maths;
        double percentage = (total / 300.0) * 100;

        char grade;
        String remarks;

        if (percentage >= 80) {
            grade = 'A';
            remarks = "Level 4, above agency-normalized standards";
        } else if (percentage >= 70) {
            grade = 'B';
            remarks = "Level 3, at agency-normalized standards";
        } else if (percentage >= 60) {
            grade = 'C';
            remarks = "Level 2, approaching agency-normalized standards";
        } else if (percentage >= 50) {
            grade = 'D';
            remarks = "Level 1, well below agency-normalized standards";
        } else if (percentage >= 40) {
            grade = 'E';
            remarks = "Too below agency-normalized standards";
        } else {
            grade = 'R';
            remarks = "Remedial standards";
        }

        System.out.println("\n----- RESULT -----");
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);


    }
}