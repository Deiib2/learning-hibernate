package com.adham.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("Ryan Gravenberch");
        s1.setRollNo(550001);
        s1.setsAge(22);

        Configuration config = new Configuration();
        config.addAnnotatedClass(com.adham.hibernate.Student.class);
        config.configure();

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(s1);
        transaction.commit();

        System.out.println(s1);
    }
}
