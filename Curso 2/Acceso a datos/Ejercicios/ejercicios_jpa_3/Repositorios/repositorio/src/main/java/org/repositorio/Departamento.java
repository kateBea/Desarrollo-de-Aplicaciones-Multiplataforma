package org.repositorio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "Depart")
public class Departamento {
	@Id
	@Column(name = "coddepto")
	@EqualsAndHashCode.Include
	private Integer codigo;
	
	@Column(name = "nombredepto", nullable = false)
	private String nombre;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "coddirector")
	@ToString.Exclude
	// Un departamento solo puede tener un director o ninguno
	private Empleado director;
	
}
