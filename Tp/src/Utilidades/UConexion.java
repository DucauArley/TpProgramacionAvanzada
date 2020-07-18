package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UConexion 
{
	private static UConexion instance;
	private Connection con;
	
	public static UConexion instancia() 
	{
		if(instance == null) 
		{
			instance = new UConexion();
			return instance;
		}
		else 
		{
			return instance;
		}
	}
	
	public Connection getConexion() 
	{
		return this.con;
	}
	
	
	public void conectar() 
	{
		try 
		{
			ResourceBundle rs = ResourceBundle.getBundle("framework");
						
			Class.forName(rs.getString("driver"));
			this.con = DriverManager.getConnection(rs.getString("ubicacion"), rs.getString("user"),rs.getString("pass"));
	
		}
		catch(ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void desconectar() 
	{
		try 
		{
			this.con.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
}
