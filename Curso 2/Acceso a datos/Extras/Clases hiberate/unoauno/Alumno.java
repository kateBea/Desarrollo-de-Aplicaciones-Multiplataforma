package org.dam2.unoauno;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
@EntityListeners(AlumnoListener.class)
@Table(name="Alumnos")
public class Alumno implements Serializable{

	@EqualsAndHashCode.Include
	
    @Id
    @Column(name="ID_ALUMNO")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name="nombre",length=20)
    private String firstName;
    
   
    @Column(name="fecha_nacimiento")
    private LocalDate fecha;

    
    
    // Junta todo en una tabla el POJO Alumno y Direccion
    //@Embedded
    
    // Activo, hace toda la query de una vez,valor por defecto
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    
    // Perezoso, sólo hace la query cuando lo necesita
    //@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY )
    
    //une las tablas por la PK
    // Ojo en la insercción hay que hacer igualar las PKs
    // No admite PK generadas
    //@PrimaryKeyJoinColumn 
    
    // une las tablas por la columna id de Direccion
    // crea un FK en Alumno que referencia a Direccion
    @JoinColumn(name="idDireccion")

    private Direccion direccion;
    
    
 
 
    
}