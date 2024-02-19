package org.dam2.examenspring.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class TrabajoAsignado {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Estado estado;
	private float horasDedicadas;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	private Mecanico mecanico;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Trabajo trabajo;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<PiezaUsada> piezasUsadas;
}
