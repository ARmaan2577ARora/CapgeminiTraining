import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if(s.length() < 4 || s.contains(" ") || s.contains("/") || Character.isDigit(s.charAt(0)) ){
            System.out.println(0);
            return;
        }

        boolean oneNum = false;
        boolean oneCap = false;

        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))) oneNum = true;
            if(Character.isUpperCase(s.charAt(i))) oneCap = true;
        }
        if(oneCap && oneNum){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}
