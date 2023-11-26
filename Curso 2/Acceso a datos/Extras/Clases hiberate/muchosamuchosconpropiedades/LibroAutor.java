package org.dam2.muchosamuchosconpropiedades;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
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

@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class LibroAutor implements Serializable {
	
	@EqualsAndHashCode.Include
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	//@ManyToOne (cascade = CascadeType.ALL, fetch=FetchType.EAGER) 
	@ManyToOne (fetch=FetchType.EAGER)
	private Libro libro;
	
	@ManyToOne (cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Autor autor;
	
	private int ncapitulos;
}
