package CSVDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RowCountCSV {
    public static void main(String[] args) {
        String csvFile = "d:/TrainingProjects/CSVDataHandling/students.csv";
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read header if exists
            String header = br.readLine();
            if (header != null) {
                while (br.readLine() != null) {
                    count++;
                }
            }
            System.out.println("Total records (excluding header): " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
