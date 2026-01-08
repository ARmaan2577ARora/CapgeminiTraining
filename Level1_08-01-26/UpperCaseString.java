import java.util.Scanner;
public class UpperCaseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "armaan";
        String result1 = tooUpper(str);
        System.out.println(result1);
        String result2 = str.toUpperCase();
        System.out.println(result2);
        sc.close();
        if(result1.equals(result2)){
            System.out.println("true");
            return;
        }
        else{
            System.out.println("false");
            return;
        }
    }
    static String tooUpper(String str) {
        String st = "";
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            int val = (int) ch - 32;
            st += (char) val;
        }
        return st;
    }
}
