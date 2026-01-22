package Level1_22_01_2026;
import java.util.ArrayList;

class Company{
    String name;
    ArrayList<Department> departments = new ArrayList<>();
    public Company(String name) {
        this.name = name;
    }
    public void addDepartment(String deptName){
        departments.add(new Department(deptName));
    }
    public void removeCompany(){
        departments.clear(); 
        System.out.println("Company removed");  
    }
}
class Department{
    String deptName;
    ArrayList<Employee> employees = new ArrayList<>();
    public Department(String deptName) {
        this.deptName = deptName;
    }
    public void addEmployee(String name,int id){
        employees.add(new Employee(name,id));
    }
}
class Employee{
    String name;
    int id;
    Employee(String name,int id){
        this.name = name;
        this.id = id;
    }
}
class CompanyAndDepartments{
    public static void main(String[] args) {
        Company c = new Company("Capgemini");
        c.addDepartment("IT");
        c.departments.get(0).addEmployee("Ram",1);
        System.out.println(c.departments.get(0).employees.get(0).name);
        c.removeCompany();//lifecycle ended
    }    
}
