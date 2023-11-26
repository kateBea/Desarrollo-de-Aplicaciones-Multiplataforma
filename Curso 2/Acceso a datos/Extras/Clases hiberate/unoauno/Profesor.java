package org.dam2.unoauno;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Profesor")
public class Profesor implements Serializable  {

    @Id
    private int id;
   
    private String nombre; 
    private String ape1;    
    private String ape2;
    
    
    // Junta todo en una tabla el POJO Profesor y Direccion
    @Embedded
    
    // Activo, hace toda la query de una vez,valor por defecto
    //@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    
    // Perezoso, sólo hace la query cuando lo necesita
    //@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY )
    
    //une las tablas por la PK
    //@PrimaryKeyJoinColumn  
    
    // une las tablas por la columna id de Direccion
    // crea un FK en profesor que referencia a Direccion
    //@JoinColumn(name="idDireccion")
    
    private Direccion direccion;
    

    public Profesor(){ 
    }

    public Profesor(int id, String nombre, String ape1, String ape2) {
        this.id = id;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + ", direccion="
				+ direccion + "]";
	}

	
    
}