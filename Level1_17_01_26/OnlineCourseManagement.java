package Level1_16_01_26;

class Course{
    String courseName;
    int  duration;
    double fee;

    static String  instituteName = "Chitkara";

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
        Course.instituteName = "LPU";
    }
}
public class OnlineCourseManagement {
    public static void main(String[] args) {
        Course c1 = new Course("Btech",4,85000);
     //   Course c2 = new Course("B.com",3,25000);

        c1.displayCourseDetails();
        Course.updateInstituteName();
        c1.displayCourseDetails();


    }
}
