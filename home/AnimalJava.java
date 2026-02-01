interface AnimalBehavior {
    void makeSound(); // abstract class must implement

    default void sleep() { // default method of this class
        System.out.println("Animal is sleeping");
    }
}

interface Movable {
    void move();

    default void stop() {
        System.out.println("Movement stopped");
    }
}

abstract class Animal {
    protected String name; // general properties

    public Animal(String name) {
        this.name = name;
    }

    // details method (has implementation)
    public void eat() {
        System.out.println(name + " is eating");
    }

    // Override abstract class (must override in subclass)
    public abstract void makeSound();

    public abstract void move();
}

class Dogs extends Animal implements AnimalBehavior {

    public Dogs(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }

    @Override
    public void move() {
        System.out.println(name + " is walking");
    }
}

class Cat implements AnimalBehavior {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow");
    }
}

class Bird extends Animal implements AnimalBehavior, Movable {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Chirp!");
    }

    @Override
    public void move() {
        System.out.println("Flying High!");
    }
}

public class AnimalJava {
    public static void main(String[] args) {
        // Using abstract class: Dog inheritance Animal and implement AnimalBehavior
        Animal dog = new Dogs("Dollar");
        dog.eat(); // From abstract class
        dog.makeSound(); // Override from abstract class and interface
        ((AnimalBehavior) dog).sleep();

        System.out.println();

        // Using interface: Cat but only implement AnimalBehavior
        AnimalBehavior cat = new Cat("Happy");
        cat.makeSound(); // from interface
        cat.sleep(); // default method from interface

        Animal bird = new Bird("Tweety");
        bird.eat();
        bird.makeSound();
        bird.move();
        ((Movable) bird).stop();
    }
}