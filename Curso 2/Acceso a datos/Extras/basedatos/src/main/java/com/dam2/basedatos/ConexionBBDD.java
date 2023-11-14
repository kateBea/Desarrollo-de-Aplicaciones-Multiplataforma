package com.dam2.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
	
	private static Connection conexion = null; 
	
	
	
	public static Connection conectar ()
	{
		String usuario = "sa";
		String password = "";
		String urlConexion = "jdbc:h2:";
		String bd = "~/test";
		
		String url = urlConexion + bd;
		
		if (conexion == null)
		{
			try {
				Class.forName("org.h2.Driver");
				conexion = DriverManager.getConnection(url, usuario, password);
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return conexion;
		
	}


	public static void desconectar()  {
		if (conexion != null)
			try {
				if (!conexion.isClosed())
				{
					conexion.close();
					conexion = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public static void setTransaccional (boolean transaccional)
	{
		if (conexion != null)
			try {
				if (!conexion.isClosed())
				{
					conexion.setAutoCommit(transaccional);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public static void commit ()
	{
		if (conexion != null)
			try {
				if (!conexion.isClosed() && !conexion.getAutoCommit())
				{
					conexion.commit();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public static void rollback ()
	{
	if (conexion != null)
		try {
			if (!conexion.isClosed() && !conexion.getAutoCommit())
			{
				conexion.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
