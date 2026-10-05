package com.student;
import java.sql.*;
import java.util.*;


public class StudentDAO {

    private String url = "jdbc:mysql://localhost:3306/studentdb";
    private String user = "root";
    private String password = "root";

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    // Add Student
    public boolean addStudent(Student s) {

        String sql = "INSERT INTO students " +
                     "(name,email,phone,course,department,year) " +
                     "VALUES (?,?,?,?,?,?)";

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhone());
            ps.setString(4, s.getCourse());
            ps.setString(5, s.getDepartment());
            ps.setInt(6, s.getYear());

            int result = ps.executeUpdate();

            con.close();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update Student
    public boolean updateStudent(Student s) {

        String sql = "UPDATE students SET name=?, email=?, phone=?, " +
                     "course=?, department=?, year=? WHERE id=?";

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhone());
            ps.setString(4, s.getCourse());
            ps.setString(5, s.getDepartment());
            ps.setInt(6, s.getYear());
            ps.setInt(7, s.getId());

            int result = ps.executeUpdate();

            con.close();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete Student
    public boolean deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id=?";

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            con.close();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Search Student
    public List<Student> searchStudent(String name) {

        List<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM students WHERE name LIKE ?";

        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Student s = new Student();

                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setCourse(rs.getString("course"));
                s.setDepartment(rs.getString("department"));
                s.setYear(rs.getInt("year"));

                list.add(s);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}