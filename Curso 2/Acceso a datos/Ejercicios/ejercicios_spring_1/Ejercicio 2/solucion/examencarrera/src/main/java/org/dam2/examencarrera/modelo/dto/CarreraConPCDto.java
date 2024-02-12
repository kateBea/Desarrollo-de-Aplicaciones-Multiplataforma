package org.dam2.examencarrera.modelo.dto;

import java.time.LocalDate;
import java.util.List;

import org.dam2.examencarrera.modelo.entidad.PuntoControl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class CarreraConPCDto {
	@NonNull
	@EqualsAndHashCode.Include
	private String nombre;
	private int maximo;
	private LocalDate fecha;
	
	@Singular
	private List<PuntoControlDto> pcs;

}
