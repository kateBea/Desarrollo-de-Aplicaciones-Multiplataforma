package org.dam2.mongonoticias.servicio;

import java.util.List;

import org.dam2.mongonoticias.modelo.Lugar;
import org.dam2.mongonoticias.repositorio.LugarRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Polygon;
import org.springframework.stereotype.Service;

@Service
public class LugarServicioImpl implements ILugarServicio {
	
	@Autowired LugarRepositorio lugarDAO;

	@Override
	public List<Lugar> buscarPorPosicionDentroDe(Polygon polygon) {
		// TODO Auto-generated method stub
		return lugarDAO.findByPosicionWithin(polygon);
	}

	@Override
	public boolean insertar(Lugar lugar) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (lugarDAO.findById(lugar.getNombre()).isEmpty())
		{
			lugarDAO.insert(lugar);
			exito = true;
		}
		return exito;
	}

	@Override
	public List<Lugar> findAll() {
		// TODO Auto-generated method stub
		return lugarDAO.findAll();
	}

}
