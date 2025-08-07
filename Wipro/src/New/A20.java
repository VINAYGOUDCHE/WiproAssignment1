package New;
abstract class Vehicle {
    abstract void startEngine();
    abstract void stopEngine();
}

class Car extends Vehicle {
    void startEngine() {
        System.out.println("Car engine started");
    }

    void stopEngine() {
        System.out.println("Car engine stopped.");
    }
}

class Motorcycle extends Vehicle {
    void startEngine() {
        System.out.println("Motorcycle engine started");
    }

    void stopEngine() {
        System.out.println("Motorcycle engine stopped.");
    }
}

public class A20 {
    public static void main(String[] args) {
        Car car = new Car();
        Motorcycle bike = new Motorcycle();

        System.out.println("------ Car Actions ------");
        car.startEngine();
        car.stopEngine();

        System.out.println("\n------ Motorcycle Actions ------");
        bike.startEngine();
        bike.stopEngine();
    }
}
/*
------ Car Actions ------
Car engine started
Car engine stopped.

------ Motorcycle Actions ------
Motorcycle engine started
Motorcycle engine stopped.
*/