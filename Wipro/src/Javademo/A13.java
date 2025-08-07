package Javademo;
import java.util.Scanner;

class Worker {
    protected String name;
    protected double salaryRate;

    public Worker(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }

    public double pay(int hours) {
        return 0.0;
    }

    public void showPay(int hours) {
        System.out.println("Worker Name: " + name);
        System.out.println("Weekly Pay: ₹" + pay(hours));
    }
}

class DailyWorker extends Worker {
    public DailyWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    public double pay(int hours) {
        return salaryRate * hours;
    }
}

class SalariedWorker extends Worker {
    public SalariedWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    public double pay(int hours) {
        return salaryRate * 40;
    }
}

public class A13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name of Daily Worker: ");
        String dName = sc.nextLine();
        System.out.print("Enter salary rate (₹/hour): ");
        double dRate = sc.nextDouble();
        System.out.print("Enter hours worked this week: ");
        int dHours = sc.nextInt();

        sc.nextLine();
        System.out.print("\nEnter name of Salaried Worker: ");
        String sName = sc.nextLine();
        System.out.print("Enter salary rate (₹/hour): ");
        double sRate = sc.nextDouble();
        System.out.print("Enter hours worked this week (ignored): ");
        int sHours = sc.nextInt();

        DailyWorker dw = new DailyWorker(dName, dRate);
        SalariedWorker sw = new SalariedWorker(sName, sRate);

        System.out.println("\n--- Daily Worker Pay ---");
        dw.showPay(dHours);

        System.out.println("\n--- Salaried Worker Pay ---");
        sw.showPay(sHours);

        sc.close();
    }
}
/*
Enter name of Daily Worker: Nithin
Enter salary rate (₹/hour): 300
Enter hours worked this week: 42

Enter name of Salaried Worker: Naveen
Enter salary rate (₹/hour): 500
Enter hours worked this week (ignored): 21

--- Daily Worker Pay ---
Worker Name: Nithin
Weekly Pay: ₹12600.0

--- Salaried Worker Pay ---
Worker Name: Naveen
Weekly Pay: ₹20000.0
*/
