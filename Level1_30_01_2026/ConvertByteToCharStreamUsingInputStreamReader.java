package Level1_30_01_2026;

import java.io.*;

class ConvertByteToCharStreamUsingInputStreamReader {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("Sample.txt");
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
