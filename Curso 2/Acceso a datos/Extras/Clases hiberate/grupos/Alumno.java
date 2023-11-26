package org.dam2.grupos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name="ALUMNOS")
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
