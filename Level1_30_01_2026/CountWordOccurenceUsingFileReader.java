package Level1_30_01_2026;
import java.io.*;
class CountWordOccurenceUsingFileReader {
    public static void main(String[] args) {
        try {
            File file = new File("Sample.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String word = "Developer";
            int count = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String w : words) {
                    if (w.equals(word)) {
                        count++;
                    }
                }
            }
            System.out.println(word + " , " + count);
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
}