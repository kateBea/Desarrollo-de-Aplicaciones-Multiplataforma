package org.repositorio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "Emple")
public class Empleado {
	private Integer id;
	private String nomnbre;
	private Sexo sexo;
	private LocalDate fechaNacimiento;
	private LocalDate fechaIncorporacion;
	private float saldo;
	private float comision;
	private float cargo;
	
	// Uno a uno (reflexiva) opcional
	private Empleado jefe;
	
	// Uno a uno obligatoria
	private Departamento departamento;
}
