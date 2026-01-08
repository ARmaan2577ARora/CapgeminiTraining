import java.util.Scanner;
public class ArrayIndexOutOfBoundsDemo {
    public static void generateException(String[] names) {
        System.out.println(names[names.length]); 
    }
    public static void handleException(String[] names) {
        try {
            System.out.println("Accessing invalid index inside try block:");
            System.out.println(names[names.length]); 
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
        }
        catch (RuntimeException e) {
            System.out.println("RuntimeException caught");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int size = sc.nextInt();
        sc.nextLine();
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }
        try {
            generateException(names);
        }
        catch (Exception e) {
            System.out.println("Exception generated in generateException()");
        }
        handleException(names);
        sc.close();
    }
}
