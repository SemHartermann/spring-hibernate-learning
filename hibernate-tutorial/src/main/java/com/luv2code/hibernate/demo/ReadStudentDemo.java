package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {


            System.out.println("Create new Student object ...");

            Student tempStudent = new Student("Lufy", "Luck", "lufy@gmail.com");

            session.beginTransaction();

            System.out.println("Saving the student");
            session.save(tempStudent);

            session.getTransaction().commit();

            System.out.println("Done!");

            // find out the student's id: primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            // get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Get complete: " + myStudent);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Doone!");

        } finally {
            session.close();
            factory.close();
        }

    }

}
