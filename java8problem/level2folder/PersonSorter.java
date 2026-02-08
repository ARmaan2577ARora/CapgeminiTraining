package java8problem.level2folder;

import java.util.*;

class Person {
    String name;
    int age;
    double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class PersonSorter {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25, 50000),
                new Person("Bob", 30, 60000),
                new Person("Charlie", 22, 45000),
                new Person("David", 28, 55000));

        people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        System.out.println("Persons sorted by age:");
        people.forEach(System.out::println);
    }
}
