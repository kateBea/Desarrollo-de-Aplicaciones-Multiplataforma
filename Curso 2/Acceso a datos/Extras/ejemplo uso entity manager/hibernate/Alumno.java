package org.dam2.hibernate;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
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

// Anotaciones Lombok
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@NoArgsConstructor
@AllArgsConstructor

//Anotaciones JPA
@Entity
@Table(name="Alumnos")
public class Alumno implements Serializable{

	@EqualsAndHashCode.Include
	
    @Id
    @Column(name="ID_ALUMNO")
    @GeneratedValue (strategy = GenerationType.TABLE)
    private Integer id;
    
    @Column(name="NOMBRE",length=20)
    private String firstName;
    
   
    @Column(name="FECHA_NACIMIENTO")
    private LocalDate fecha;

      
}