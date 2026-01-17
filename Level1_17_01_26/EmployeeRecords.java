package Level1_16_01_26;

class Employee {

    int employeeID;
    String department;
    double salary;

    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    double getSalary() {
        return salary;
    }

    void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }
}

class Manager extends Employee {

    String designation;

    Manager(int employeeID, String department, double salary, String designation) {
        super(employeeID, department, salary);
        this.designation = designation;
    }

    void displayDetails() {
        System.out.println(employeeID);
        System.out.println(department);
        System.out.println(getSalary());
        System.out.println(designation);
    }
}

public class EmployeeRecords {

    public static void main(String[] args) {

        Manager manager = new Manager(1001, "IT", 75000.0, "Project Manager");

        manager.displayDetails();

        manager.setSalary(85000.0);

        System.out.println(manager.getSalary());
    }
}
