package com.studentservlet;

import java.io.IOException;

import com.student.StudentDAO;
import com.student.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AddStudentServlet")
public class AddStudent extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String course = request.getParameter("course");
        String department = request.getParameter("department");
        int year = Integer.parseInt(request.getParameter("year"));

        Student s = new Student(
                name,
                email,
                phone,
                course,
                department,
                year
        );

        StudentDAO dao = new StudentDAO();

        if (dao.addStudent(s)) {
            response.sendRedirect("students.jsp");
        } else {
            response.getWriter().println("Student Not Added");
        }
    }
}