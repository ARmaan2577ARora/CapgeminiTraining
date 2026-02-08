package java8problem.level2folder;

import java.util.*;
import java.util.stream.Collectors;

public class StringFilter {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Apricot", "Avocado", "Cherry", "Date");

        List<String> filteredList = list.stream()
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Strings starting with 'A': " + filteredList);
    }
}
