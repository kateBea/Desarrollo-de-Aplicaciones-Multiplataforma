package ejemplos_de_uso.streams_09_29;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder

public class Alumno implements Comparable<Alumno>{
	@NonNull
	@EqualsAndHashCode.Include
	private String nia;
	
	private String nombre;
	private LocalDate fecha;
	private float nota;
	@Override
	public int compareTo(Alumno arg0) {
		return nia.compareTo(arg0.nia);
	}


}
