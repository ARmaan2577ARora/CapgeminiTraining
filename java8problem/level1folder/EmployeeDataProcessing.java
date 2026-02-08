package java8problem.level1folder;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}

public class EmployeeDataProcessing {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "Engineering", 90000),
            new Employee(2, "Bob", "Engineering", 75000),
            new Employee(3, "Charlie", "HR", 60000),
            new Employee(4, "David", "Engineering", 100000),
            new Employee(5, "Eve", "Marketing", 85000),
            new Employee(6, "Frank", "Engineering", 82000)
        );

        processEmployees(employees);
    }

    public static void processEmployees(List<Employee> employees) {
        
        List<Employee> filteredAndSorted = employees.stream()
            .filter(e -> "Engineering".equals(e.getDepartment()) && e.getSalary() > 80000)
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .collect(Collectors.toList());

        System.out.println("Filtered and Sorted Employees:");
        filteredAndSorted.forEach(System.out::println);

        Map<String, List<Employee>> groupedByDept = filteredAndSorted.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

        Map<String, Double> avgSalaryPerDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("\nAverage Salary per Department:");
        avgSalaryPerDept.forEach((dept, avg) -> System.out.println(dept + ": " + avg));
    }
}
