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

        Alien a1 = new Alien();
        a1.setAlien_id(13);
        a1.setName("Slim");
        a1.setTech("Java");
        a1.setLaptops(List.of(l1,l2));


        l1.setAlien(a1);
        l2.setAlien(a1);

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
        session.persist(a1);

        //session.remove(109);

        transaction.commit();

//        Student s2 = session.byId(Student.class).load(20007);
        Alien a2 = session.byId(Alien.class).load(13);

        System.out.println(a2);

        session.close();
        sf.close();

    }
}
