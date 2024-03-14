package org.dam2.mongonoticias.servicio;

import java.util.List;

import org.dam2.mongonoticias.modelo.Lugar;
import org.springframework.data.geo.Polygon;

public interface ILugarServicio {

	List<Lugar> buscarPorPosicionDentroDe (Polygon polygon);
	boolean insertar (Lugar lugar);
	List<Lugar> findAll ();
}
