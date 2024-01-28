package dam2.repoqueries.app.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "Depart")
public class Departamento {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "coddepto")
	private Integer codigo;
	
	@Column(name = "nombredepto", nullable = false)
	private String nombre;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	
	// Un departamento solo puede tener un director o ninguno
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "coddirector")
	@ToString.Exclude
	private Empleado director;
	
}
