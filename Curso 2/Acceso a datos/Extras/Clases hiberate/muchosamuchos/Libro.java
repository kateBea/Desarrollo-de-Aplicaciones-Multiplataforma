package org.dam2.muchosamuchos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Libro implements Serializable{
	
	@EqualsAndHashCode.Include
	@Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private int id;
    
    @Column(name = "NAME", nullable = false)
    private String name;
    
    
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER) // Relación perezosa por defecto
    // Tabla relación libros autores
    
    @JoinTable(
        name = "REL_LIBROS_AUTORES",
        joinColumns = {@JoinColumn(name = "FK_BOOK", nullable = false)},
        inverseJoinColumns = {@JoinColumn(name="FK_AUTHOR", nullable = false)}
    )
    
    @Singular
    private Set<Autor> autores;
   
    
   
	@Override
	public String toString() {
		return "Libro [id=" + id + ", name=" + name + 
				", autores=[" + autores.stream().map(Autor::getName).collect(Collectors.joining(","))+  "]]";
	}

    

}
