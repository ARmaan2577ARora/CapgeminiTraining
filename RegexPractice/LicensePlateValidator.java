package RegexPractice;

import java.util.regex.Pattern;

public class LicensePlateValidator {
    public static void main(String[] args) {
        String regex = "^[A-Z]{2}\\d{4}$";
        String[] plates = { "AB1234", "A12345", "BC9876", "XY123", "XY12345" };

        for (String plate : plates) {
            boolean isValid = Pattern.matches(regex, plate);
            System.out.println(plate + " → " + (isValid ? "Valid" : "Invalid"));
        }
    }
}
