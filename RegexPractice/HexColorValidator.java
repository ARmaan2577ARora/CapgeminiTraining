package RegexPractice;

import java.util.regex.Pattern;

public class HexColorValidator {
    public static void main(String[] args) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        String[] colors = { "#FFA500", "#ff4500", "#123", "#G12345", "#AABBCC" };

        for (String color : colors) {
            boolean isValid = Pattern.matches(regex, color);
            System.out.println(color + " → " + (isValid ? "Valid" : "Invalid"));
        }
    }
}
