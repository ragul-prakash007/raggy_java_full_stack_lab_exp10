
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.Student" %>

<%
    Student student = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
</head>
<body>

    <h2>Update Student Details</h2>

    <form action="/updateStudent" method="post">

        <label>Register Number:</label>
        <input type="number" name="regno"
               value="<%= student.getRegno() %>" readonly>
        <br><br>

        <label>Name:</label>
        <input type="text" name="name"
               value="<%= student.getName() %>" required>
        <br><br>

        <label>CGPA:</label>
        <input type="number" name="cgpa"
               value="<%= student.getCgpa() %>"
               min="0" max="10" step="any" required>
        <br><br>

        <input type="submit" value="Update Student">

    </form>

    <br>
    <a href="/students">Back to Student List</a>

</body>
</html>
