package org.repositorio;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "Emple")
public class Empleado {
	@Id
	@Column(name = "nidemp")
	@NonNull
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Column(name = "nomemp", nullable = false)
	private String nombre;
	
	@Column(name = "sexemp", nullable = false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column(name = "fecnac", nullable = false)
	private LocalDate fechaNacimiento;
	
	@Column(name = "fecincorporacion", nullable = false)
	private LocalDate fechaIncorporacion;
	
	@Column(name = "salemp", nullable = false)
	private float salario;
	
	@Column(name = "comisione", nullable = false)
	private float comision;
	
	@Column(name = "cargoe", nullable = false)
	private String cargo;
	
	// Uno a uno (reflexiva) opcional
	// Un empleado puede o no tener jefe
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "jefeid")
	private Empleado jefe;
	
	// Uno a uno obligatoria
	// No existen empleados sin departamento
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "coddepto", nullable = false)
	private Departamento departamento;
}
