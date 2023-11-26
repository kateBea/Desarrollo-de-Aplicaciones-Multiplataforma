package org.dam2.gruposalumnosmodulos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@EntityListeners(CalificacionListener.class)// Trigger para comprobar nota
public class Calificacion {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	// propiedad de la relación alumno-modulo
	private Integer nota;

	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER) // ojo cascade 
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idModulo")
	private Modulo modulo;
	
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idAlumno")
	private Alumno alumno;


}
