<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style-login.css">
    <title>Login</title>
</head>
<body>
    <div class="left-page">
        <form action="#">
            <h1>Login</h1>
    
            <div class="email-field">               
                <input type="email" name="email" id="email" class="email" autocomplete="off" placeholder="Email" >
            </div>
    
            <div class="password-field">
                <input type="password" name="password" id="password" class="password" autocomplete="off" placeholder="Password">
            </div>
            <a>Password Dimenticata?</a>
            <input type="submit" value="Accedi!">

           
        </form>
        <div class="buttons">
            <a class="access">Login</a>
            <a href="register.jsp" class="access">Register</a>
        </div>
    </div>

    <div class="right-page">
        <nav>
            <img src="images/home-icon.png" alt="home-icon" class="home-icon">
        </nav>
    </div>
</body>
</html>