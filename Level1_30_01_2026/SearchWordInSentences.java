package Level1_30_01_2026;

class SearchWordInSentences {
    public static void main(String[] args) {
        String[] sentences = {
                "Java is a programming language.",
                "StringBuilder is used for mutable strings.",
                "Linear search is simple.",
                "The quick brown fox jumps over the lazy dog."
        };
        String targetWord = "search";
        String result = searchWord(sentences, targetWord);
        System.out.println("Result: " + result);
    }

    public static String searchWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }
}
