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

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "USUARIO")

@Component
public class Usuario {
	@EqualsAndHashCode.Include
	@Id
	private String nif;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private double saldo;
}
