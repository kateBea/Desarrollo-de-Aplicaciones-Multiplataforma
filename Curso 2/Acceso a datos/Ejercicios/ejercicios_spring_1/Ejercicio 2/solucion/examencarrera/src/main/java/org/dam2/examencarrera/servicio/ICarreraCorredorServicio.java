package org.dam2.examencarrera.servicio;

import java.util.List;

import org.dam2.examencarrera.modelo.dto.CarreraCorredorDto;
import org.dam2.examencarrera.modelo.dto.CarreraDto;
import org.dam2.examencarrera.modelo.dto.CorredorDto;


public interface ICarreraCorredorServicio {
	public int insertarCorredorCarrera (CorredorDto corredor, CarreraDto carrera);
	public boolean anotarTiempoCorredorCarrera (CorredorDto corredor, CarreraDto carrera, int tiempo);
	public List<CarreraCorredorDto> findAll();

}
