package org.dam2.gruposalumnosmodulos;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Grupo {
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 10)
	private String nombre;
	
	@Column(length = 10)
	private String ubicacion;
	
	@Singular
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="idGrupo")
	private Set<Alumno> alumnos;
	
	//@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER) //no modificar profesor
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idProfesor")
	private Profesor tutor;
}
