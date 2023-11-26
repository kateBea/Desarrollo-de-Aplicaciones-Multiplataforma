package org.dam2.clavecompuesta;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.dam2.unoauno.Alumno;
import org.dam2.unoauno.Direccion;
import org.dam2.unoauno.Alumno.AlumnoBuilder;

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
public class Curso implements Serializable {

  @EqualsAndHashCode.Include
  @EmbeddedId
  private CursoPK cursoPK;

  private String categoria;
  private int horas;

 
}
