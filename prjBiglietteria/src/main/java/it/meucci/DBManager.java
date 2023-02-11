package it.meucci;

import java.sql.*;
import java.util.ArrayList;

public class DBManager
{
	
	Connection connessione;
	Statement query;
	ResultSet rs;
	//IP, porta, db, (UrlDB)
	String urlDB="jdbc:mysql://localhost:3306/gestioneeventi?serverTimezone=UTC";
	String userDB="root";
	String pwdDB="";
	public DBManager() throws Exception
	{
		connetti();
		
	}	
	public boolean checkRegistration(Utente u) {
		String email = u.getEmail();
		String password = u.getPassword();
		
		String sql = "SELECT FROM UTENTI WHERE email = ? AND password = ?";
		PreparedStatement stmt = null;
		
		try {
			stmt = connessione.prepareStatement(sql);
			
			stmt.setString(1, email);
			stmt.setString(2,password);
			
			rs = stmt.executeQuery();
			if(!rs.next()) {
				try {
					insertUser(u);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return false;
	}
	public void insertUser(Utente u) throws Exception
	{
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO utenti (email,password,nome,cognome) VALUES(?,?,?,?);";
		
		stmt = connessione.prepareStatement(sql);
        
        stmt.setString(1, u.getEmail());
        stmt.setString(2, u.getPassword());
        stmt.setString(3, u.getNome());
        stmt.setString(4, u.getCognome());
        
        stmt.execute();
        
        stmt.close();
        connessione.close();
	}
	/*public boolean checkLogin(String username, String password) throws SQLException {
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM utenti WHERE username = ? AND password = ?;";
		
        try {
        	stmt = connessione.prepareStatement(sql);
			stmt.setString(1, username);
	        stmt.setString(2, password);
	        rs = stmt.executeQuery();
	        if(rs.next()) {
	            stmt.close();
	            connessione.close();
	        	return true;
	        }
	        else {
	            stmt.close();
	            connessione.close();
	        	return false;
	        }
		} catch (SQLException e) {e.printStackTrace();}

        
        stmt.close();
        connessione.close();
		return false;
	}
	public boolean checkRegister(String username) throws SQLException {
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM utenti WHERE username = ?;";
		try {
        	stmt = connessione.prepareStatement(sql);
			stmt.setString(1, username);
	        if(stmt.getResultSet() != null) {
	            stmt.close();
	            connessione.close();
	        	return false;
	        }
	        else {
	        	return true;
	        }
		} catch (SQLException e) {e.printStackTrace();}

        
        stmt.close();
        connessione.close();
		return false;
	}
    public ArrayList<Cliente> getClienti() throws SQLException{

		
		String sql = "SELECT * FROM clienti;";
		
		System.out.println("QUERY ESEGUITA " + sql);
		ArrayList<Cliente> lista=new ArrayList<Cliente>();

		//4) Visualizzazione dei dati
		
		Cliente c;
		try {
			query=connessione.createStatement();
			
			rs=query.executeQuery(sql);
			while(rs.next())
				{
					c = new Cliente( 
							rs.getString("CustomerID"),
							rs.getString("CompanyName"),
							rs.getString("ContactName"),
							rs.getString("ContactTitle"),
							rs.getString("Address"),
							rs.getString("City"),
							rs.getString("Region"),
							rs.getString("PostalCode"),
							rs.getString("Country"),
							rs.getString("Phone"),
							rs.getString("Fax")

							);
				
					lista.add(c);
				}

		}catch (SQLException e) {e.printStackTrace();}
		System.out.println(lista.size()+" clienti!");		
		rs.close();
		connessione.close();
		return lista;
	}
	
	

	public Cliente getCliente(String id) throws SQLException {
		String sql = "SELECT * FROM clienti WHERE CustomerID='"+ id+"';";
		
		System.out.println("QUERY ESEGUITA " + sql);

		//4) Visualizzazione dei dati
		
		Cliente c = new Cliente();
		try {
			query=connessione.createStatement();
			
			rs=query.executeQuery(sql);
			if(rs.next())
				{
					c = new Cliente( 
							rs.getString("CustomerID"),
							rs.getString("CompanyName"),
							rs.getString("ContactName"),
							rs.getString("ContactTitle"),
							rs.getString("Address"),
							rs.getString("City"),
							rs.getString("Region"),
							rs.getString("PostalCode"),
							rs.getString("Country"),
							rs.getString("Phone"),
							rs.getString("Fax")
							);
				}

		}catch (SQLException e) {e.printStackTrace();}		
		if(rs!=null) {rs.close();}
		connessione.close();
		return c;
	}
	public void update(String customerID, String companyName, String contactName, String contactTitle, String address,
			String city, String region, String postalCode, String country, String phone, String fax) throws SQLException {
		PreparedStatement stmt = null;
		
		String sql = "UPDATE clienti SET CompanyName = ?, ContactName = ?,ContactTitle = ?,Address = ?,City=?,Region = ?, PostalCode = ?, Country = ?,Phone = ?, Fax =? WHERE CustomerID= ?;";
		
        try {
        	stmt = connessione.prepareStatement(sql);
			stmt.setString(1, companyName);
	        stmt.setString(2, contactName);
	        stmt.setString(3, contactTitle);
	        stmt.setString(4, address);
	        stmt.setString(5, city);
	        stmt.setString(6, region);
	        stmt.setString(7, postalCode);
	        stmt.setString(8, country);
	        stmt.setString(9, phone);
	        stmt.setString(10, fax);
	        stmt.setString(11, customerID);
	        
	        
	        stmt.execute();
		} catch (SQLException e) {e.printStackTrace();}

        
        stmt.close();
        connessione.close();
	}
	
	public void deleteCliente(String id) throws SQLException {
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM clienti WHERE CustomerID= ?";
		
        try {
        	stmt = connessione.prepareStatement(sql);
			stmt.setString(1, id);
	        stmt.execute();
		} catch (SQLException e) {e.printStackTrace();}

        
        stmt.close();
        connessione.close();
	}
	public boolean checkCliente(String CustomerID) throws SQLException {
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM clienti WHERE CustomerID = ?;";
		try {
        	stmt = connessione.prepareStatement(sql);
			stmt.setString(1, CustomerID);
	        if(stmt.getResultSet() != null) {
	            stmt.close();
	            connessione.close();
	        	return false;
	        }
	        else {
	        	return true;
	        }
		} catch (SQLException e) {e.printStackTrace();}

        
        stmt.close();
        connessione.close();
		return false;
	}
	public void addCliente(String customerID, String companyName, String contactName, String contactTitle, String address,
			String city, String region, String postalCode, String country, String phone, String fax) throws SQLException {
		
		PreparedStatement stmt = null;
		String sql = "INSERT INTO clienti (CustomerID,CompanyName,ContactName,ContactTitle,Address,City,Region,PostalCode,Country,Phone,Fax)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?);";
		
        try {
        	stmt = connessione.prepareStatement(sql);
        	stmt.setString(1, customerID);
			stmt.setString(2, companyName);
	        stmt.setString(3, contactName);
	        stmt.setString(4, contactTitle);
	        stmt.setString(5, address);
	        stmt.setString(6, city);
	        stmt.setString(7, region);
	        stmt.setString(8, postalCode);
	        stmt.setString(9, country);
	        stmt.setString(10, phone);
	        stmt.setString(11, fax);
	        stmt.execute();
		} catch (SQLException e) {e.printStackTrace();}

        
        stmt.close();
        connessione.close();
	}*/
	private void connetti() throws Exception
	{
		//1) Driver registration
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver registrati!");
		//2) Instaurazione della connessione al DB
		connessione=DriverManager.getConnection(urlDB, userDB, pwdDB);
		System.out.println("Connessione instaurata!");
	}
	public void disconnetti() throws Exception
	{
		query.close();
		connessione.close();
	}
}

