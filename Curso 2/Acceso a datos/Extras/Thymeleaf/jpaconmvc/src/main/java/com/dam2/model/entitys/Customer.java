package com.dam2.model.entitys;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

@Entity
public class Customer implements Serializable{

	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@NotBlank(message="Debe introducir un nombre")
    private String firstName;
	
	@NotBlank(message="Debe introducir un apellido")
    private String lastName;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past (message="No se admiten fechas futuras")
    private LocalDate fechaNacimiento;


}