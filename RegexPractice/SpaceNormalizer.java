package RegexPractice;

public class SpaceNormalizer {
    public static void main(String[] args) {
        String input = "This  is   an  example    with multiple  spaces.";
        String output = input.replaceAll("\\s+", " ");

        System.out.println("Original: [" + input + "]");
        System.out.println("Normalized: [" + output + "]");
    }
}
