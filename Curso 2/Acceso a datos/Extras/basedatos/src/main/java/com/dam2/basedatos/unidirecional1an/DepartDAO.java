package com.dam2.basedatos.unidirecional1an;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

import com.dam2.basedatos.ConexionBBDD;
import com.dam2.basedatos.DAOInterface;

public class DepartDAO implements DAOInterface<Depart, String>{

	@Override
	public Optional<Depart> findById(String key) {
		// TODO Auto-generated method stub
		
		Optional<Depart> optionalDepart = Optional.empty();
		
		
		String sql = "SELECT * FROM DEPART WHERE DEPT_NO = ?";
		
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, key);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.first()) {
				
				Depart depart = cargarDepartamento (rs);
				optionalDepart = Optional.of(depart);
			}
			
			
			cargarEmpleados(optionalDepart.orElse(new  Depart()));
			
			ConexionBBDD.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return optionalDepart;
	}

	@Override
	public Iterable<Depart> findAll() {
		// TODO Auto-generated method stub
		List <Depart> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM DEPART";
		
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Depart depart = cargarDepartamento (rs);
				lista.add(depart);
			}
			
			// Cargar empleados
			lista.forEach( d -> cargarEmpleados(d));
			
			ConexionBBDD.desconectar();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return lista;
	}

	@Override
	public int delete(Depart ov) {
		// TODO Auto-generated method stub
		int cuantos = 0;
		
		String sql = "DELETE FROM DEPART WHERE DEPT_NO = ?";
		
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, ov.getDeptNo());
			cuantos = pst.executeUpdate();
			
			// Borrado en cascada
			EmpleadoDAO dao = new EmpleadoDAO();
			ov.getEmpleados().forEach(dao::delete);
			
			ConexionBBDD.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cuantos;
	}

	@Override
	public int save(Depart ov) {
		// TODO Auto-generated method stub
		int cuantos = 0;
		
		
		
		PreparedStatement pst;
		
		try {
			String sql = "INSERT INTO DEPART (DEPT_NO, DNOMBRE,LOC) VALUES (?,?,?)";
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, ov.getDeptNo());
			pst.setString(2, ov.getDname());
			pst.setString(3, ov.getLoc());
			cuantos = pst.executeUpdate();
			ConexionBBDD.desconectar();
			
			EmpleadoDAO dao = new EmpleadoDAO();
			
			// Insertar empleados
			//ov.getEmpleados().forEach(dao::save);
			
			// Asignar empleados al deparamento
			//ov.getEmpleados().forEach( e -> dao.updateDepart(e,ov.getDeptNo()));
			
			
			// Insertar y asignar empleados al departamento
			Consumer<Empleado> action = e -> {dao.save(e);dao.updateDepart(e,ov.getDeptNo());};
			ov.getEmpleados().forEach(action);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cuantos;
	}

	@Override
	public int update(Depart ov) {
		// TODO Auto-generated method stub
		
		int cuantos = 0;
		
		 
		
		PreparedStatement pst;
		
		try {
			String sql = "UPDATE DEPART SET DNOMBRE = ?, LOC = ? WHERE DEPT_NO = ?";
			
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			
			pst.setString(1, ov.getDname());
			pst.setString(2, ov.getLoc());
			pst.setString(3, ov.getDeptNo());
			cuantos = pst.executeUpdate();
			ConexionBBDD.desconectar();
			
			// Actualizar empleados
			EmpleadoDAO dao = new EmpleadoDAO();
			ov.getEmpleados().forEach(dao::update);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cuantos;
		
	}
	
	protected Depart cargarDepartamento (ResultSet rs) throws SQLException
	{
		Depart depart = new Depart();
		
		
		depart.setDeptNo(rs.getString("DEPT_NO"));
		depart.setDname(rs.getString("DNOMBRE"));
		depart.setLoc(rs.getString("LOC"));
		
				
		return depart;
	}
	
	protected void cargarEmpleados (Depart depart)
	{
		Set <Empleado> lista = new HashSet<>();
		
		String sql = "SELECT * FROM EMPLE  WHERE DEPT_NO = ?";
		
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			
			pst.setString(1, depart.getDeptNo());
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {

				Empleado emple = EmpleadoDAO.cargarEmpleado (rs);
				lista.add(emple);
			}
			ConexionBBDD.desconectar();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		depart.setEmpleados(lista);	
	}

}
