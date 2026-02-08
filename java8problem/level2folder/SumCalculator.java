package java8problem.level2folder;

@FunctionalInterface
interface TwoIntOperation {
    int apply(int a, int b);
}

public class SumCalculator {
    public static void main(String[] args) {
        TwoIntOperation sum = (a, b) -> a + b;

        int x = 10, y = 20;
        System.out.println("Sum of " + x + " and " + y + " is: " + sum.apply(x, y));
    }
}
