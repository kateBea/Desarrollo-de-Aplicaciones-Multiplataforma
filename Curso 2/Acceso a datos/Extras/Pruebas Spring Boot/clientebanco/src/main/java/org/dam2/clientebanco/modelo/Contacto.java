package org.dam2.clientebanco.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@NoArgsConstructor
@RequiredArgsConstructor
@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


@Entity
public class Contacto implements Serializable {
	@EqualsAndHashCode.Include
	@NonNull
	@Id
	@Column (length=10)
	private String telefono;
	
	@Column (length=20)
	private String proveedor;

}
