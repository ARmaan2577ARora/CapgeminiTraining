package java8problem.level2folder;

import java.util.*;
import java.util.stream.Collectors;

public class WordAnalysis {
    public static void main(String[] args) {
        String textCorpus = "Java 8 introductes Streams and Lambdas. Streams are powerful. Lambdas are concise. Java 8 is great! "
                +
                "Concise code is better. Power of Streams is visible in Java 8.";

        processWordFrequency(textCorpus, 5);
    }

    public static void processWordFrequency(String corpus, int topN) {
        // 2. Tokenize the text into words: split, remove punctuation, to lowercase
        List<String> words = Arrays.stream(corpus.split("\\W+"))
                .map(String::toLowerCase)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        // 3. Count the frequency of each word
        Map<String, Long> wordCounts = words.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        // 4. & 5. Find and display top N most frequent words
        System.out.println("Top " + topN + " Most Frequent Words:");
        wordCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // 16. To find the second most repeated word
        Optional<String> secondMostFreqWord = wordCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println("\nSecond Most Repeated Word: " + secondMostFreqWord.orElse("N/A"));
    }
}
