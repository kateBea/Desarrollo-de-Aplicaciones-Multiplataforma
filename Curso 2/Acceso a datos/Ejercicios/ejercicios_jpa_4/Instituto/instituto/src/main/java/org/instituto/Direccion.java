package org.instituto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

// Lombok
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()

// Hibernate
@Entity
@Table(name = "DIRECCION")

public class Direccion {
	// En cada población, una dirección concreto 
	// le corresponde un CP único
	
	// MIEMBROS PRIVADOS ----------------------------------------
	
	@NonNull
	@Id
	@Column
	private String cp;
	
	@NonNull
	@Column(nullable = false, unique = true)
	private String poblacion;
	
	@Column(nullable = false)
	private String calle;
}
