package dam2.ejercicio;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

// Hibernate
@Entity
@Table(name = "Clientes")
public class Cliente {
	@Id
	@Column(name = "DNI", length=9)
	private String dni;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "FECHA_NACIMIENTO")
	private LocalDate fechaNacimiento;
	
	@Column(name = "SALDO", scale=2)
	private float saldo;
	
	@Column(name = "AVAL")
	private boolean aval;
}
