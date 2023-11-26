package org.dam2.grupos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.dam2.unoamuchos.Empleado;

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

@Embeddable
public class Tutor implements Serializable {
	@EqualsAndHashCode.Include
	@Column(length = 10,unique = true,nullable = false)
	private String dni;
	@Column(length = 10)
	private String nombre;
	@Column(scale = 2)
	private float sueldo;

}
