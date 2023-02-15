<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style-register.css">
    <title>Register</title>
</head>
<body>
    <div class="left-page">
        <form action="gestAccount?cmd=register" method="post">
            <h1>Register</h1>
            
             <div class="nome-field">               
                <input type="text" name="nome" id="nome" class="nome" autocomplete="off" placeholder="Nome" >
            </div>
            
            
            <div class="cognome-field">               
                <input type="text" name="cognome" id="cognome" class="cognome" autocomplete="off" placeholder="Cognome" >
            </div>

            <div class="email-field">               
                <input type="email" name="email" id="email" class="email" autocomplete="off" placeholder="Email" >
            </div>
    
            <div class="password-field">
                    <input type="password" name="password" id="password" class="password" autocomplete="off" placeholder="Password">
            </div>
            
            <div class="password-field">
                    <input type="password" name="conf_pwd" id="password" class="password" autocomplete="off" placeholder="Conferma Password">
            </div>
            <a>Password Dimenticata?</a>

            <input type="submit" value="Registrati!">
  
        </form>
        <div class="buttons">
            <a href="login.jsp"class="access">Login</a>
            <a class="access">Register</a>
        </div>
    </div>

    <div class="right-page">
        <nav>
            <img src="images/home-icon.png" alt="home-icon" class="home-icon">
        </nav>
    </div>
</body>
</html>