package dam2.pruebalombbok;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

public class Alumno {
	@NonNull
	@EqualsAndHashCode.Include
	private String nia;
	
	private String nombre;
	private LocalDate fecha;
	private float nota;
}
