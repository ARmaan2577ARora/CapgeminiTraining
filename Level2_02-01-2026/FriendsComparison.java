import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amar's age and height: ");
        int amarAge = sc.nextInt();
        int amarHeight = sc.nextInt();

        System.out.print("Enter Akbar's age and height: ");
        int akbarAge = sc.nextInt();
        int akbarHeight = sc.nextInt();

        System.out.print("Enter Anthony's age and height: ");
        int anthonyAge = sc.nextInt();
        int anthonyHeight = sc.nextInt();

        int youngestAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        int tallestHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));

        System.out.println("Youngest Age: " + youngestAge);
        System.out.println("Tallest Height: " + tallestHeight);
    }
}
