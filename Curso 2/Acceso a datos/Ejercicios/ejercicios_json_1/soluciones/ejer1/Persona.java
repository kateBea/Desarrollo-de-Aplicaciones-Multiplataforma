package org.dam2.ejer1;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded=true)


public class Persona {
	@EqualsAndHashCode.Include
	private String nombre;
	private float altura;
	private int peso;
	@Singular
	private List<String> pasatiempos;
	private boolean soltero;
	private Direccion direccion;
	

}
