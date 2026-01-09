import java.util.Scanner;
class ReverseWordsInSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] words = str.split(" ");
        for(String word : words){
            char[] ch = word.toCharArray();
            for(int i = ch.length - 1; i >= 0; i--){
                System.out.print(ch[i]);
            }
            System.out.print(" ");
        }
        sc.close();
    }    
}
