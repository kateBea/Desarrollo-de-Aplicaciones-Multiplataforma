package com.dam2.model.entitys;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate fechaNacimiento;

    public Customer() {
    	id = 0L;
    	firstName = "";
    	lastName ="";
    	fechaNacimiento = LocalDate.now();
    }

    public Customer(String firstName, String lastName, LocalDate fechaNacimiento) {
    	id = 0L;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fechaNacimiento = fechaNacimiento;
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
    
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
    
}