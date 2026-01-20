package Level1_19_01_26;
class Employee {
    String name;
    int id;
    double salary;    
    void displayDetails(){};
    Employee(String name,int id,double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    };
}
class Manager extends Employee{
    int teamSize;
    @Override
    void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
        System.out.println("Team Size: " + teamSize);
    };
    Manager(String name,int id,double salary,int teamSize){
        super(name,id,salary);
        this.teamSize = teamSize;
    }   
}
class Developer extends Employee{
    String programmingLanguage;
    @Override
    void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
        System.out.println("Programming Language: " + programmingLanguage);
    };
    Developer(String name,int id,double salary,String programmingLanguage){
        super(name,id,salary);
        this.programmingLanguage = programmingLanguage;
    }   
}
class Intern extends Employee{
    Intern(String name,int id,double salary){
        super(name,id,salary);
    }   
    @Override
    void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
        System.out.println("Intern");
    };
}
class EmployeeManagement {
    public static void main(String[] args) {
        Manager manager = new Manager("Shyam",1,10000,10);
        Developer developer = new Developer("Ravi",2,10000,"Java");
        Intern intern = new Intern("Rahul",3,10000);
        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }    
}
