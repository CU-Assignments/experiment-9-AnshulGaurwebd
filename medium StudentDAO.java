package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDAO {

    private final SessionFactory factory;

    public StudentDAO() {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public void createStudent(Student student) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

    public Student readStudent(int id) {
        try (Session session = factory.openSession()) {
            return session.get(Student.class, id);
        }
    }

    public void updateStudent(int id, String newName, int newAge) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                student.setName(newName);
                student.setAge(newAge);
                session.update(student);
            }
            session.getTransaction().commit();
        }
    }

    public void deleteStudent(int id) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
            }
            session.getTransaction().commit();
        }
    }

    public void close() {
        factory.close();
    }
}

