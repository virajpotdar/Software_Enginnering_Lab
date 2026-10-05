package com.studentservlet;
import java.io.IOException;
import java.util.List;

import com.student.StudentDAO;
import com.student.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        StudentDAO dao = new StudentDAO();

        List<Student> list = dao.searchStudent(name);

        request.setAttribute("students", list);

        request.getRequestDispatcher("students.jsp")
               .forward(request, response);
    }
}