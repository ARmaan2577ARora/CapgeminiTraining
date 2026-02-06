package RegexPractice;

import java.util.regex.Pattern;

public class SSNValidator {
    public static void main(String[] args) {
        String ssnRegex = "^\\d{3}-\\d{2}-\\d{4}$";
        String[] ssns = { "123-45-6789", "123456789", "123-456-789", "abc-de-fghi" };

        for (String ssn : ssns) {
            boolean isValid = Pattern.matches(ssnRegex, ssn);
            System.out.println(ssn + " → " + (isValid ? "Valid" : "Invalid"));
        }
    }
}
