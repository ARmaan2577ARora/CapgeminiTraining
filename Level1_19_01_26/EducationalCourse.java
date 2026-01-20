package Level1_19_01_26;
class Course{
    String courseName;
    int duration;
    Course(String courseName,int duration){
        this.courseName = courseName;
        this.duration = duration;
    }   
}
class OnlineCourse extends Course{
    String platform;
    OnlineCourse(String courseName,int duration,String platform){
        super(courseName,duration);
        this.platform = platform;
    }
}
class PaidOnlineCourse extends OnlineCourse{
    int price;
    PaidOnlineCourse(String courseName,int duration,String platform,int price){
        super(courseName,duration,platform);
        this.price = price;
    }
}
class EducationalCourse {
    public static void main(String[] args) {
        PaidOnlineCourse c1 = new PaidOnlineCourse("Java",2,"Coursera",100);
        System.out.println(c1.courseName + " " + c1.duration + " " + c1.platform + " " + c1.price);       
    }    
}
