
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
</head>
<body>
    <h2>Student Registration Form</h2>

    <form action="/saveStudent" method="post">
        <label>Student Regno:</label>
        <input type="number" name="regno" required>
        <br><br>

        <label>Name:</label>
        <input type="text" name="name" required>
        <br><br>

        <label>CGPA:</label>
        <input type="number" name="cgpa"
               min="0" max="10" step="any" required>
        <br><br>

        <input type="submit" value="Submit">
    </form>

    <br>
    <a href="/students">View All Students</a>
</body>
</html>
