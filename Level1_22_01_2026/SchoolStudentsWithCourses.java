package Level1_22_01_2026;
import java.util.ArrayList;
class School{
    String name;
    ArrayList<Student> students = new ArrayList<>();
    public School(String name) {
        this.name = name;
    }
    public void addStudent(Student s){
        students.add(s);   
    }
    public void removeStudent(Student s){
        students.remove(s);   
    }
}
class Course{
    String courseName;
    ArrayList<Student> students = new ArrayList<>();
    public Course(String courseName) {
        this.courseName = courseName;
    }
    public void addStudent(Student s){
        students.add(s);
    }
    public void viewStudents(){
        for(Student s : students){
            System.out.println(s.name);
        }
    }
}
class Student{
    String name;
    int rollNo;
    ArrayList<Course> courses = new ArrayList<>();
    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
    public void enrollCourse(Course c){
        courses.add(c);
    }
    public void viewCourses(){
        for(Course c : courses){
            System.out.println(name + " enrolled in " + c.courseName);
        }
    }
}
class SchoolStudentsWithCourses {
    public static void main(String[] args) {
        School s = new School("Capgemini");
        Course c1 = new Course("Java");
        Course c2 = new Course("Python");
        Student s1 = new Student("Ram", 1);
        Student s2 = new Student("Shyam", 2);
        s.addStudent(s1);
        s.addStudent(s2);
        
        c1.addStudent(s1);
        c1.addStudent(s2);
        c2.addStudent(s1);
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);

        s1.viewCourses();
        s2.viewCourses();
        c1.viewStudents();
        c2.viewStudents();
    }    
}
