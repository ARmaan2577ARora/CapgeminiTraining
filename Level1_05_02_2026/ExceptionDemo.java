package Level1_05_02_2026;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("--- Demonstrating Checked Exception (IOException) ---");
        handleCheckedException();

        System.out.println("\n--- Demonstrating Unchecked Exception (NullPointerException) ---");
        handleUncheckedException();
    }

    // Checked exception: Must be handled with try-catch or declared with 'throws'
    static void handleCheckedException() {
        try {
            File file = new File("non_existent_file.txt");
            FileReader fr = new FileReader(file); // This line can throw IOException
        } catch (IOException e) {
            System.err.println("Checked Exception Caught: " + e.getMessage());
        }
    }

    static void handleUncheckedException() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.err.println("Unchecked Exception Caught: " + e.toString());
        }
    }
}
