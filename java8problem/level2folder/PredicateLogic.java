package java8problem.level2folder;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateLogic {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Elephant", "Ant", "Tiger", "Gorilla", "Alligator", "Lion");

        Predicate<String> lengthGreater5 = s -> s.length() > 5;
        Predicate<String> containsLi = s -> s.contains("li"); // Case-sensitive check or specify requirements

        List<String> result = list.stream()
                .filter(lengthGreater5.and(containsLi))
                .collect(Collectors.toList());

        System.out.println("Strings with length > 5 and containing 'li': " + result);
    }
}
