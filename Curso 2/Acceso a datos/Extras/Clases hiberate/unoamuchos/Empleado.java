package org.dam2.unoamuchos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Empleado {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(length=8)
	private String empNo;
	
	@Column(length=30)
	private String apellido;
	
	private LocalDate fechaAlta;
	private float salario;
	
	
}
