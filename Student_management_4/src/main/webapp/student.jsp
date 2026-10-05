<%@ page import="java.util.List" %>
<%@ page import="com.student.StudentDAO" %>
<%@ page import="com.student.Student" %>

<!DOCTYPE html>
<html>

<head>
    <title>Student Management</title>
</head>

<body>

<h2>Student Management System</h2>

<form action="students.jsp" method="get">

    Search Student:

    <input type="text" name="search">

    <input type="submit" value="Search">

</form>

<br>

<a href="addStudent.jsp">Add Student</a>

&nbsp;&nbsp;

<a href="updateStudent.jsp">Update Student</a>

<br><br>

<table border="1" cellpadding="10">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Course</th>
    <th>Department</th>
    <th>Year</th>
    <th>Delete</th>
</tr>

<%

String search = request.getParameter("search");

if (search == null) {
    search = "";
}

StudentDAO dao = new StudentDAO();

List<Student> list = dao.searchStudent(search);

for (Student s : list) {

%>

<tr>

<td><%= s.getId() %></td>

<td><%= s.getName() %></td>

<td><%= s.getEmail() %></td>

<td><%= s.getPhone() %></td>

<td><%= s.getCourse() %></td>

<td><%= s.getDepartment() %></td>

<td><%= s.getYear() %></td>

<td>
<a href="DeleteStudent?id=<%=s.getId()%>">
Delete
</a>
</td>

</tr>

<%
}
%>

</table>

</body>
</html>