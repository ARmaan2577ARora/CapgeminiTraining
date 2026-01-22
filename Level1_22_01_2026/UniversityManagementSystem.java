package Level1_22_01_2026;
import java.util.ArrayList;
import java.util.List;

class Course {
    String courseName;
    String courseCode;
    Professor professor;
    List<Student> enrolledStudents;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.enrolledStudents = new ArrayList<>();
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    @Override
    public String toString() {
        return courseName + " [" + courseCode + "]";
    }
}

class Professor {
    String name;
    String department;
    List<Course> teachingCourses;

    public Professor(String name, String department) {
        this.name = name;
        this.department = department;
        this.teachingCourses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        if (!teachingCourses.contains(course)) {
            teachingCourses.add(course);
            course.setProfessor(this);
            System.out.println("Professor " + name + " assigned to teach " + course.courseName + ".");
        }
    }

    @Override
    public String toString() {
        return "Prof. " + name + " (" + department + ")";
    }
}

class Student {
    String name;
    String id;
    List<Course> enrolledCourses;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.enrollStudent(this);
            System.out.println("Student " + name + " enrolled in " + course.courseName + ".");
        }
    }

    public void showEnrollments() {
        System.out.println("--- Courses for Student " + name + " ---");
        for (Course c : enrolledCourses) {
            String profName = (c.professor != null) ? c.professor.name : "To be assigned";
            System.out.println("- " + c.courseName + " (Taught by: Prof. " + profName + ")");
        }
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Professor profWilson = new Professor("Wilson", "Computer Science");
        Professor profDavis = new Professor("Davis", "Mathematics");

        Course javaProg = new Course("Java Programming", "CS101");
        Course calculus = new Course("Calculus I", "MATH101");

        Student s1 = new Student("Bob", "S2026-01");
        Student s2 = new Student("Alice", "S2026-02");

        // Assigning professors to courses (Communication)
        profWilson.assignCourse(javaProg);
        profDavis.assignCourse(calculus);

        // Enrolling students in courses (Association)
        s1.enrollCourse(javaProg);
        s1.enrollCourse(calculus);
        s2.enrollCourse(javaProg);

        System.out.println();
        s1.showEnrollments();
        System.out.println();
        s2.showEnrollments();
    }
}
