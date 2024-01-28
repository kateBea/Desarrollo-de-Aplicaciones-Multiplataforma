package dam2.repoqueries.app.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "Emple")
public class Empleado {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "nidemp")
	private Integer id;
	
	@Column(name = "nomemp", nullable = false)
	private String nombre;
	
	@Column(name = "sexemp", nullable = false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column(name = "fecnac", nullable = false)
	private LocalDate fechaNacimiento;
	
	@Column(name = "fecincorporacion", nullable = false)
	private LocalDate fechaIncorporacion;
	
	@Column(name = "salemp", nullable = false)
	private float salario;
	
	@Column(name = "comisione", nullable = false)
	private float comision;
	
	@Column(name = "cargoe", nullable = false)
	private String cargo;
	
	
	// Un empleado puede ser jefe de varios empleados
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "jefeid")
	private Empleado jefe;
	
	// Varios empleados pueden estar en el mismo departamento
	// No puede existir empleado sin un departamento asignado
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "coddepto", nullable = false)
	private Departamento departamento;
}
