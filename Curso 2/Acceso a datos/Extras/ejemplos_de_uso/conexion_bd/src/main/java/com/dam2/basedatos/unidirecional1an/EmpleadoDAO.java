package com.dam2.basedatos.unidirecional1an;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dam2.basedatos.ConexionBBDD;
import com.dam2.basedatos.DAOInterface;

public class EmpleadoDAO implements DAOInterface<Empleado, String> {

	@Override
	public Optional<Empleado> findById(String key) {
		// TODO Auto-generated method stub
		
		Optional<Empleado> optionalEmple = Optional.empty();
		
		String sql = "SELECT * FROM EMPLE WHERE EMP_NO = ?";
		
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, key);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.first()) {
				
				Empleado emple = cargarEmpleado (rs);
				
				optionalEmple = Optional.of(emple);
			}
			
			ConexionBBDD.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return optionalEmple;
	}

	@Override
	public Iterable<Empleado> findAll() {
		// TODO Auto-generated method stub
		List <Empleado> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM EMPLE";
		
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {

				Empleado emple =cargarEmpleado(rs);
				lista.add(emple);
			}
			ConexionBBDD.desconectar();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return lista;
	}

	@Override
	public int delete(Empleado ov) {
		// TODO Auto-generated method stub
		int cuantos = 0;
		
		String sql = "DELETE FROM EMPLE WHERE EMP_NO = ?";
		
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, ov.getEmpNo());
			
			cuantos = pst.executeUpdate();
			
			ConexionBBDD.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cuantos;
	}

	@Override
	public int save(Empleado ov) {
		// TODO Auto-generated method stub
		int cuantos = 0;
		
		String sql = "INSERT INTO EMPLE (EMP_NO, APELLIDOS,FECHA_ALT,SALARIO) VALUES (?,?,?,?)";
		
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			
			pst.setString(1, ov.getEmpNo());
			pst.setString(2, ov.getApellido());
			pst.setDate(3, Date.valueOf(ov.getFechaAlta()));
			pst.setFloat(4, ov.getSalario());
			
			//pst.setString(5, "9999"); // Sin departamento asignado
			
			
			cuantos = pst.executeUpdate();
			
			ConexionBBDD.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cuantos;
	}

	@Override
	public int update(Empleado ov) {
		// TODO Auto-generated method stub
		int cuantos = 0;
		
		String sql = "UPDATE EMPLE SET APELLIDOS = ?, FECHA_ALT = ?,"
				+ "	SALARIO = ? WHERE EMP_NO = ?"; 
		
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			
			
			pst.setString(1, ov.getApellido());
			pst.setDate(2, Date.valueOf(ov.getFechaAlta()));
			pst.setFloat(3, ov.getSalario());	
			pst.setString(4, ov.getEmpNo());
			
			cuantos = pst.executeUpdate();
			
			ConexionBBDD.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cuantos;
	}
	
	protected static Empleado cargarEmpleado (ResultSet rs) throws SQLException
	{
		Empleado emple = new Empleado();
		emple.setEmpNo(rs.getString("EMP_NO"));
		emple.setApellido(rs.getString("APELLIDOS"));
		Date fecha = rs.getDate("FECHA_ALT");
		emple.setFechaAlta(fecha.toLocalDate());
		emple.setSalario(rs.getFloat("SALARIO"));
		
		return emple;
		
	}
	
	protected void updateDepart (Empleado emple, String deptno)
	{
		String sql = "UPDATE EMPLE SET DEPT_NO = ? WHERE EMP_NO = ?"; 
		
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			
			
			pst.setString(1, deptno);
			
			pst.setString(2, emple.getEmpNo());
			
			pst.executeUpdate();

			ConexionBBDD.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
