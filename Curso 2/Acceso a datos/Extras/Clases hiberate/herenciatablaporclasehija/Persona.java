package org.dam2.herenciatablaporclasehija;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorType;

@SuperBuilder // Usar con herencia en lugar de Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Persona implements Serializable
{

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;
    private String nombre;
    private int edad;

 
}
