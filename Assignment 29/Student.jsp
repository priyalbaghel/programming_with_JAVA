<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
</head>
<body>
    <h2>Student Information Form</h2>
    <form method="post" action="student.jsp">
        <label>Roll Number:</label>
        <input type="text" name="rollNo" required>
        <br><br>
        <label>Student Name:</label>
        <input type="text" name="studentName" required>
        <br><br>
        <label>Course:</label>
        <input type="text" name="course" required>
        <br><br>
        <label>Marks:</label>
        <input type="number" name="marks" min="0" max="100" required>
        <br><br>
        <input type="submit" value="Display Details">
    </form>
    <%
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String rollNo = request.getParameter("rollNo");
            String studentName = request.getParameter("studentName");
            String course = request.getParameter("course");
            String marks = request.getParameter("marks");
    %>
    <h2>Student Details</h2>
    <p>Roll Number: <%= rollNo %></p>
    <p>Student Name: <%= studentName %></p>
    <p>Course: <%= course %></p>
    <p>Marks: <%= marks %></p>
    <%
        }
    %>
</body>
</html>