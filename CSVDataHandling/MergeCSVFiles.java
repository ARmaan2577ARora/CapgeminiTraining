package CSVDataHandling;

import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "d:/TrainingProjects/CSVDataHandling/students1.csv";
        String file2 = "d:/TrainingProjects/CSVDataHandling/students2.csv";
        String outputFile = "d:/TrainingProjects/CSVDataHandling/students_merged.csv";

        Map<String, String[]> studentData = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            br1.readLine(); // Skip header
            String line;
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                studentData.put(data[0], data); // ID -> [ID, Name, Age]
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader(file2));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            bw.write("ID,Name,Age,Marks,Grade\n");
            br2.readLine(); // Skip header
            String line;
            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                if (studentData.containsKey(id)) {
                    String[] baseInfo = studentData.get(id);
                    // Result: ID, Name, Age, Marks, Grade
                    bw.write(
                            baseInfo[0] + "," + baseInfo[1] + "," + baseInfo[2] + "," + data[1] + "," + data[2] + "\n");
                }
            }
            System.out.println("Merged CSV created at: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
