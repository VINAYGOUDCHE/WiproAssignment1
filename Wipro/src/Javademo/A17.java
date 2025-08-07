package Javademo;
import java.util.Scanner;

class Vehicle {
    String color;
    int wheels;
    String model;

    Vehicle(String color, int wheels, String model) {
        this.color = color;
        this.wheels = wheels;
        this.model = model;
    }

    void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Number of wheels: " + wheels);
    }

    void start() {
        System.out.println("Vehicle is starting");
    }
}

class Truck extends Vehicle {
    Truck(String color, int wheels, String model) {
        super(color, wheels, model);
    }

    void loadGoods() {
        System.out.println("Truck is loading goods");
    }
}

class Bus extends Vehicle {
    Bus(String color, int wheels, String model) {
        super(color, wheels, model);
    }

    void pickPassengers() {
        System.out.println("Bus is picking up passengers");
    }
}

class Car extends Vehicle {
    Car(String color, int wheels, String model) {
        super(color, wheels, model);
    }

    void playMusic() {
        System.out.println("Car is playing music");
    }
}

public class A17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Truck t = new Truck("Blue", 6, "Tata Truck");
        Bus b = new Bus("White", 4, "Volvo Bus");
        Car c = new Car("Red", 4, "Honda City");

        System.out.println("--- Truck Details ---");
        t.displayDetails();
        t.start();
        t.loadGoods();

        System.out.println("\n--- Bus Details ---");
        b.displayDetails();
        b.start();
        b.pickPassengers();

        System.out.println("\n--- Car Details ---");
        c.displayDetails();
        c.start();
        c.playMusic();
        sc.close();
    }
}
/*
--- Truck Details ---
Model: Tata Truck
Color: Blue
Number of wheels: 6
Vehicle is starting
Truck is loading goods

--- Bus Details ---
Model: Volvo Bus
Color: White
Number of wheels: 4
Vehicle is starting
Bus is picking up passengers

--- Car Details ---
Model: Honda City
Color: Red
Number of wheels: 4
Vehicle is starting
Car is playing music
*/
