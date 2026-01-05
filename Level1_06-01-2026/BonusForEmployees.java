import java.util.Scanner;

class BonusForEmployees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int salary = scanner.nextInt();
        int serviceYears = scanner.nextInt();
        int bonus = 0;
        if (serviceYears > 5) {
            bonus = salary * 5 / 100;
        }
        System.out.println("Bonus: " + bonus);
        scanner.close();
    }    
}
