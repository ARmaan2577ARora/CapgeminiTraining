package java8problem.level2folder;

import java.util.*;

public class OptionalMax {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 45, 23, 89, 5, 67);
        findMax(numbers);

        List<Integer> emptyList = Collections.emptyList();
        findMax(emptyList);
    }

    public static void findMax(List<Integer> list) {
        Optional<Integer> maxVal = list.stream().max(Integer::compare);

        if (maxVal.isPresent()) {
            System.out.println("Maximum value: " + maxVal.get());
        } else {
            System.out.println("The list is empty, no maximum value found.");
        }
    }
}
