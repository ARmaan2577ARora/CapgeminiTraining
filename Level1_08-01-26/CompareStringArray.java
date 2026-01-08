import java.util.*;
public class CompareStringArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] array1 = StringToArray(str);
        char[] array2 = str.toCharArray();
        sc.close();
        for(int i =0;i<str.length();i++){
            System.out.print(array1[i]+" ");
        }
        System.out.println();
        for(int i =0;i<str.length();i++){
            System.out.print(array2[i]+" ");
        }
        System.out.println();
        if(Arrays.equals(array1,array2)){
            System.out.println("true");
        }
        else{
            System.out.println("False");
        }
    }
    static char[] StringToArray(String str) {
        char[] temp = new char[str.length()];
        for(int i =0;i<str.length();i++){
            temp[i] = str.charAt(i);
        }
        return temp;
    }
}