import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String title;

    public CourseType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void showDetails();
}

class ExamCourse extends CourseType {
    public ExamCourse(String title) {
        super(title);
    }

    @Override
    public void showDetails() {
        System.out.println("Exam-Based Course: " + getTitle() + " (Focus: Written Examination)");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title) {
        super(title);
    }

    @Override
    public void showDetails() {
        System.out.println("Assignment-Based Course: " + getTitle() + " (Focus: Project Submissions)");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title) {
        super(title);
    }

    @Override
    public void showDetails() {
        System.out.println("Research-Based Course: " + getTitle() + " (Focus: Thesis and Publications)");
    }
}

class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();

    public void addCourse(T course) {
        courseList.add(course);
    }

    public List<T> getCourseList() {
        return courseList;
    }
}

public class UniversityCourseManagement {

    public static void printAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.showDetails();
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> mathDept = new Course<>();
        mathDept.addCourse(new ExamCourse("Advanced Calculus"));
        mathDept.addCourse(new ExamCourse("Linear Algebra"));

        Course<AssignmentCourse> artsDept = new Course<>();
        artsDept.addCourse(new AssignmentCourse("Digital Illustration"));
        artsDept.addCourse(new AssignmentCourse("Creative Writing"));

        Course<ResearchCourse> scienceDept = new Course<>();
        scienceDept.addCourse(new ResearchCourse("Quantum Computing Research"));
        scienceDept.addCourse(new ResearchCourse("Cancer Biology thesis"));

        System.out.println("--- Math Department ---");
        printAllCourses(mathDept.getCourseList());

        System.out.println("\n--- Arts Department ---");
        printAllCourses(artsDept.getCourseList());

        System.out.println("\n--- Science Department ---");
        printAllCourses(scienceDept.getCourseList());

        List<CourseType> universityCatalog = new ArrayList<>();
        universityCatalog.addAll(mathDept.getCourseList());
        universityCatalog.addAll(artsDept.getCourseList());
        universityCatalog.addAll(scienceDept.getCourseList());

        System.out.println("\n--- Full University Catalog ---");
        printAllCourses(universityCatalog);
    }
}
