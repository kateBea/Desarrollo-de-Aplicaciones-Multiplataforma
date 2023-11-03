package org.dam2.ejer2;

import java.time.LocalDateTime;
import java.util.List;



import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
public class Curso {
	@EqualsAndHashCode.Include
	@SerializedName("$id")
	private String id;
	@SerializedName("MCER")
	private String mcer;
	@SerializedName("Nivel")
	private String nivel;
	@SerializedName("ID")
	private String idCurso;
	@SerializedName("Titulo")
	private String titulo;
	@SerializedName("Horario")
	private String horario;
	@SerializedName("InicioImparticion")
	private LocalDateTime inicioImparticion;
	@SerializedName("FinImparticion")
	private LocalDateTime finImparticion;
	@SerializedName("Horas")
	private int horas;
	@SerializedName("URL")
	private String url;
	@SerializedName("TipoFormacion")
	private TipoFormacion tipoFormacion;
	@SerializedName("ECTS")
	private String ects;
	@SerializedName("Categoria")
	private String categoria;
	@SerializedName("Profesorado")
	@Singular
	private List<Profesor> profesores;
	
}

