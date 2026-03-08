import java.util.*;

public class Q9 {

    public static String MoveHyphen(String str, int n) {

        if(str == null)
            return null;

        StringBuilder hyphen = new StringBuilder();
        StringBuilder letters = new StringBuilder();

        for(int i = 0; i < n; i++) {
            if(str.charAt(i) == '-')
                hyphen.append('-');
            else
                letters.append(str.charAt(i));
        }

        return hyphen.toString() + letters.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String result = MoveHyphen(str, str.length());

        System.out.println(result);
    }
}