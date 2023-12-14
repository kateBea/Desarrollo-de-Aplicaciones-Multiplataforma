package org.dam2.consultas;

import java.io.Serializable;
import java.time.LocalDate;

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
public class CorreoElectronico implements Serializable {
	 @EqualsAndHashCode.Include
	 @Id
	 private int idCorreo;
	
	 private String direccionCorreo;
	 
	
}
