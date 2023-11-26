package org.dam2.muchosamuchosconpropiedades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.dam2.muchosamuchos.Autor.AutorBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "LIBROS")
@EntityListeners(LibroListener.class)
public class Libro implements Serializable{
	
	@EqualsAndHashCode.Include
	@Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private int id;
    
    @Column(name = "NAME", nullable = false)
    private String name;
    

}
