package RegexPractice;

import java.util.regex.Pattern;

public class IPAddressValidator {
    public static void main(String[] args) {
        String ipv4Regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        String[] ips = { "192.168.1.1", "255.255.255.255", "0.0.0.0", "256.0.0.1", "123.456.78.90", "1.2.3" };

        for (String ip : ips) {
            boolean isValid = Pattern.matches(ipv4Regex, ip);
            System.out.println(ip + " → " + (isValid ? "Valid" : "Invalid"));
        }
    }
}
