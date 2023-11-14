package com.dam2.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectarBBDDH2 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		String usuario = "sa";
		String password = "";
		String urlConexion = "jdbc:h2:";
		String bd = "~/test";
		
		String url = urlConexion + bd;
		
		
		try (Connection conn = DriverManager.getConnection(url, usuario, password))
		{
	
			Class.forName("org.h2.Driver");

			System.out.println("conexion realizada correctamente");

			// Mostrar datos

			//String sql = "SELECT * FROM DEPART";
			//Statement st = conn.createStatement();
			//ResultSet rs = st.executeQuery(sql);
			
			String sql = "SELECT * FROM DEPART WHERE DNOMBRE = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "GENERAL");
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("DNOMBRE"));
			}
		}
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		

	}

}
