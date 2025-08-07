package New;
public class Emp {

    private int id;
    private String name;
    private String desig;
    private double basic;
    private final double hra;

    public Emp(int id, String name, String desig, double basic) throws LowSal {
        if (basic < 50000) {
            throw new LowSal("Basic salary must be >= 50000.");
        }

        this.id = id;
        this.name = name;
        this.desig = desig;
        this.basic = basic;
        this.hra = calcHRA();
    }

    private double calcHRA() {
        switch (desig.toLowerCase()) {
            case "manager": return basic * 0.10;
            case "teamleader": return basic * 0.12;
            case "hr": return basic * 0.05;
            default: return 0;
        }
    }

    public void printDet() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Desig: " + desig);
        System.out.println("Basic: " + basic);
        System.out.println("HRA: " + hra);
    }
}
