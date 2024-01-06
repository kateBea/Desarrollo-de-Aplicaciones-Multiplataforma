package org.instituto;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

//Lombok
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

//Hibernate
@Entity
@Table(name = "ESTUDIANTE")

public class Estudiante extends Persona {
	private String curso;
	private String grupo;
	private TipoEstudio tipoEstudios;
	private boolean delegado;
	
	@ManyToOne
	private Profesor tutor;
}
