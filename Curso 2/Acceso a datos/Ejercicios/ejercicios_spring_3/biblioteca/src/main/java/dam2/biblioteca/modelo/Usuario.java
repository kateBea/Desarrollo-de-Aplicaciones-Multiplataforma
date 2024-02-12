package dam2.biblioteca.modelo;

import java.util.Set;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	@Column(length = 9)
	private String dni;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false, length = 9)
	private String telefono;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "sancion")
	private Set<Sancion> sanciones;
}
