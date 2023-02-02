package it.meucci;
import java.sql.*;

import java.util.ArrayList;

public class DBManager {
	private Connection conn;
	private Statement query;
	private ResultSet rs;
	private String urlDB;
	private String userDB;
	private String passwordDB;
	
public DBManager() throws Exception 
	{
		//instaurazione della connessione
		urlDB="jdbc:mysql://localhost:3306/AZIENDA_5BI?serverTimezone=UTC";
		//Attivazione dei driver JDBC - MySQL
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Registrati!");
		//INstaurazione della connessione
		conn=DriverManager.getConnection(urlDB, "root", "");
		System.out.println("Connessione ON!");
		query = conn.createStatement();
		System.out.println("Query ON!");
	}
	
	public void close() throws SQLException
	{
		query.close();
		conn.close();
	}
	public boolean checkRegistration(Utente u) {
		return true;
	}
	
	/*public int insertCliente(cliente cliente) throws SQLException
	{
		int nRighe;
		//INSERT
		String sqlInsert = "INSERT INTO CLIENTI(customerID, companyname, contactname, phone) VALUES ('"+cliente.getFName()+"','"+cliente.getLName()+"','"
				+cliente.getUsername()+"','"
				+cliente.getPhone()+ cliente.getPassword() + "');";
		System.out.println(sqlInsert);
		nRighe=query.executeUpdate(sqlInsert);
		System.out.println( nRighe + " riga inserita!");		
	
		return nRighe;
	}
	
	public int deleteCliente(String username) throws SQLException
	{
		int nRighe;
		
		String sqlDelete = "DELETE FROM CLIENTI WHERE CustomerID = '"+username+"';";
		System.out.println(sqlDelete);
		nRighe = query.executeUpdate(sqlDelete);	
		
		return nRighe;
	}
	
	public ArrayList<cliente> listcliente() throws SQLException
	{
		ArrayList<cliente> elenco =new ArrayList<>();
		cliente cliente;
		String sqlSelect = "SELECT * FROM CLIENTI;";
		System.out.println(sqlSelect);
		
		rs=query.executeQuery(sqlSelect);
		while(rs.next())
		{
			cliente=new cliente();
			cliente.setFName(rs.getString("txtfname"));
			cliente.setLName(rs.getString("txtlname"));
			cliente.setUsername(rs.getString("txtuser"));
			cliente.setEmail(rs.getString("txtemail"));
			cliente.setPhone(rs.getString("txtphone"));
			cliente.setPassword(rs.getString("txtpassword"));
			cliente.setConfpass(rs.getString("confpass"));
			elenco.add(cliente);
		}
		rs.close();
		return elenco;
	}
	
	public cliente readCliente(String username) throws Exception
	{
		cliente cliente=new cliente();
		String sqlSelectDettaglio = "SELECT * FROM CLIENTI WHERE CustomerID = '"+username+"';";
		System.out.println(sqlSelectDettaglio);
		rs=query.executeQuery(sqlSelectDettaglio);
		while(rs.next())
		{
			cliente.setFName(rs.getString("txtfname"));
			cliente.setLName(rs.getString("txtlname"));
			cliente.setUsername(rs.getString("txtuser"));
			cliente.setEmail(rs.getString("txtemail"));
			cliente.setPhone(rs.getString("phone"));
			cliente.setPassword(rs.getString("txtpassword"));
			cliente.setConfpass(rs.getString("txtfconfpass"));
		}	
		rs.close();
		return cliente;
	}*/
}