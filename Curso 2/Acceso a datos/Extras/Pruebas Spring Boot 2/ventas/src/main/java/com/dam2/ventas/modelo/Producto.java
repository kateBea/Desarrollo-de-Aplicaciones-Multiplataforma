package com.dam2.ventas.modelo;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "PRODUCTO")

@Component
public class Producto {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "num_venta")
	private String numVenta;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private int stock;
	
	@Column(nullable = false)
	private double pvp;
	
}
