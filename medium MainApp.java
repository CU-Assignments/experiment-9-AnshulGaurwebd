package com.example.hibernate;

public class MainApp {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // Create
        Student s1 = new Student("Anshul", 21);
        dao.createStudent(s1);

        // Read
        Student fetched = dao.readStudent(s1.getId());
        System.out.println("Fetched: " + fetched);

        // Update
        dao.updateStudent(s1.getId(), "Anshul Sharma", 22);
        System.out.println("Updated: " + dao.readStudent(s1.getId()));

        // Delete
        dao.deleteStudent(s1.getId());
        System.out.println("Deleted: " + dao.readStudent(s1.getId()));

        dao.close();
    }
}
