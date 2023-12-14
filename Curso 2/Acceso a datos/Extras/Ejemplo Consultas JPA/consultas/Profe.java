package org.dam2.consultas;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;



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
/*
@NamedQueries(
		{@NamedQuery(name="findAllProfesores", query="SELECT p FROM Profe p")}
		)
*/

@NamedQuery(name="findAllProfesores", query="SELECT p FROM Profe p")
@NamedQuery(name="findProfeByNombre", query="SELECT p FROM Profe p WHERE p.nombre=?1")
public class Profe implements Serializable {
	
	 @EqualsAndHashCode.Include
	 @Id
	 private int id;
	 private String nombre;
	 private String ape1;
	 private String ape2;
	 
	 
	 @Singular
	 @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	 @JoinColumn(name="IdProfesor")
	 private Set<CorreoElectronico> correosElectronicos;

}
