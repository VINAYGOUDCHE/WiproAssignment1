package New;

public class Tank {
    boolean released = false;

    void fill() {
        System.out.println("Tank filled");
    }

    void empty() {
        System.out.println("Tank emptied");
    }

    void releaseTank() {
        released = true;
        System.out.println("Tank released");
    }

    @Override
    protected void finalize() throws Throwable {
        if (!released) {
            System.out.println("Error: Tank not released before cleanup!");
        } else {
            System.out.println("Tank cleanup verified.");
        }
        super.finalize();
    }

    public static void main(String[] args) {
        Tank t1 = new Tank();
        t1.fill();
        t1.empty();
        t1.releaseTank();
        t1 = null;

        Tank t2 = new Tank();
        t2.fill();
        t2.empty();
        // t2.releaseTank();  // Not released
        t2 = null;

        System.gc();
    }
}
