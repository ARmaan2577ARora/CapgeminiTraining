package Level1_30_01_2026;
import java.util.*;
class RemoveDuplicatesFromStringUsingBuilder {
    public static void main(String[] args) {
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        String str = "aabbbcdddd";
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }    
}
