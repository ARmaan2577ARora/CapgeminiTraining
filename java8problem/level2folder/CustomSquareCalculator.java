package java8problem.level2folder;

@FunctionalInterface
interface SquareCalculator {
    int calculate(int n);

    default void printResult(int input, int result) {
        System.out.println("The square of " + input + " is: " + result);
    }
}

public class CustomSquareCalculator {
    public static void main(String[] args) {
        SquareCalculator sc = n -> n * n;

        int num = 8;
        int res = sc.calculate(num);
        sc.printResult(num, res);
    }
}
