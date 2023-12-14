package org.dam2.seguros;


import java.time.LocalDateTime;

import javax.persistence.Entity;
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


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded=true)

@Entity
public class AsistenciaMedica {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAsistenciaMedica;
	private String breveDescripcion;
	private String lugar;
	private String explicacion;
	private String tipoAsistencia;
	private LocalDateTime fechaYHora;
	private float importe;
	
	/*
	@ManyToOne
	@JoinColumn (name = "FK_SEGURO")
	private Seguro seguro;
	*/

}
