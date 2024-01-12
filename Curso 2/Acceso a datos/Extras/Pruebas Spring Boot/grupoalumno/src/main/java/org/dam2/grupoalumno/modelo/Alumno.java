package org.dam2.grupoalumno.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Alumno implements Serializable {
	@EqualsAndHashCode.Include
	@Id
	@Column(length=10)
	private String nia;
	
	@Column(length=40)
	private String nombre;
	
	private LocalDate fechaNacimiento;
	
	@Column(scale = 2)
	private Float nota;
	

}
