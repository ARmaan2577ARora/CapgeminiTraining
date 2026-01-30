package Level1_30_01_2026;

import java.io.*;

class CompareAllStringAndFileReaders {
    public static void main(String[] args) {
        compareStringClasses();
        compareFileReaders();
    }

    public static void compareStringClasses() {
        int iterations = 1_000_000;
        String s = "hello";

        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++)
            sb.append(s);
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++)
            sbf.append(s);
        end = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (end - start) + "ms");
    }

    public static void compareFileReaders() {
        String filename = "Sample.txt";

        // FileReader
        long start = System.currentTimeMillis();
        int wordCountFR = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCountFR += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("FileReader error: " + e.getMessage());
        }
        long end = System.currentTimeMillis();
        System.out.println("FileReader Word Count: " + wordCountFR + " Time: " + (end - start) + "ms");

        // InputStreamReader
        start = System.currentTimeMillis();
        int wordCountISR = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCountISR += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("InputStreamReader error: " + e.getMessage());
        }
        end = System.currentTimeMillis();
        System.out.println("InputStreamReader Word Count: " + wordCountISR + " Time: " + (end - start) + "ms");
    }
}
