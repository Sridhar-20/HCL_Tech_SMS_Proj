package com.hcl.hcl_sms.dao;

import com.hcl.hcl_sms.model.*;
import com.hcl.hcl_sms.util.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Override
    public void addStudent(Student s) {

        String sql = "INSERT INTO students(first_name,last_name,student_type,joining_date,fees,hours) VALUES (?,?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setString(3, s.getStudentType());
            ps.setDate(4, s.getJoiningDate());

            if (s instanceof FullTimeStudent) {
                ps.setDouble(5, ((FullTimeStudent) s).getFees());
                ps.setNull(6, Types.INTEGER);
            } else {
                ps.setNull(5, Types.DOUBLE);
                ps.setInt(6, ((PartTimeStudent) s).getHours());
            }

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return getAllStudentsSorted("id");
    }

    @Override
    public List<Student> getAllStudentsSorted(String field) {

        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY " + field;

        try (Connection con = DBConnection.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Date joiningDate = rs.getDate("joining_date");
                String type = rs.getString("student_type");

                Student student;

                if ("FULL_TIME".equals(type)) {
                    student = new FullTimeStudent(firstName, lastName, joiningDate, rs.getDouble("fees"));
                } else {
                    student = new PartTimeStudent(firstName, lastName, joiningDate, rs.getInt("hours"));
                }

                student.setId(id);
                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public Student getStudentById(int id) {

        String sql = "SELECT * FROM students WHERE id=?";
        Student student = null;

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Date joiningDate = rs.getDate("joining_date");
                String type = rs.getString("student_type");

                if ("FULL_TIME".equals(type)) {
                    student = new FullTimeStudent(firstName, lastName, joiningDate, rs.getDouble("fees"));
                } else {
                    student = new PartTimeStudent(firstName, lastName, joiningDate, rs.getInt("hours"));
                }

                student.setId(rs.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public void removeStudent(int id) {

        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
