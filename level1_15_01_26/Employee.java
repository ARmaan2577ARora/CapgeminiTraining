package level1_15_01_26;
class Employee {
    String name;
    int id;
    double salary;
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: " + salary);
    }
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.name = "Armaan";
        emp.id = 111;
        emp.salary = 65000.00;
        emp.displayDetails();
    }
}
