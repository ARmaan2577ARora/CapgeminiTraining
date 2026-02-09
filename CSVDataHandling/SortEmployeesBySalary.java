package CSVDataHandling;

import java.io.*;
import java.util.*;

public class SortEmployeesBySalary {
    public static void main(String[] args) {
        String csvFile = "d:/TrainingProjects/CSVDataHandling/employees.csv";
        List<String[]> employees = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                employees.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort by salary descending
        Collections.sort(employees, new Comparator<String[]>() {
            @Override
            public int compare(String[] e1, String[] e2) {
                Double s1 = Double.parseDouble(e1[3]);
                Double s2 = Double.parseDouble(e2[3]);
                return s2.compareTo(s1);
            }
        });

        System.out.println("Top 5 Highest-Paid Employees:");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            String[] emp = employees.get(i);
            System.out.println("ID: " + emp[0] + ", Name: " + emp[1] + ", Dept: " + emp[2] + ", Salary: " + emp[3]);
        }
    }
}
