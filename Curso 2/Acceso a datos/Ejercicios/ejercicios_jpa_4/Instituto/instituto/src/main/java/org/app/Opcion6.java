package org.app;

import java.util.List;

import org.instituto.Profesor;
import org.utilidades.Input;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Opcion6 extends OpcionMenu {

	@Override
	public void accion() {
		// TODO Auto-generated method stub
		final String nombreDpt = Input.leerCadena("Introduce el nombre de departamento: ");
		
		List<Profesor> profesores = Contexto.getDaoProfesor().findAll();
		
		profesores.stream()
			.filter(profe -> profe.getEstudiantes().isEmpty() && profe.getNombreDept().equalsIgnoreCase(nombreDpt))
			.forEach(System.out::println);		
	}

}
