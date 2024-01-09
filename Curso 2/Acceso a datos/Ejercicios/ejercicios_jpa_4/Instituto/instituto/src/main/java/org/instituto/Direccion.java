package org.instituto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
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
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	@Column(nullable = false)
	private String cp;
	
	@NonNull
	@Column(nullable = false)
	private String poblacion;
	
	@NonNull
	@Column(nullable = false)
	private String calle;
}
