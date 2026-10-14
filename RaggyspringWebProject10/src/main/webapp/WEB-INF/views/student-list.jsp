
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.Student" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Management</title>
</head>
<body>

    <h2>Student Management System</h2>

    <h3>Search Student</h3>

    <form action="/search" method="get">
        <label>Register Number:</label>
        <input type="number" name="regno" required>
        <input type="submit" value="Search">
    </form>

    <br>

    <a href="/">Add New Student</a>

    <h3>Student List</h3>

    <%
        List<Student> students =
            (List<Student>) request.getAttribute("students");
        Boolean searched =
            (Boolean) request.getAttribute("searched");
    %>

    <% if (Boolean.TRUE.equals(searched) && students.isEmpty()) { %>
        <p>No student found with that register number.</p>
    <% } %>

    <table border="1" cellpadding="10">
        <tr>
            <th>Register Number</th>
            <th>Name</th>
            <th>CGPA</th>
            <th>Actions</th>
        </tr>

        <% for (Student student : students) { %>
        <tr>
            <td><%= student.getRegno() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getCgpa() %></td>
            <td>
                <a href="/edit/<%= student.getRegno() %>">
                    Edit
                </a>

                <form action="/delete/<%= student.getRegno() %>"
                      method="post" style="display:inline"
                      onsubmit="return confirm('Delete this student?');">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
    </table>

    <br>
    <a href="/students">View All Students</a>

</body>
</html>
