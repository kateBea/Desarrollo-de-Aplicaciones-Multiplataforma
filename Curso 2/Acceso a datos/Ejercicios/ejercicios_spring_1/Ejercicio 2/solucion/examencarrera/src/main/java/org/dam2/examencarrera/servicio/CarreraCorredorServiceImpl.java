package org.dam2.examencarrera.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.examencarrera.errores.RollBackException;
import org.dam2.examencarrera.modelo.dto.CarreraCorredorDto;
import org.dam2.examencarrera.modelo.dto.CarreraDto;
import org.dam2.examencarrera.modelo.dto.CorredorDto;
import org.dam2.examencarrera.modelo.entidad.Carrera;
import org.dam2.examencarrera.modelo.entidad.CarreraCorredor;
import org.dam2.examencarrera.modelo.entidad.Corredor;
import org.dam2.examencarrera.repositorio.CarreraCorredorRepositorio;
import org.dam2.examencarrera.repositorio.CarreraRepositorio;
import org.dam2.examencarrera.repositorio.CorredorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarreraCorredorServiceImpl implements ICarreraCorredorServicio {

	@Autowired private CorredorRepositorio corredorDAO;
	@Autowired private CarreraRepositorio carreraDAO;
	@Autowired private CarreraCorredorRepositorio carreraCorredorDAO;
	
	@Transactional(rollbackFor = RollBackException.class)
	@Override
	public int insertarCorredorCarrera(CorredorDto corredorDto, CarreraDto carreraDto) {
		// TODO Auto-generated method stub
		int dorsal = -1;
		CarreraCorredor cc;
		Corredor corredor = ObjectMapperUtils.map(corredorDto, Corredor.class);
		// Obtener datos de carrera
		Optional<Carrera> carrera = carreraDAO.findById(carreraDto.getNombre());
		
		// hay que insertar el corredor, no hay cascade
		if (!corredorDAO.existsById(corredor.getDni()))
			corredorDAO.save(corredor);
		
		
		if (carrera.isPresent())
			if (carreraDAO.cuantosInscritos(carrera.get().getNombre()) <  carrera.get().getMaximo())
				if (carreraCorredorDAO.carrerasNoInscritasDelCorredor(corredor.getDni()).contains(carrera.get()))
				{
					dorsal = carreraDAO.cuantosInscritos(carrera.get().getNombre())+1;
					cc = CarreraCorredor.builder().
						carrera(carrera.get()).
						corredor(corredor).
						dorsal(dorsal).
						build();
					carreraCorredorDAO.save(cc);
				}
				else
					throw new RollBackException("corredor inscrito ya en la carrera " + carrera.get().getNombre());
			else
				throw new RollBackException("carrera " + carrera.get().getNombre() + " sin plazas");
		else
			throw new RollBackException("la carrera " + carrera.get().getNombre() + " no existe");
		
		System.out.println(corredor.getDni() + " ->"+ carrera.get().getNombre() +  "->" + dorsal);
		return dorsal;
	}

	@Override
	public boolean anotarTiempoCorredorCarrera(CorredorDto corredorDto, CarreraDto carreraDto, int tiempo) {
		// TODO Auto-generated method stub
		boolean exito = false;
		Optional<CarreraCorredor> carreraCorredor;
		CarreraCorredor cc;
		Corredor corredor = ObjectMapperUtils.map(corredorDto, Corredor.class);
		Carrera carrera = ObjectMapperUtils.map(carreraDto, Carrera.class);
		
		
		if (corredorDAO.findById(corredor.getDni()).isPresent() &&
				carreraDAO.findById(carrera.getNombre()).isPresent() &&
				carreraDAO.corredoresPorCarrera(carrera.getNombre()).contains(corredor))
		{
			carreraCorredor = carreraCorredorDAO.findByCarreraAndCorredor(carrera, corredor);
			if (carreraCorredor.isPresent())
			{
				cc = carreraCorredor.get();
				cc.setTiempo(tiempo);
				carreraCorredorDAO.save(cc);
				exito = true;
			}
		}
		
		return exito;
	}

	@Override
	public List<CarreraCorredorDto> findAll() {
		// TODO Auto-generated method stub
		return 	ObjectMapperUtils.
					mapAll((List<CarreraCorredor>) carreraCorredorDAO.findAll(), 
							CarreraCorredorDto.class);
	}

}
