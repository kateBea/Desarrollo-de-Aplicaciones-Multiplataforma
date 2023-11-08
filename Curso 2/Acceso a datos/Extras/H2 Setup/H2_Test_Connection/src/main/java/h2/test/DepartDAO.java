package h2.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartDAO implements DAOInterface<Depart, String>{

	@Override
	public Optional<Depart> findById(String key) {
		// TODO Auto-generated method stub
		
		Optional<Depart> optionalDepart = Optional.empty();
		
		String sql = "SELECT * FROM departamento WHERE id = ?";
		
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, key);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.first()) {
				Depart depart = Depart.builder().
								deptNo(key).
								dname(rs.getString("nombre")).
								loc(rs.getString("localidad")).
								fechaCreacion(rs.getDate("fecha_creacion").toLocalDate()).
								build();
				
				optionalDepart = Optional.of(depart);
			}
			
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
				Depart depart = Depart.builder().
						deptNo(rs.getString("id")).
						dname(rs.getString("nombre")).
						loc(rs.getString("localidad")).
						fechaCreacion(rs.getDate("fecha_creacion").toLocalDate()).
						build();
				lista.add(depart);
			}
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
		
		String sql = "INSERT INTO DEPART (DEPT_NO, DNOMBRE,LOC) VALUES (?,?,?)";
		
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, ov.getDeptNo());
			pst.setString(2, ov.getDname());
			pst.setString(3, ov.getLoc());
			
			cuantos = pst.executeUpdate();
			
			ConexionBBDD.desconectar();
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
		
		String sql = "UPDATE DEPART SET DNOMBRE = ?, LOC = ? WHERE DEPT_NO = ?"; 
		
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			
			pst.setString(1, ov.getDname());
			pst.setString(2, ov.getLoc());
			pst.setString(3, ov.getDeptNo());
			
			cuantos = pst.executeUpdate();
			
			ConexionBBDD.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cuantos;
		
	}
	

}
