package CSVDataHandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
}

public class DBToCSVReport {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 60000));
        employees.add(new Employee(103, "Charlie", "Finance", 55000));

        String outputFile = "d:/TrainingProjects/CSVDataHandling/db_report.csv";

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("Employee ID,Name,Department,Salary\n");
            for (Employee emp : employees) {
                writer.write(emp.id + "," + emp.name + "," + emp.department + "," + emp.salary + "\n");
            }
            System.out.println("CSV Report generated from mock database: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
