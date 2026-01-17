package Level1_16_01_26;

class Person{
    String name;
    int age;

    Person(String name , int age){
        this.name = name;
        this.age = age;
    }

    Person(Person p1){
        this.name = p1.name;
        this.age = p1.age;
    }

}
public class PersonClass {
    public static void main(String[] args) {
        Person p1 = new Person("khushi",21);
        Person p2 = new Person(p1);


        System.out.println(p2.name);
    }
}
