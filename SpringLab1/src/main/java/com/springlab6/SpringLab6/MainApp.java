package com.springlab6.SpringLab6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonDao dao = context.getBean(PersonDao.class);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many persons to save? ");
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for person #" + (i + 1));
            System.out.print("ID: "); int id = sc.nextInt();
            System.out.print("First Name: "); String fname = sc.next();
            System.out.print("Last Name: "); String lname = sc.next();
            System.out.print("Age: "); int age = sc.nextInt();

            dao.save(new Person(id, fname, lname, age));
        }

        System.out.println("\n✅ Saved Records:");
        dao.getAll().forEach(System.out::println);

        System.out.print("\n🔄 Enter ID to update: ");
        int updateId = sc.nextInt();
        System.out.print("New First Name: "); String newFname = sc.next();
        System.out.print("New Last Name: "); String newLname = sc.next();
        System.out.print("New Age: "); int newAge = sc.nextInt();
        dao.update(new Person(updateId, newFname, newLname, newAge));
        System.out.println("Updated Record:");
        System.out.println(dao.getById(updateId));

        System.out.print("\n🗑️ Enter ID to delete: ");
        int deleteId = sc.nextInt();
        dao.delete(deleteId);
        System.out.println("Remaining Records:");
        dao.getAll().forEach(System.out::println);

        System.out.print("\n🔍 Enter ID to fetch: ");
        int fetchId = sc.nextInt();
        System.out.println("Record:");
        System.out.println(dao.getById(fetchId));

        sc.close();
    }
}