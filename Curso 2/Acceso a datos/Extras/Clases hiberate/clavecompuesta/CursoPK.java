package org.dam2.clavecompuesta;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.dam2.clavecompuesta.Curso.CursoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Builder
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class CursoPK implements Serializable {
  private String titulo;
  private int nivel;

}
