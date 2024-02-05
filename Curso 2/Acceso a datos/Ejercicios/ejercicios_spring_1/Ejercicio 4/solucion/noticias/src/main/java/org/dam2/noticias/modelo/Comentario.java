package org.dam2.noticias.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

@Entity
public class Comentario implements Serializable {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// Un usuario puede comentar varias noticias a lo largo del tiempo
	// Una noticia puede ser comentada por varios usuarios a lo largo del tiempo
	// Relación N:M entre usuario y noticia con propiedades:
	// contenido del comentario
	// fecha del comentario
	// valoración del comentario
	
	// Varios comentarios pueden ser hechos por un usuario
	// a lo largo del tiempo
	@ManyToOne (fetch = FetchType.EAGER)
	private Usuario autor;
	
	// Varios comentarios pueden ser hechos sobre una noticia
	// a lo largo del tiempo
	@ManyToOne (fetch = FetchType.EAGER)
	private Noticia noticia;
	
	
	
	@Column (length=120)
	private String contenido;
	
	private int valoracion;
	
	private LocalDate fecha;
	

}
