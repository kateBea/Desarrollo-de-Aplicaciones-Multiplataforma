package h2.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OperacionesBasicasBBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conexion;
		PreparedStatement pst;
		String sql;
		int filasAfectadas;
		
		// crear conexion
		conexion = ConexionBBDD.conectar();
		
		// Buscar por clave
		// Consultar datos por clave
		sql = "SELECT * FROM departamento WHERE id = ?";
		
		try {
			pst = conexion.prepareStatement(sql);
		
			pst.setString(1, "001");
			
			ResultSet rs = pst.executeQuery();
			
			System.out.println("Buscar por clave");
			if (rs.first()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("nombre"));
				System.out.println(rs.getString("localidad"));
				System.out.println(rs.getDate("fecha_creacion"));
			}
			else
				System.out.println("el departamento no existe");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Buscar todos
		sql = "SELECT * FROM departamento";
		try {
			pst = conexion.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			System.out.println("Buscar todos");
			while (rs.next()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("nombre"));
				System.out.println(rs.getString("localidad"));
				System.out.println(rs.getDate("fecha_creacion").toLocalDate());
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// Insertar una fila
		sql = "INSERT INTO departamento (id, nombre,localidad,fecha_creacion) VALUES (?,?,?,?)";
		try {
			pst = conexion.prepareStatement(sql);
			
			pst.setString(1, "003" );
			pst.setString(2, "bbdd");
			pst.setString(3, "jaen");
			pst.setDate(4, Date.valueOf(LocalDate.now().minusYears(3)));
			
			if (pst.executeUpdate() > 0)
				System.out.println("fila insertada correctamente");
			else
				System.out.println("error insertando fila");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Modificar fila
		sql = "UPDATE departamento SET NOMBRE = ?, localidad = ? WHERE id= ?"; 
		try {
			pst = conexion.prepareStatement(sql);
			
			pst.setString(1, "redes");
			pst.setString(2, "madrid");
			pst.setString(3, "003");
			
			filasAfectadas = pst.executeUpdate();
			
			System.out.println("nº de filas actualizadas " + filasAfectadas);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Borrar fila por clave
		sql = "DELETE FROM departamento WHERE id = ?";
		try {
			pst = conexion.prepareStatement(sql);
			pst.setString(1, "003");
			
			filasAfectadas = pst.executeUpdate();
			
			System.out.println("nº de filas borradas " + filasAfectadas);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Cerrar conexión
		ConexionBBDD.desconectar();
	}

}
