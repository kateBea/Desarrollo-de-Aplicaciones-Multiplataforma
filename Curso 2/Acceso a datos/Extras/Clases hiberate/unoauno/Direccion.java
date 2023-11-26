package org.dam2.unoauno;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import org.dam2.hibernate.Alumno.AlumnoBuilder;
import org.hibernate.annotations.GenericGenerator;

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
//@Embeddable

public class Direccion implements Serializable {
	
	
	 @EqualsAndHashCode.Include
	 @Id
	 @GeneratedValue (strategy = GenerationType.AUTO)
	 private Integer idDireccion;
	 
	 
	 @Column(name="calle")
	 private String calle;
	 
	 @Column(name="numero")
	 private int numero;
	 
	 @Column(name="poblacion")
	 private String poblacion;
	 
	 @Column(name="provincia")
	 private String provincia;

	 
	 
}
