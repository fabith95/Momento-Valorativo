package com.co.poli.momentovalorativo.database;

import com.co.poli.momentovalorativo.model.Courses;
import com.co.poli.momentovalorativo.model.Students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexionMySql {

    private String user;
    private String password;
    private int port;
    private String host;
    private String nameDatabase;
    private Connection con;

    public ConexionMySql(){
        this.user = "root";
        password = "";
        port = 3306;
        host = "localhost";
        nameDatabase = "ces3-exam";
    }
    //crear conection
    private void createConection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://" +host+":"+port+"/"+nameDatabase, user, password
            );
            System.out.println("Successful connection");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("An error occurred during the connection");
            throw new RuntimeException(e);
        }
    }

    public List<Students> getStudents() throws SQLException {
        String sql = "SELECT * FROM students";
        String[] nameColumns = {"id", "name", "lastName", "age", "password", "createdAt", "updatedAt", "deletedAt"};
        List<Students> list = new ArrayList<>();
        try {
            createConection();
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while(result.next()){
                list.add(new Students(result.getInt(1), result.getString("name"), result.getString("lastName"), result.getInt(25)));
            }
            stmt.close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            con.close();
        }
    }

    public List<Students> getStudentInsert() throws SQLException {
        List<Students> list = new ArrayList<>();
        try {
            createConection();
            String sqlStudents = "INSERT INTO alumnos (name, lastName, age, passwordAt, createdAt, updatedAt, deletedAt) VALUES (?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL)";
            PreparedStatement stmt = con.prepareStatement(sqlStudents);
            stmt.setString(1, "Juan");
            stmt.setString(2, "Scrumers");
            stmt.setInt(3, 28);
            stmt.executeUpdate();
            stmt.close();

            System.out.println("Records inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }finally {
            con.close();
        }
        return list;
    }

    public List<Courses> getCourse() throws SQLException {
        String sql = "SELECT * FROM courses";
        String[] nameColumns = {"id", "name_course", "teacher", "description", "createdAt", "updatedAt", "deletedAt"};
        List<Courses> list = new ArrayList<>();
        try {
            createConection();
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while(result.next()){
                list.add(new Courses(result.getInt(1), result.getString("name_course"), result.getString("teacher"), result.getString("description")));
            }
            stmt.close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            con.close();
        }
    }

    public List<Courses> getCourseInsert() throws SQLException {
        List<Courses> list = new ArrayList<>();
        try {
            createConection();
            String sqlCourses = "INSERT INTO courses (name_course, teacher, description, createdAt, updatedAt, deletedAt) VALUES (?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL)";
            PreparedStatement stmt = con.prepareStatement(sqlCourses);
            stmt.setString(1, "Matematicas");
            stmt.setString(2, "MauroDev");
            stmt.setString(3, "More skills in development");
            stmt.close();

            System.out.println("Records inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }finally {
            con.close();
        }
        return list;
    }

    public static void main(String[] args) {
        ConexionMySql conection = new ConexionMySql();
        try {
            conection.getStudents();
            conection.getCourse();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
