package org.dam2.clavecompuesta;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode

@Embeddable
public class CalificacionPK implements Serializable{
	//@MapsId("idmodulo")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idmodulo")
	private Modulo modulo;
	
	
	//@MapsId("idalumno")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idalumno")
	private Alumno alumno;

}
