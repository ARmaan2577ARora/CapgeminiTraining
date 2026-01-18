package Level1_17_01_26;

class Course{
    String courseName;
    int  duration;
    double fee;

    static String  instituteName = "Chitkara University";

    Course(String name,int duration,int fee){
        this.courseName = name;
        this.duration = duration;
        this.fee = fee;
    }
    void displayCourseDetails(){
        System.out.println(courseName);
        System.out.println(duration);
        System.out.println(fee);
        System.out.println(instituteName);
    }
    static void updateInstituteName(){
        Course.instituteName = "Thapar";
    }
}
public class OnlineCourseManagement {
    public static void main(String[] args) {
        Course c1 = new Course("B.com",4,75000);
     //   Course c2 = new Course("Btech",3,35000);
        c1.displayCourseDetails();
        Course.updateInstituteName();
        c1.displayCourseDetails();

    }
}
