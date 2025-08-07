package New;
abstract class Person {
    abstract void eat();
    abstract void exercise();
}

class Athlete extends Person {
    void eat() {
        System.out.println("Athlete eats a balanced diet");
    }

    void exercise() {
        System.out.println("Athlete exercises");
    }
}

class LazyPerson extends Person {
    void eat() {
        System.out.println("Lazy person eats junk food");
    }

    void exercise() {
        System.out.println("Lazy person avoids exercise");
    }
}

public class A21 {
    public static void main(String[] args) {
        Athlete athlete = new Athlete();
        LazyPerson lazy = new LazyPerson();

        System.out.println("-- Athlete --");
        athlete.eat();
        athlete.exercise();

        System.out.println("\n-- Lazy Person --");
        lazy.eat();
        lazy.exercise();
    }
}
/*
-- Athlete --
Athlete eats a balanced diet
Athlete exercises

-- Lazy Person --
Lazy person eats junk food
Lazy person avoids exercise
*/
