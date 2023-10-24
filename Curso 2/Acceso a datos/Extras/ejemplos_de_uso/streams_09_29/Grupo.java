package ejemplos_de_uso.streams_09_29;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;


@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Grupo {
	@NonNull
	@EqualsAndHashCode.Include
	private String nombre;
	private String tutor;
	@Singular
	private List<Alumno> alumnos;
	
	
	public boolean addAlumno (Alumno alumno)
	{
		List<Alumno> copia;
		
		if (alumnos != null)
		{
			copia = new ArrayList<>(alumnos);
			alumnos = copia;
		}
		else
			alumnos = new ArrayList<>();
		
		return alumnos.add(alumno);
	}

}
