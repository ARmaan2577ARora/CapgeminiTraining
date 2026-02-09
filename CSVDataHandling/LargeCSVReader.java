package CSVDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {
    public static void main(String[] args) {
        String csvFile = "d:/TrainingProjects/CSVDataHandling/students.csv"; // Using existing file for demo
        int chunkSize = 2; // Processing in small chunks for demonstration
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // Skip header
            String line;
            while (true) {
                int linesInChunk = 0;
                while (linesInChunk < chunkSize && (line = br.readLine()) != null) {
                    // Process line
                    count++;
                    linesInChunk++;
                }
                if (linesInChunk == 0)
                    break;
                System.out.println("Processed " + count + " records so far...");
            }
            System.out.println("Finished processing " + count + " records.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
