package org.dam2.gruposalumnosmodulos;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class CalificacionListener {
	
	@PrePersist
	@PreUpdate
	public void comprobarCalificacion (Calificacion calificacion)
	{
		System.out.println("antes de escribir en BBDD");
		if (calificacion.getNota() != null)
		{
		if (calificacion.getNota() < 1)
			calificacion.setNota(1);
		else if (calificacion.getNota() > 10)
			calificacion.setNota(10);
		}
	}
	

}