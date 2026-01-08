import java.util.Scanner;
public class VowelCount {
    static String checkChar(char ch) {
        if (ch >= 'A' && ch <= 'Z')
            ch = (char)(ch + 32);
        if (ch >= 'a' && ch <= 'z') {
            if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                return "Vowel";
            else
                return "Consonant";
        }
        return "Not a Letter";
    }
    static int[] countVAndC(String str) {
        int v = 0, c = 0;
        for (int i = 0; i < str.length(); i++) {
            String res = checkChar(str.charAt(i));
            if (res.equals("Vowel")) v++;
            else if (res.equals("Consonant")) c++;
        }
        return new int[]{v, c};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] result = countVAndC(text);
        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);
        sc.close();
    }
}
