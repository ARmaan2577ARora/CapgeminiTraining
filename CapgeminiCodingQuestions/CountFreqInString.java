import java.util.Scanner;
class CountFreqInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] freq = new int[26];
        str = str.toLowerCase();
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
            freq[str.charAt(i) -'a']++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println((char)(i+'a') + " " + freq[i]);
            }
        }
        sc.close();
    }    
}
