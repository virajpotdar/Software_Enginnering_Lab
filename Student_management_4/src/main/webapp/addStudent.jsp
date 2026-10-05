<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
</head>

<body>

<h2>Add Student</h2>

<form action="AddStudent" method="post">

    Name:
    <input type="text" name="name" required>
    <br><br>

    Email:
    <input type="email" name="email" required>
    <br><br>

    Phone:
    <input type="text" name="phone">
    <br><br>

    Course:
    <input type="text" name="course">
    <br><br>

    Department:
    <input type="text" name="department">
    <br><br>

    Year:
    <input type="number" name="year">
    <br><br>

    <input type="submit" value="Add Student">

</form>

<br>

<a href="students.jsp">View Students</a>

</body>
</html>