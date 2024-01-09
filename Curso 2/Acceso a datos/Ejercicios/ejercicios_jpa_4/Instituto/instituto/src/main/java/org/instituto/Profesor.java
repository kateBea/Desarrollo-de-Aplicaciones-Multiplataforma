package org.instituto;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	// Error multiple bags con FetchType.EAGER
	@ToString.Exclude
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "nif")
	private Set<Estudiante> estudiantes;
	
	
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
	
	
	/**
	 * Añade el estudiante a la lista de estudiantes de este
	 * profesor. Si la operación se completa con éxito retorna cierto,
	 * falso en caso contrario o si el profesor a alcanzado su máximo de estudiantes.
	 * @param estudiante Estudiante a ser añadido
	 * @returns Cierto en caso de éxito.
	 * */
	public boolean addEstudiante(Estudiante estudiante) {
		if (estudiantes.contains(estudiante) || estudiantes.size() > MAX_ESTUDIANTES) {
			return false;
		}
		
		return estudiantes.add(estudiante);
	}
}
