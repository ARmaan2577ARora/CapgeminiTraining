import java.util.Scanner;
class SpringSeason {
    public static String isSpringSeason(int month, int day) {
        if ((month == 3 && day >= 20 && day <= 31) || (month == 4 && day >= 1 && day <= 30) || (month == 5 && day >= 1 && day <= 31) || (month == 6 && day >= 1 && day <= 20)) {
            return "Its a Spring Season";
        } else {
            return "Not a Spring Season";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        System.out.println(isSpringSeason(month, day));
        scanner.close();
    }    
}
