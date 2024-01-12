package com.example.demo.modelo;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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


@Entity
public class Cliente implements Serializable {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column (length=10)
	@NotBlank
	private String nif;
	
	
	@Column (length=10)
	@NotBlank
	@Size(max=10, message="Nombre demasiado largo, use iniciales")
	private String nombre;
	
	@Min(value=1000)
	private float aval;
	
	@Singular
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="FK_NIF")
	Set<Contacto> telefonos;
	
	/* bidireccional
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	List<Cuenta> cuentas;
	*/


}
