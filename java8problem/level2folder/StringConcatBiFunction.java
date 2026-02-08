package java8problem.level2folder;

import java.util.function.BiFunction;

public class StringConcatBiFunction {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatWithSpace = (s1, s2) -> s1 + " " + s2;

        String str1 = "Hello";
        String str2 = "World";
        System.out.println("Concatenated string: " + concatWithSpace.apply(str1, str2));
    }
}
