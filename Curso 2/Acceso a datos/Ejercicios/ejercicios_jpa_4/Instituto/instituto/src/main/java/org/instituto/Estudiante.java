package org.instituto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
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
@Table(name = "ESTUDIANTE")

public class Estudiante extends Persona {
	// MIEMBROS PRIVADOS ----------------------------------------
	
	@Column(nullable = false)
	private String curso;
	
	@Column(nullable = false)
	private String grupo;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoEstudio tipoEstudios;
	
	@Column(nullable = false)
	private boolean delegado;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Profesor tutor;	
}
