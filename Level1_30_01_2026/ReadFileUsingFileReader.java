package Level1_30_01_2026;

import java.io.*;

class ReadFileUsingFileReader {
    public static void main(String[] args) {
        try {
            File file = new File("Sample.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}