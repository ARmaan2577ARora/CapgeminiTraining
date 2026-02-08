package java8problem.level2folder;

import java.util.function.Function;

public class CircleAreaFunction {
    public static void main(String[] args) {
        Function<Double, Double> calculateArea = r -> Math.PI * r * r;

        double radius = 5.0;
        System.out.println("Area of circle with radius " + radius + " is: " + calculateArea.apply(radius));
    }
}
