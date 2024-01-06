package org.instituto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

//Lombok
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

//Hibernate
@Entity
@Table(name = "PERSONA")

public class Profesor extends Persona {
	private String nombreDept;
	private String despacho;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "estudiantes")
	private Set<Estudiante> estudiantes;
	
	// Máximo de estudiantes por profesor
	private static final int MAX_ESTUDIANTES = 10;
	
	
	/**
	 * Retorna el máximo de estudiantes permitido por profesor.
	 * @returns Estudiantes por profesor.
	 * */
	public int getMaxEstudiantes() {
		return MAX_ESTUDIANTES;
	}
}
