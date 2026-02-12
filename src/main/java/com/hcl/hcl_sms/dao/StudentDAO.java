package dao;

import model.Student;

public interface StudentDAO {
    void addStudent(Student student);

    void removeStudent(int id);

    void viewStudent(int id);

    void viewAllStudents();

    void sortBy(String field);
}
