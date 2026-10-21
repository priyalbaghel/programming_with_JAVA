<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String message = "";
    String action = request.getParameter("action");

    String url = "jdbc:mysql://localhost:3306/crud30";
    String dbUser = "root";
    String dbPassword = "yourPassword";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        if ("add".equalsIgnoreCase(action)) {
            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO patient VALUES (?, ?, ?, ?, ?)")) {
                
                ps.setInt(1, Integer.parseInt(request.getParameter("patient_id")));
                ps.setString(2, request.getParameter("name"));
                ps.setInt(3, Integer.parseInt(request.getParameter("age")));
                ps.setString(4, request.getParameter("disease"));
                ps.setString(5, request.getParameter("treatment_status"));

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    message = "Patient added successfully.";
                }
            }
        } else if ("update".equalsIgnoreCase(action)) {
            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 PreparedStatement ps = con.prepareStatement(
                     "UPDATE patient SET name = ?, age = ?, disease = ?, treatment_status = ? WHERE patient_id = ?")) {
                
                ps.setString(1, request.getParameter("name"));
                ps.setInt(2, Integer.parseInt(request.getParameter("age")));
                ps.setString(3, request.getParameter("disease"));
                ps.setString(4, request.getParameter("treatment_status"));
                ps.setInt(5, Integer.parseInt(request.getParameter("patient_id")));

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    message = "Patient updated successfully.";
                } else {
                    message = "Patient ID not found.";
                }
            }
        } else if ("delete".equalsIgnoreCase(action)) {
            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 PreparedStatement ps = con.prepareStatement(
                     "DELETE FROM patient WHERE patient_id = ?")) {
                
                ps.setInt(1, Integer.parseInt(request.getParameter("patient_id")));

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    message = "Patient deleted successfully.";
                } else {
                    message = "Patient ID not found.";
                }
            }
        }
    } catch (Exception e) {
        message = "Error: " + e.getMessage();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Patient Management</title>
</head>
<body>
    <h2>Patient Management System</h2>
    <p><%= message %></p>

    <!-- Add Patient -->
    <h3>Add Patient</h3>
    <form method="post" action="patient.jsp">
        <input type="hidden" name="action" value="add">
        Patient ID:
        <input type="number" name="patient_id" required><br><br>
        Name:
        <input type="text" name="name" required><br><br>
        Age:
        <input type="number" name="age" min="0" required><br><br>
        Disease:
        <input type="text" name="disease" required><br><br>
        Treatment Status:
        <select name="treatment_status" required>
            <option value="Under Treatment">Under Treatment</option>
            <option value="Recovered">Recovered</option>
            <option value="Discharged">Discharged</option>
        </select><br><br>
        <input type="submit" value="Add Patient">
    </form>
    <hr>

    <!-- Update Patient -->
    <h3>Update Patient</h3>
    <form method="post" action="patient.jsp">
        <input type="hidden" name="action" value="update">
        Patient ID:
        <input type="number" name="patient_id" required><br><br>
        New Name:
        <input type="text" name="name" required><br><br>
        New Age:
        <input type="number" name="age" min="0" required><br><br>
        New Disease:
        <input type="text" name="disease" required><br><br>
        New Treatment Status:
        <select name="treatment_status" required>
            <option value="Under Treatment">Under Treatment</option>
            <option value="Recovered">Recovered</option>
            <option value="Discharged">Discharged</option>
        </select><br><br>
        <input type="submit" value="Update Patient">
    </form>
    <hr>

    <!-- Delete Patient -->
    <h3>Delete Patient</h3>
    <form method="post" action="patient.jsp">
        <input type="hidden" name="action" value="delete">
        Patient ID:
        <input type="number" name="patient_id" required><br><br>
        <input type="submit" value="Delete Patient">
    </form>
    <hr>

    <!-- Patient Records -->
    <h3>Patient Records</h3>
    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Disease</th>
            <th>Treatment Status</th>
        </tr>
        <%
            try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM patient ORDER BY patient_id")) {
                
                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("patient_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("age") %></td>
            <td><%= rs.getString("disease") %></td>
            <td><%= rs.getString("treatment_status") %></td>
        </tr>
        <%
                }
            } catch (Exception e) {
        %>
        <tr>
            <td colspan="5">Unable to load patients: <%= e.getMessage() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
