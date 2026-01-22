package Level1_22_01_2026;
import java.util.ArrayList;

class University{
    String name;
    ArrayList<Faculty> faculties = new ArrayList<>();
    ArrayList<Department> departments = new ArrayList<>();
    public University(String name) {
        this.name = name;
    }
    public void addDepartment(String name){
        departments.add(new Department(name));
    }
    public void addFaculty(Faculty f){
        faculties.add(f);
    }
    public void removeUniversity(){
        faculties.clear();
        departments.clear();
        System.out.println("University removed");
    }
    @Override
    public String toString() {
        return "University [name=" + name + ", faculties=" + faculties + ", departments=" + departments + "]";
    }
}
class Faculty{
    String name;
    int id;
    public Faculty(String name, int id) {
        this.name = name;
        this.id = id;
    }
    @Override
    public String toString() {
        return "Faculty [name=" + name + ", id=" + id + "]";
    }
}
class Department{
    String name;
    ArrayList<Faculty> faculties = new ArrayList<>();
    public Department(String name) {
        this.name = name;
    }
    public void addFaculty(Faculty f){
        faculties.add(f);
    }
    @Override
    public String toString() {
        return "Department [name=" + name + ", faculties=" + faculties + "]";
    }
}
class UniversityWithFacultiesAndDepartments {
    public static void main(String[] args) {
        University u = new University("Capgemini");
        Department d = new Department("IT");
        Faculty f = new Faculty("Ram",1);
        u.addDepartment("IT");
        u.addFaculty(f);
        System.out.println(u);
        System.out.println(d);
        System.out.println(f);
        u.removeUniversity();
    }
}
