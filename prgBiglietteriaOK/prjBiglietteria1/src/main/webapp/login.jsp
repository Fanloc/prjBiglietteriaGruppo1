<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%! 
String msg; 
%>
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
        <form action="gestAccount?cmd=login" method="post">
            <h1>Login</h1>
    		<%
        	msg = request.getParameter("msg");
        	if(msg != null){
        		if(msg.equalsIgnoreCase("reg_done")){
        	%>
        		<div class="msg">Registrazione avvenuta</div>
        	<% 
        		}
        		if(msg.equalsIgnoreCase("error")){
        	%>
        		<div class="msg">Email non registrata o password errata</div>
       	 <%	
       	 	}
       	 }
      	  %>
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