package org.dam2.muchosamuchosconpropiedades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.dam2.unoamuchos.Depart;
import org.dam2.unoamuchos.Empleado;
import org.dam2.unoamuchos.Depart.DepartBuilder;

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
@Table(name="AUTORES")
public class Autor implements Serializable{
	
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "ID")
	//@GeneratedValue
	private int id;


	@Column(name = "NAME", nullable = false)
	private String name;

}
