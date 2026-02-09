package CSVDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterStudentsByMarks {
    public static void main(String[] args) {
        String csvFile = "d:/TrainingProjects/CSVDataHandling/students.csv";
        String line;
        String cvsSplitBy = ",";

        System.out.println("Students with Marks > 80:");
        System.out.println("----------------------------------------------");
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] student = line.split(cvsSplitBy);
                int marks = Integer.parseInt(student[3]);
                if (marks > 80) {
                    System.out.println("ID: " + student[0] + ", Name: " + student[1] + ", Marks: " + student[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
