package dam2.blog.app.modelo;

import java.time.LocalDateTime;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "NOTICIA")
public class Noticia {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column
	private String titulo;
	
	@Column(nullable = false)
	private String cuerpo;
	
	@Column
	private Categoria categoria;
	
	@Column(nullable = false)
	private LocalDateTime fecha;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	Usuario autor;
}
