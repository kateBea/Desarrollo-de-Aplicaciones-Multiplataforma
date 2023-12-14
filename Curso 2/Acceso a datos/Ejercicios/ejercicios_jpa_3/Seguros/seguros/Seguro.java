package org.dam2.seguros;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded=true)

@Entity
public class Seguro {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSeguro;
	
	@Column(unique=true,length=9)
	private String nif;
	private String nombre;
	private String ape1;
	private String ape2;
	
	private int edad;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	private boolean casado;
	private int nunHijos;
	private boolean embarazada;
	@Embedded
	private Coberturas coberturas;
	
	@Embedded
	private Enfermedades enfermedades;
	
	private LocalDate fechaCreacion;
	
	@Singular
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="IDSEGURO_FK")
	List<AsistenciaMedica> asistencias;
	
}
