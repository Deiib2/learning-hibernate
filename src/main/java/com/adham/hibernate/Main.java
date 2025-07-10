package com.adham.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("Coih");
        s1.setRollNo(1);
        s1.setsAge(25);

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("ASUS");
        l1.setModel("TUF F1");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("HP");
        l2.setModel("25");
        l2.setRam(12);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook A1");
        l3.setRam(12);

        Alien a1 = new Alien();
        a1.setAlien_id(101);
        a1.setName("Slim");
        a1.setTech("Python");

        Alien a2 = new Alien();
        a2.setAlien_id(102);
        a2.setName("Adham");
        a2.setTech("Java");

        /*Alien a3 = new Alien();
        a3.setAlien_id(103);
        a3.setName("Omar");
        a3.setTech("Fast API");*/

        a1.setLaptops(List.of(l1,l2));
        a2.setLaptops(List.of(l3));

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.adham.hibernate.Student.class)
                .addAnnotatedClass(com.adham.hibernate.Alien.class)
                .addAnnotatedClass(com.adham.hibernate.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        //session.merge(s1);
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);

        //session.remove(109);

        transaction.commit();

//        Student s2 = session.byId(Student.class).load(20007);


        session.close();

        Session session1 = sf.openSession();

        Alien a5 = session1.byId(Alien.class).load(102);

        session1.close();
        sf.close();

    }
}
