package java8problem.level2folder;

import java.util.*;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "8", "features", "lambda", "streams");

        Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());

        System.out.println("Uppercase strings:");
        list.forEach(printUpper);
    }
}
