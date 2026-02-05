package Level2_05_02_2026;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NestedTryExample {
    public void readFile(String filePath) {
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Simulate potential parsing error
                    if (line.contains("error")) {
                        throw new NumberFormatException("Parsing error in line");
                    }
                    System.out.println(line);
                }
            } catch (NumberFormatException e) {
                System.err.println("Inner exception: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Outer exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        NestedTryExample example = new NestedTryExample();
        // Note: example.txt should exist for a successful run without IOException
        example.readFile("example.txt");
    }
}
