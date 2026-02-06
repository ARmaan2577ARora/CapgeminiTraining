package RegexPractice;

public class WordCensor {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        String[] badWords = { "damn", "stupid" };

        String censoredText = text;
        for (String word : badWords) {
            censoredText = censoredText.replaceAll("(?i)\\b" + word + "\\b", "****");
        }

        System.out.println("Original: " + text);
        System.out.println("Censored: " + censoredText);
    }
}
