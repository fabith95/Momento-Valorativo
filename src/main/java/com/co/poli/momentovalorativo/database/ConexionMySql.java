package com.co.poli.momentovalorativo.database;

import com.co.poli.momentovalorativo.model.Student;

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
        nameDatabase = "ces3-universitas";
    }
    //crear conetion
    private void createConexion(){
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

    public List<Student> getStudent() throws SQLException {
        String sql = "SELECT * FROM student";
        String[] nameColumns = {"id", "name", "lastName", "age", "password", "createdAt", "updatedAt", "deletedAt"};
        List<Student> list = new ArrayList<>();
        try {
            createConexion();
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while(result.next()){
                list.add(new Student(result.getString("name"), result.getString("lastName")));
            }
            stmt.close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            con.close();
        }
    }

    public static void main(String[] args) {
        ConexionMySql conection = new ConexionMySql();
        try {
            conection.getStudent();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
