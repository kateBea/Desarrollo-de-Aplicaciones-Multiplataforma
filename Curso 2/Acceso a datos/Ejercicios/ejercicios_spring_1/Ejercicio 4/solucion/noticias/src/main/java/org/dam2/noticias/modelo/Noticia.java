package org.dam2.noticias.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Noticia implements Serializable {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column (length=40)
	private String titulo;
	@Column (length=120)
	private String cuerpo;
	@Enumerated (EnumType.STRING)
	Categoria categoria;
	
	private LocalDate fecha;
	// Varias noticias son escritas por un redactor
	@ManyToOne (fetch = FetchType.EAGER,cascade=CascadeType.PERSIST)
	private Usuario redactor;
	

}
