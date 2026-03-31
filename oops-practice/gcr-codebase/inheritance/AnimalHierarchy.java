class Animal {
    String name ;
    int age ;
    
    public void makeSound(){
        System.out.println("Animal Sound !");
    }
}

class Dog extends Animal{
    public void makeSound(){
        System.out.println("Bhaw Bhaw !");
    }
}

class Cat extends Animal{
    public void makeSound(){
        System.out.println("Meow Meow !");
    }
}

class Bird extends Animal{
    public void makeSound(){
        System.out.println("Peko Peko !");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();
        Dog dog = new Dog();
        dog.makeSound();
        Cat cat = new Cat();
        cat.makeSound();
        Bird bird = new Bird();
        bird.makeSound();

        Animal obj = new Dog();// it can be Cat() or Bird() (It is the concept of Method OverRiding)
        obj.makeSound();
    }
}