import java.util.Scanner;
public class CompareTwoStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        boolean customResult = compareTo(str1,str2);
        boolean equalsResult = str1.equals(str2);
        System.out.println("Using charAt(): " + customResult);
        System.out.println("Using equals(): " + equalsResult);
        System.out.println("Results match: " + (customResult == equalsResult));
        sc.close();
    }
    static boolean compareTo(String s1 ,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        for(int i =0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return false;
            }
        }
        return true;
    }
}