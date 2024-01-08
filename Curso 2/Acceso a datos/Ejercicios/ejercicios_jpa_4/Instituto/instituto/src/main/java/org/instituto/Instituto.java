package org.instituto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

// Lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

//Hibernate
@Entity
@Table(name = "INSTITUTO")

public class Instituto {
	@Column(nullable = false, unique = true)
	private String nombre;
	
	@NonNull
	@EqualsAndHashCode.Include
	@Column(nullable = false)
	@Id
	private String codigo;
	
	@Column(nullable = false, unique = true)
	private String telfefono;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "direccion")
	private Direccion direccion;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "nif")
	private Set<Persona> integrantes;
}
