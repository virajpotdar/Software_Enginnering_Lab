<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>
</head>

<body>

<h2>Update Student</h2>

<form action="UpdateStudentServlet" method="post">

    Student ID:
    <input type="number" name="id" required>
    <br><br>

    Name:
    <input type="text" name="name">
    <br><br>

    Email:
    <input type="email" name="email">
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

    <input type="submit" value="Update Student">

</form>

</body>
</html>