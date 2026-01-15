package level1_15_01_26;
class Circle {
    double radius;
    void calArea() {
        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
    void calCircumference() {
        double circumference = 2 * 3.14 * radius;
        System.out.println("Circumference of Circle: " + circumference);
    }
    public static void main(String[] args) {
        Circle c = new Circle();
        c.radius = 5;
        c.calArea();
        c.calCircumference();
    }
}
