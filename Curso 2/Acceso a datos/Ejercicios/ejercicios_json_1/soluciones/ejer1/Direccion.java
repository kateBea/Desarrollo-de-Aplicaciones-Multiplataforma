package org.dam2.ejer1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder


public class Direccion {
	private String calle;
	private String numero;
	private String pais;

}
