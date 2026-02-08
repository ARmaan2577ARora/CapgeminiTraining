package java_io;

import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        String sourcePath = "source.txt";
        String destPath = "destination.txt";

        File sourceFile = new File(sourcePath);
        if (!sourceFile.exists()) {
            try (FileWriter fw = new FileWriter(sourceFile)) {
                fw.write("This is a sample text for file handling.");
            } catch (IOException e) {
                System.err.println("Error creating source file: " + e.getMessage());
            }
        }

        try (FileInputStream fis = new FileInputStream(sourcePath);
                FileOutputStream fos = new FileOutputStream(destPath)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied successfully using FileInputStream/FileOutputStream.");
        } catch (FileNotFoundException e) {
            System.err.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO Error occurred: " + e.getMessage());
        }
    }
}
