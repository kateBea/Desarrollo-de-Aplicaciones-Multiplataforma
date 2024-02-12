package org.dam2.examencarrera.servicio;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.dam2.examencarrera.modelo.dto.CarreraDto;
import org.dam2.examencarrera.modelo.dto.CorredorDto;
import org.dam2.examencarrera.modelo.entidad.Carrera;
import org.dam2.examencarrera.modelo.entidad.Corredor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class ObjectMapperUtils {
	

	
	private static final ModelMapper modelMapper;
	
	 static {
	        modelMapper = new ModelMapper();
	        //modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    }
	

	public static <D, T> List<D> mapAll(final Collection<T> inputList, Class<D> outCLass)
	{
		        return inputList.stream()
		                .map(input -> map(input, outCLass))
		                .collect(Collectors.toList());
	}
	
	 public static <D, T> D map(final T input, Class<D> outClass) {
	        return modelMapper.map(input, outClass);
	    }

}
