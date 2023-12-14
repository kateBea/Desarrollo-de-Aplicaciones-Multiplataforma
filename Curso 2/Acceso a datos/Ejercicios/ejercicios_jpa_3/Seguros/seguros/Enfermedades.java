package org.dam2.seguros;

import javax.persistence.Column;
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
public class Enfermedades {
	private boolean corazon;
	private boolean estomacal;
	private boolean riyones;
	private boolean alergia;
	@Column(length=30)
	private String nombreAlergia;

}
