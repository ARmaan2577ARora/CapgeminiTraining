import java.util.*;

public class Q11 {

    public static String ReplaceCharacter(String str, int n, char ch1, char ch2) {

        if(str == null)
            return null;

        if(ch1 == ch2)
            return str;

        boolean found1 = false;
        boolean found2 = false;

        char[] arr = str.toCharArray();

        for(int i = 0; i < n; i++) {

            if(arr[i] == ch1) {
                arr[i] = ch2;
                found1 = true;
            }
            else if(arr[i] == ch2) {
                arr[i] = ch1;
                found2 = true;
            }
        }

        if(!found1 && !found2)
            return str;

        return new String(arr);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        char ch1 = sc.next().charAt(0);
        char ch2 = sc.next().charAt(0);

        String result = ReplaceCharacter(str, str.length(), ch1, ch2);

        System.out.println(result);
    }
}