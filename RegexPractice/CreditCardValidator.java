package RegexPractice;

import java.util.regex.Pattern;

public class CreditCardValidator {
    public static void main(String[] args) {
        String visaRegex = "^4\\d{15}$";
        String mastercardRegex = "^5\\d{15}$";

        String[] cards = { "4123456789012345", "5123456789012345", "3123456789012345", "4123", "51234567890123456" };

        for (String card : cards) {
            boolean isVisa = Pattern.matches(visaRegex, card);
            boolean isMaster = Pattern.matches(mastercardRegex, card);

            if (isVisa)
                System.out.println(card + " → Valid Visa");
            else if (isMaster)
                System.out.println(card + " → Valid MasterCard");
            else
                System.out.println(card + " → Invalid");
        }
    }
}
