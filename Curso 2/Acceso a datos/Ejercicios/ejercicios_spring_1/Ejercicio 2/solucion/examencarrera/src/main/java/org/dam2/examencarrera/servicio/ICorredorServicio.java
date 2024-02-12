package org.dam2.examencarrera.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.examencarrera.modelo.dto.CorredorDto;
import org.dam2.examencarrera.modelo.entidad.Corredor;

public interface ICorredorServicio {
	
	public boolean insertar (CorredorDto corredor);
	public List<CorredorDto> findAll ();
	public Optional<CorredorDto> findByDNI(String dni);

}
