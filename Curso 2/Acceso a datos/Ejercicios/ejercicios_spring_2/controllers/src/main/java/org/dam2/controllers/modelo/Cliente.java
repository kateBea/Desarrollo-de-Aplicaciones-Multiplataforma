package org.dam2.controllers.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Cliente {	
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	private String nif;
	private String nombre;
	private float aval;
}
