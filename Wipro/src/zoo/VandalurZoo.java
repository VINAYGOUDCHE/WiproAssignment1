package zoo;

import org.animals.*;

public class VandalurZoo {
    public static void main(String[] args) {
        Lion lion = new Lion();
        Tiger tiger = new Tiger();
        Deer deer = new Deer();
        Monkey monkey = new Monkey();
        Elephant elephant = new Elephant();
        Giraffe giraffe = new Giraffe();

        System.out.println("Lion:");
        System.out.println("Color: " + lion.color);
        System.out.println("Weight: " + lion.weight);
        System.out.println("Age: " + lion.age);
        System.out.println("Is Vegetarian? " + lion.isVegetarian());
        System.out.println("Can Climb? " + lion.canClimb());
        System.out.println("Sound: " + lion.sound());

        System.out.println("\nTiger:");
        System.out.println("Color: " + tiger.color);
        System.out.println("Weight: " + tiger.weight);
        System.out.println("Age: " + tiger.age);
        System.out.println("Is Vegetarian? " + tiger.isVegetarian());
        System.out.println("Can Climb? " + tiger.canClimb());
        System.out.println("Sound: " + tiger.sound());

        System.out.println("\nDeer:");
        System.out.println("Color: " + deer.color);
        System.out.println("Weight: " + deer.weight);
        System.out.println("Age: " + deer.age);
        System.out.println("Is Vegetarian? " + deer.isVegetarian());
        System.out.println("Can Climb? " + deer.canClimb());
        System.out.println("Sound: " + deer.sound());

        System.out.println("\nMonkey:");
        System.out.println("Color: " + monkey.color);
        System.out.println("Weight: " + monkey.weight);
        System.out.println("Age: " + monkey.age);
        System.out.println("Is Vegetarian? " + monkey.isVegetarian());
        System.out.println("Can Climb? " + monkey.canClimb());
        System.out.println("Sound: " + monkey.sound());

        System.out.println("\nElephant:");
        System.out.println("Color: " + elephant.color);
        System.out.println("Weight: " + elephant.weight);
        System.out.println("Age: " + elephant.age);
        System.out.println("Is Vegetarian? " + elephant.isVegetarian());
        System.out.println("Can Climb? " + elephant.canClimb());
        System.out.println("Sound: " + elephant.sound());

        System.out.println("\nGiraffe:");
        System.out.println("Color: " + giraffe.color);
        System.out.println("Weight: " + giraffe.weight);
        System.out.println("Age: " + giraffe.age);
        System.out.println("Is Vegetarian? " + giraffe.isVegetarian());
        System.out.println("Can Climb? " + giraffe.canClimb());
        System.out.println("Sound: " + giraffe.sound());
    }
}
