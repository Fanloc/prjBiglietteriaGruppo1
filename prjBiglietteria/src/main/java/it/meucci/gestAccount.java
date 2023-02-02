package it.meucci;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gestAccount")
public class gestAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public gestAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cmd = request.getParameter("cmd");
		if(cmd.equalsIgnoreCase("register"))
		{
			String conf_pwd = request.getParameter("conf_password");
			if(!checkPassword(password,conf_pwd)) response.sendRedirect("register.jsp?msg=reg_pwd");
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			//IMPLEMENTARE CHECK REG IN DBManager
			DBManager db;
			try {
				db = new DBManager();
				Utente u = new Utente(email,password,nome,cognome);
				if(db.checkRegistration(u)) {response.sendRedirect("login.jsp?msg=reg_done");}
				else {response.sendRedirect("register.jsp?msg=reg_exist");}
			} catch (Exception e) {}
		}
	}
	
	
	private boolean checkPassword(String pwd, String conf_pwd) {
		if(pwd.equals(conf_pwd)) return true;
		else return false;
	}
}
