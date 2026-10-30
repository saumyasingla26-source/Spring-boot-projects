package com.demo;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/students")
public class StudentServlet extends HttpServlet {


    private final List<Student> students = new ArrayList<>();


    @Override
    public void init() {
        students.add(new Student(101, "Rahul Sharma", "B.Tech CSE"));
        students.add(new Student(102, "Priya Verma", "B.Tech IT"));
        students.add(new Student(103, "Amit Singh", "BCA"));
        students.add(new Student(104, "Neha Gupta", "MCA"));
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        String rollParam = req.getParameter("roll");
        Student selected = null;


        if (rollParam != null) {
            int roll = Integer.parseInt(rollParam);
            for (Student s : students) {
                if (s.getRollNo() == roll) {
                    selected = s;
                }
            }
        }


        req.setAttribute("students", students);
        req.setAttribute("selected", selected);


        req.getRequestDispatcher("/students.jsp").forward(req, resp);
    }
}