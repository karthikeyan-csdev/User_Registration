<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="Styles.css">
</head>
<body>
    <div class="container">
        <h2>Sign Up</h2>
        <form action="signup" method="post">
            <div class="input-group">
                <label for="username">UserName</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="input-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="btn">Sign Up</button>
        </form>
        <p>Already have an account? <a href="Login.jsp">Login</a></p>
    </div>
</body>
</html>


