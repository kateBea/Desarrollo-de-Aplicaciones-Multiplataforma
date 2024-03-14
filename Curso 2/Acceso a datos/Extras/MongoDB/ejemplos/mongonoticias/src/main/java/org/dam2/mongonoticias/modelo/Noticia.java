package org.dam2.mongonoticias.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

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

@Document
public class Noticia implements Serializable {
	@NonNull
	@EqualsAndHashCode.Include

	@Id
	private long id;

	private String titulo;

	private String cuerpo;

	
	//private LocalDate fecha;
	

	@DBRef
	private Usuario redactor;
	

}
