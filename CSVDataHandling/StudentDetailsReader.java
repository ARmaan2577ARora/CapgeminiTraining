package CSVDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentDetailsReader {
    public static void main(String[] args) {
        String csvFile = "d:/TrainingProjects/CSVDataHandling/students.csv";
        String line;
        String cvsSplitBy = ",";

        System.out.println("Reading Student Details:");
        System.out.println("--------------------------------------------------");
        System.out.println("ID | Name | Age | Marks");
        System.out.println("--------------------------------------------------");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] student = line.split(cvsSplitBy);
                System.out.println(student[0] + " | " + student[1] + " | " + student[2] + " | " + student[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
