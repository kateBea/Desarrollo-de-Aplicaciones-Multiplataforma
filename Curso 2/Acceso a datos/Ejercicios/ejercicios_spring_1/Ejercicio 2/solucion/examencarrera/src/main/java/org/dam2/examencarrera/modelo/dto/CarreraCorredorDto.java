package org.dam2.examencarrera.modelo.dto;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

public class CarreraCorredorDto {

	@NonNull
	@EqualsAndHashCode.Include
	private String corredorDni;
	
	@NonNull
	@EqualsAndHashCode.Include
	private String carreraNombre;
	
	private int tiempo;
	private int dorsal;

}
