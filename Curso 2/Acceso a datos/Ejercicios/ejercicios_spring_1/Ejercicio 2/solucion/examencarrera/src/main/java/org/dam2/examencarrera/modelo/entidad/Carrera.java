package org.dam2.examencarrera.modelo.entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

@Entity
public class Carrera implements Serializable {

	@NonNull
	@EqualsAndHashCode.Include
	@Id
	private String nombre;
	private int maximo;
	private LocalDate fecha;
	
	@OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Singular
	private List<PuntoControl> pcs;

}
