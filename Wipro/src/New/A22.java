package New;
interface Drawable {
    void drawingColor();
    void thickness();
}

interface Fillable {
    void fillingColor();
    void size();
}

class Line implements Drawable, Fillable {
    public void drawingColor() {
        System.out.println("Line drawing color is black.");
    }

    public void thickness() {
        System.out.println("Line thickness is 1px.");
    }

    public void fillingColor() {
        System.out.println("Line has no filling color.");
    }

    public void size() {
        System.out.println("Line length is 100 units.");
    }
}

class Circle implements Drawable, Fillable {
    public void drawingColor() {
        System.out.println("Circle drawing color is blue.");
    }

    public void thickness() {
        System.out.println("Circle thickness is 2px.");
    }

    public void fillingColor() {
        System.out.println("Circle filling color is yellow.");
    }

    public void size() {
        System.out.println("Circle radius is 50 units.");
    }
}

class Square implements Drawable, Fillable {
    public void drawingColor() {
        System.out.println("Square drawing color is red.");
    }

    public void thickness() {
        System.out.println("Square thickness is 3px.");
    }

    public void fillingColor() {
        System.out.println("Square filling color is green.");
    }

    public void size() {
        System.out.println("Square size is 40x40 units.");
    }
}

public class A22 {
    public static void main(String[] args) {
        Line line = new Line();
        Circle circle = new Circle();
        Square square = new Square();

        System.out.println("Line:");
        line.drawingColor();
        line.thickness();
        line.fillingColor();
        line.size();

        System.out.println("\nCircle:");
        circle.drawingColor();
        circle.thickness();
        circle.fillingColor();
        circle.size();

        System.out.println("\nSquare:");
        square.drawingColor();
        square.thickness();
        square.fillingColor();
        square.size();
    }
}
/*
Line:
Line drawing color is black.
Line thickness is 1px.
Line has no filling color.
Line length is 100 units.

Circle:
Circle drawing color is blue.
Circle thickness is 2px.
Circle filling color is yellow.
Circle radius is 50 units.

Square:
Square drawing color is red.
Square thickness is 3px.
Square filling color is green.
Square size is 40x40 units.
*/