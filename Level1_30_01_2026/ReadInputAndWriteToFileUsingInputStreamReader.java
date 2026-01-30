package Level1_30_01_2026;

import java.io.*;

class ReadInputAndWriteToFileUsingInputStreamReader {
    public static void main(String[] args) {
        try (InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                FileWriter fw = new FileWriter("UserInput.txt")) {

            System.out.println("Enter text to write to file (type 'exit' to stop):");
            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(line + System.lineSeparator());
            }
            System.out.println("Output written to UserInput.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
