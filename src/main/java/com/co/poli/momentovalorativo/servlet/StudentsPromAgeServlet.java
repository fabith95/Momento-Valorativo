package com.co.poli.momentovalorativo.servlet;

import com.co.poli.momentovalorativo.database.ConexionMySql;
import com.co.poli.momentovalorativo.model.Students;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.util.ISO8601Utils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "studentsPromAgeServlet", value = "/GET/students-average-age")
public class StudentsPromAgeServlet extends HttpServlet {
    private ConexionMySql con;
    private GsonBuilder gsonBuilder;
    private Gson gson;

    public void init() {
        con = new ConexionMySql();
        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        try {
            if(request.getParameter("id") == null) {
                ArrayList<Students> listAllStudent = (ArrayList<Students>) con.getStudents();
                int maxAge = 0;
                for (int i = 0; i < listAllStudent.size(); i++) {
                    Students student = listAllStudent.get(i);
                    if (student.getAge() > maxAge) {
                        maxAge = student.getAge();
                    }
                }
                PrintWriter out = response.getWriter();
                System.out.println("la edad mayor es: ");
                out.print(gson.toJson(maxAge));
                out.flush();
            } else {
                // Aquí puedes manejar el caso en el que se proporciona un ID en el parámetro de la solicitud
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void destroy() {
    }
}