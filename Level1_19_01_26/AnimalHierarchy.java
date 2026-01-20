package Level1_19_01_26;
class Animal {
    String name;
    int age;    
    void makeSound(){};
}
class Dog extends Animal {
    @Override
    void makeSound(){
        System.out.println("Bark");
    };
}
class Cat extends Animal {
    @Override
    void makeSound(){
        System.out.println("Meow");
    };
}
class Bird extends Animal{
    @Override
    void makeSound(){
        System.out.println("Chirp");
    };
}
class AnimalHierarchy {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Bird bird = new Bird();
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}