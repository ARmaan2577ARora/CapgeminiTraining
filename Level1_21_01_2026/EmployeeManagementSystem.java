interface Department {
    void assignDepartment(String deptName);

    String getDepartmentDetails();
}

abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;

    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}

class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(String employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary();
    }

    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Full-Time");
        System.out.println(getDepartmentDetails());
        System.out.println("Calculated Salary: " + calculateSalary());
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int workHours;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(String employeeId, String name, int workHours, double hourlyRate) {
        super(employeeId, name, 0);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workHours * hourlyRate;
    }

    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Part-Time");
        System.out.println(getDepartmentDetails());
        System.out.println("Calculated Salary: " + calculateSalary());
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];

        FullTimeEmployee ft = new FullTimeEmployee("FT101", "John Doe", 50000);
        ft.assignDepartment("Engineering");
        employees[0] = ft;

        PartTimeEmployee pt = new PartTimeEmployee("PT201", "Jane Smith", 40, 25);
        pt.assignDepartment("Marketing");
        employees[1] = pt;

        System.out.println("--- Employee Management System ---");
        for (Employee emp : employees) {
            if (emp != null) {
                emp.displayDetails();
            }
        }
    }
}
