package org.dam2.examenspring.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Pieza {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "num_ref")
	private String numRef;
	private String nombre;
	
	@Column(name = "precio_unidad")
	private float precioUnidad;
}
