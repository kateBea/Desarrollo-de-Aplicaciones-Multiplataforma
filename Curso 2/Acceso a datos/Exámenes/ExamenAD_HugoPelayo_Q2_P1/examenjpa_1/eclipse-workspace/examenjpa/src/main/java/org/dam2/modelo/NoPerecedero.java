package org.dam2.modelo;


import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PRODUCTO_NO_PERECEDERO")
public class NoPerecedero extends Producto {
	private FormatoProducto formato;
	
	// Sí (true), No (false)
	private Boolean conservarFrio;
}
