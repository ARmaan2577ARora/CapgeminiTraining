import java.util.Scanner;
class StringIsPangram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.toLowerCase();
        int[] count = new int[26];
        for(int i = 0; i < str.length(); i++){
            count[str.charAt(i) - 'a']++;
        }
        boolean isPan = true;
        for(int i = 0; i < 26; i++){
            if(count[i] == 0){
                isPan = false;
                break;
            }
        }
        if (isPan) {
            System.out.println("Pangram");
        }
        else System.out.println("Not Pangram");
        sc.close();
    }    
}
