package org.dam2.examencarrera.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.examencarrera.modelo.dto.CarreraConPCDto;
import org.dam2.examencarrera.modelo.dto.CarreraDto;
import org.dam2.examencarrera.modelo.dto.CorredorDto;
import org.dam2.examencarrera.modelo.entidad.Carrera;
import org.dam2.examencarrera.modelo.entidad.Corredor;


public interface ICarreraServicio {
	public boolean insertar (CarreraConPCDto carrera);
	public boolean tienePlazasLibres (String nombre);
	public List<CarreraDto> findAll ();
	public Optional<CarreraDto> findByNombre(String nombre);
	public List<CorredorDto> obtenerCorredores (String nombre);
	public List <CarreraDto> carrerasDisponiblesPorCorredor (String dni);
	public List<CorredorDto> clasificacionCarreraMasAntigua ();

}
