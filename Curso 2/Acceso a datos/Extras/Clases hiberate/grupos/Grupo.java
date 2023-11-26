package org.dam2.grupos;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "GRUPOS")
public class Grupo implements Serializable{
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 6)
	private String id;
	
	private int curso;
	
	@Column(length = 20)
	private String ciclo;
	
	private boolean gradoSuperior;
	
	@Embedded
	private Tutor tutor;
	
	 @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	 @JoinColumn(name = "FK_IDGRUPO")
	 private Set<Alumno> alumnos;
	 
}
