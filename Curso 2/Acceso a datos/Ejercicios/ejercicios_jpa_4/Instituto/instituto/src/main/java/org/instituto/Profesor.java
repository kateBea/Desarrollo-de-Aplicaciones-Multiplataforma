package org.instituto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

//Lombok
@Data
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

//Hibernate
@Entity
@Table(name = "PROFESOR")

public class Profesor extends Persona {
	// MIEMBROS PRIVADOS ----------------------------------------
	@Column(nullable = false)
	private String nombreDept;
	
	@Column(nullable = false)
	private String despacho;

	
	
	// MIEMBROS ESTÁTICOS ----------------------------------------
	
	// Máximo de estudiantes por profesor
	private static final int MAX_ESTUDIANTES = 10;
	
	
	
	// MÉTODOD PÚBLICOS ----------------------------------------
	
	/**
	 * Retorna el máximo de estudiantes permitido por profesor.
	 * @returns Estudiantes por profesor.
	 * */
	public int getMaxEstudiantes() {
		return MAX_ESTUDIANTES;
	}
}
