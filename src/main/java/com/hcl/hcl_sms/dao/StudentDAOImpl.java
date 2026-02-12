package dao;

import model.*;
import util.DBConnection;

import java.sql.*;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void addStudent(Student s) {

        String sql = "INSERT INTO students " +
                "(first_name, last_name, student_type, joining_date, fees, hours) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

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
            System.out.println("✅ Student added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeStudent(int id) {
        executeUpdate("DELETE FROM students WHERE id=" + id);
    }

    @Override
    public void viewStudent(int id) {
        executeQuery("SELECT * FROM students WHERE id=" + id);
    }

    @Override
    public void viewAllStudents() {
        executeQuery("SELECT * FROM students");
    }

    @Override
    public void sortBy(String field) {
        executeQuery("SELECT * FROM students ORDER BY " + field);
    }

    private void executeQuery(String sql) {
        try (Connection con = DBConnection.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\nID | First Name | Last Name | Type | DOJ");
            System.out.println("-------------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("first_name") + " | " +
                                rs.getString("last_name") + " | " +
                                rs.getString("student_type") + " | " +
                                rs.getDate("joining_date"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void executeUpdate(String sql) {
        try (Connection con = DBConnection.getConnection();
                Statement st = con.createStatement()) {

            st.executeUpdate(sql);
            System.out.println("✅ Operation successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
