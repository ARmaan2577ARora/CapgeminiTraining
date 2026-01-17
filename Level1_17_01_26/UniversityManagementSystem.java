package Level1_16_01_26;

class Student {

    int rollNumber;
    String name;
    double cgpa;

    Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    double getCGPA() {
        return cgpa;
    }

    void setCGPA(double cgpa) {
        if (cgpa >= 0.0 && cgpa <= 10.0) {
            this.cgpa = cgpa;
        }
    }
}

class PostgraduateStudent extends Student {

    String specialization;

    PostgraduateStudent(int rollNumber, String name, double cgpa, String specialization) {
        super(rollNumber, name, cgpa);
        this.specialization = specialization;
    }

    void displayDetails() {
        System.out.println(rollNumber);
        System.out.println(name);
        System.out.println(cgpa);
        System.out.println(specialization);
    }
}

public class UniversityManagementSystem {

    public static void main(String[] args) {

        PostgraduateStudent student =
                new PostgraduateStudent(101, "Rahul Sharma", 8.5, "Computer Science");

        student.displayDetails();

        student.setCGPA(9.0);

        System.out.println(student.getCGPA());
    }
}
