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
import lombok.NonNull;

//Lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

//Hibernate
@Entity
@Table(name = "EMAIL")

public class Email {
	// MIEMBROS PRIVADOS ----------------------------------------
	
	@Column(nullable = false)
	private String tipo;
	
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	private String direccion;
}
