package Level1_16_01_26;

class Circle{
    int radius;

    Circle(){
        this(1);
       // System.out.println("Default Constructor");
    }

    Circle(int r){
        this.radius = r;
    }

}
public class CircleClass {
    public static void main(String[] args) {
        Circle c1 = new Circle();     // radius = 1
        Circle c2 = new Circle(5);    // radius = 5

        System.out.println(c1.radius);
        System.out.println(c2.radius);

    }
}
