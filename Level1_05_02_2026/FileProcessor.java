package Level1_05_02_2026;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
    public static void main(String[] args) {
        String fileName = "d:/CapgeminiTrainingProjects/Level1_05_02_2026/sample.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Reading file content using Try-With-Resources:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        
        System.out.println("\nResource automatically closed.");
    }
}
