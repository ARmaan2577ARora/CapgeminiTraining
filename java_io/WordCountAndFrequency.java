package java_io;

import java.io.*;
import java.util.*;

public class WordCountAndFrequency {
    public static void main(String[] args) {
        String filename = "sample_text.txt";

        // Create dummy text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(
                    "Java is powerful. Java is versatile. Java IO is essential. Java IO is core. Java is everywhere.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Map<String, Integer> wordCount = new HashMap<>();
            String line;
            int totalWords = 0;

            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                        totalWords++;
                    }
                }
            }

            System.out.println("Total word count: " + totalWords);
            System.out.println("Top 5 most frequent words:");
            wordCount.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(5)
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
