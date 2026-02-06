package RegexPractice;

import java.util.regex.Pattern;

public class UsernameValidator {
    public static void main(String[] args) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        String[] usernames = {"user_123", "123user", "us", "valid_user_99", "too_long_username_123"};

        for (String username : usernames) {
            boolean isValid = Pattern.matches(regex, username);
            System.out.println(username + " → " + (isValid ? "Valid" : "Invalid"));
        }
    }
}
