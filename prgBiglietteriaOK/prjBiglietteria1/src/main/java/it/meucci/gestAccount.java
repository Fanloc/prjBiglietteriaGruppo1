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
		System.out.println("cmd");
		if(cmd.equalsIgnoreCase("register"))
		{
			String conf_pwd = request.getParameter("conf_pwd");
			if(!password.equals(conf_pwd)) response.sendRedirect("register.jsp?msg=reg_pwd");
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			//IMPLEMENTARE CHECK REG IN DBManager
			DBManager db;
			try {
				db = new DBManager();
				Utente u = new Utente(email,password,nome,cognome);
				if(db.checkRegistration(u)) {
					response.sendRedirect("login.jsp?msg=reg_done");
					}
				else {response.sendRedirect("register.jsp?msg=reg_exist");}
			} catch (Exception e) {}
		}
		if(cmd.equalsIgnoreCase("login")) {
			System.out.println("siu1");
			DBManager db;
			try {
				System.out.println("siu2");
				db = new DBManager();
				if(db.checkLogin(email,password)){
					System.out.println("siu3");
					response.sendRedirect("home.jsp");
				}else {
					response.sendRedirect("login.jsp?msg=error");
				}
			}catch(Exception e) {}
		}
	}
}