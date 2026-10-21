<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h2>User Registration Form</h2>
    <form action="result.jsp" method="post">
        <label>Name:</label>
        <input type="text" name="name" required>
        <br><br>
        <label>Email:</label>
        <input type="email" name="email" required>
        <br><br>
        <label>Phone Number:</label>
        <input type="tel" name="phone" pattern="[0-9]{10}" required>
        <br><br>
        <label>Password:</label>
        <input type="password" name="password" required>
        <br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>