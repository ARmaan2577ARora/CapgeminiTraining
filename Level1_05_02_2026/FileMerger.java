package Level1_05_02_2026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileMerger {
    public static void main(String[] args) {
        String input1Path = "d:/TrainingProjects/Level1_05_02_2026/input1.txt";
        String input2Path = "d:/TrainingProjects/Level1_05_02_2026/input2.txt";
        String outputPath = "d:/TrainingProjects/Level1_05_02_2026/merged.txt";

        System.out.println("Merging files using Try-With-Resources with multiple resources...");

        try (BufferedReader reader1 = new BufferedReader(new FileReader(input1Path));
                BufferedReader reader2 = new BufferedReader(new FileReader(input2Path));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String line;
            writer.write("--- Content from File 1 ---\n");
            while ((line = reader1.readLine()) != null) {
                writer.write(line + "\n");
            }

            writer.write("\n--- Content from File 2 ---\n");
            while ((line = reader2.readLine()) != null) {
                writer.write(line + "\n");
            }

            System.out.println("Merge complete! Output saved to: " + outputPath);

        } catch (IOException e) {
            System.err.println("An error occurred during file merging: " + e.getMessage());
        }
    }
}
