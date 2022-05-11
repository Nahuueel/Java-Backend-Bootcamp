package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {

	private String bdName = "dia8";
	private String user = "root";
	private String password = "123";
	
	private String url="jdbc:mysql://localhost:3306/"
	+bdName +"?userUnicode=true&use"+"JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
			+"serverTimezon=UTC";
	
	Connection conn=null;
	
	public Conection()
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
			if(conn !=null)
			{
				System.out.println("conexion exitosa");
			}
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("error al conectar");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection()
	{
		return conn;
	}
}