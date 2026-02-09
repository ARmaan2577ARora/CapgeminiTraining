package CSVDataHandling;

import java.io.FileWriter;
import java.io.IOException;

public class EmployeeDataWriter {
    public static void main(String[] args) {
        String csvFile = "d:/TrainingProjects/CSVDataHandling/employees_new.csv";
        String header = "ID,Name,Department,Salary";
        String[][] employees = {
            {"1", "John", "IT", "50000"},
            {"2", "Sarah", "Sales", "60000"},
            {"3", "Mike", "HR", "45000"},
            {"4", "Emily", "Finance", "55000"},
            {"5", "David", "Marketing", "48000"}
        };

        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.write(header + "\n");
            for (String[] employee : employees) {
                writer.write(String.join(",", employee) + "\n");
            }
            System.out.println("Successfully written 5 records to " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
