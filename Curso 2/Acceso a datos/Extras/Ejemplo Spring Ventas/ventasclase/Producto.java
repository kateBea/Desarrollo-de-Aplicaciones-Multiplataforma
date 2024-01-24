package com.dam2.ventas.modelo;

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
public class Producto {
	@EqualsAndHashCode.Include
	@Id
	private String referencia;
	private int stock;
	private float pvp;
	private String nombre;
	
	

}
