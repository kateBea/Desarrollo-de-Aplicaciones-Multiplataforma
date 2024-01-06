package org.instituto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// Lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

// Hibernate
@Entity
@Table(name = "DIRECCION")

public class Direccion {
	// Las calles vienen identificadas por su nombre, poblacion y CP.
	// Podríamos tener calles con mismo nombre en poblaciones diferentes.
	
	@Id
	@Column
	private String calle;
	
	@Id
	@Column
	private String poblacion;
	
	@Column(nullable = false)
	private String cp;
}
