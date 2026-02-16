package com.hcl.hcl_sms.dao;

import com.hcl.hcl_sms.model.Student;
import java.util.List;

public interface StudentDAO {

    void addStudent(Student student);

    List<Student> getAllStudents();

    List<Student> getAllStudentsSorted(String field);

    Student getStudentById(int id);

    void removeStudent(int id);
}
