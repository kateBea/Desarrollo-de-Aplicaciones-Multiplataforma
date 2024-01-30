package dam2.blog.app.modelo;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "USUARIO")
public class Usuario {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column
	private String nicknane;
	
	@Column(nullable = false)
	private String password;
	
	@Column
	private int puntos;
	
	public void redactar(Noticia noticia) {
		puntos += 
			switch (noticia.getCategoria()) {
				case DEPORTES -> 1;
				case POLITICA -> 2;
				case ECONOMIA -> 3;
				default -> 0;
			};
			
		noticia.setAutor(this);
	}
}
