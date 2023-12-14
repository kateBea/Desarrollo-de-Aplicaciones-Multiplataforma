package org.dam2.seguros;



import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Coberturas {
	private boolean oftalmologia;
	private boolean dental;
	private boolean fecundacionInVitro;

}
