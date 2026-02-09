package CSVDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {
    public static void main(String[] args) {
        String csvFile = "d:/TrainingProjects/CSVDataHandling/students_with_dupes.csv";
        setupDupeFile(csvFile);

        Set<String> ids = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); 
            String line;
            System.out.println("Detecting duplicates based on ID:");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                if (!ids.add(id)) {
                    System.out.println("Duplicate ID found: " + id + " in record: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setupDupeFile(String path) {
        try (java.io.FileWriter fw = new java.io.FileWriter(path)) {
            fw.write("ID,Name,Age,Marks\n");
            fw.write("101,John Doe,20,85\n");
            fw.write("102,Jane Smith,22,78\n");
            fw.write("101,John Duplicate,20,85\n");
            fw.write("103,Mike Johnson,21,92\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
