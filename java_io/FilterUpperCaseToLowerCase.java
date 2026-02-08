package java_io;

import java.io.*;

public class FilterUpperCaseToLowerCase {
    public static void main(String[] args) {
        String inputPath = "uppercase.txt";
        String outputPath = "lowercase.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputPath))) {
            writer.write("THIS IS A TEXT WITH UPPERCASE LETTERS.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            int charData;
            while ((charData = reader.read()) != -1) {
                writer.write(Character.toLowerCase((char) charData));
            }
            System.out.println("File converted to lowercase successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
