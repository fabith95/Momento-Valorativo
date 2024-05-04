package com.co.poli.momentovalorativo.servlet;

import com.co.poli.momentovalorativo.database.ConexionMySql;
import com.co.poli.momentovalorativo.model.Courses;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "courseServlet", value = "/courses")
public class CourseServlet extends HttpServlet {
    private ConexionMySql con;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        try {
            if(request.getParameter("id") == null) {
                ArrayList<Courses> listCourse = (ArrayList<Courses>) con.getCourse();
                PrintWriter out = response.getWriter();
                //out.print(gson.toJson(listCourse));
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
