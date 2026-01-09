import java.util.Scanner;
class RemoveVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = "";
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (vowels.indexOf(str.charAt(i)) == -1) {
                res += str.charAt(i);
            }
        }
        System.out.println(res);
        sc.close();
    }    
}
