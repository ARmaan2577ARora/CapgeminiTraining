package CSVDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeSearch {
    public static void main(String[] args) {
        String csvFile = "d:/TrainingProjects/CSVDataHandling/employees.csv";
        String line;
        String cvsSplitBy = ",";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter employee name to search: ");
            String searchName = scanner.nextLine();
            boolean found = false;

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                br.readLine(); // Skip header
                while ((line = br.readLine()) != null) {
                    String[] employee = line.split(cvsSplitBy);
                    if (employee[1].equalsIgnoreCase(searchName)) {
                        System.out.println("Employee Found!");
                        System.out.println("Department: " + employee[2]);
                        System.out.println("Salary: " + employee[3]);
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
