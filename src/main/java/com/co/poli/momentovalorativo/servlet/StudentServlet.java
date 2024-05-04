package com.co.poli.momentovalorativo.servlet;

import com.co.poli.momentovalorativo.database.ConexionMySql;
import com.co.poli.momentovalorativo.model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "studentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private ConexionMySql con;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        try {
            if(request.getParameter("id") == null) {
                ArrayList<Student> listStudent = (ArrayList<Student>) con.getStudent();
                PrintWriter out = response.getWriter();
                //out.print(gson.toJson(listStudent));
                out.flush();
            }else{

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void destroy() {
    }
}