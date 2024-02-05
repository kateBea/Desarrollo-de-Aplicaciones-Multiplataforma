package org.dam2.noticias.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

@Entity
public class Usuario implements Serializable {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column (length=10)
	private String nickname;
	@Column (length=8)
	private String password;
	private int puntos;
	
	public void aumentarPuntos (int puntos)
	{
		if (puntos >0)
			this.puntos += puntos;
	}
	

}
