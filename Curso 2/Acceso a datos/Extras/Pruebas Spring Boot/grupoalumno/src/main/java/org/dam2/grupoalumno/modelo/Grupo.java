package org.dam2.grupoalumno.modelo;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Grupo implements Serializable{
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 6)
	private String id;
	
	private int curso;
	
	@Column(length = 20)
	private String ciclo;
	
	private boolean gradoSuperior;
	

	 @Singular
	 @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	 @JoinColumn(name = "FK_IDGRUPO")
	 private Set<Alumno> alumnos;
	 
}
