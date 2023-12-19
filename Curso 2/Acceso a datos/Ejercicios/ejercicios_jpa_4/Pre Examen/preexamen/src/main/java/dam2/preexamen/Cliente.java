package dam2.preexamen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

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
@Table(name = "Clientes")
public class Cliente implements Serializable {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column(nullable = false, length = 10)
	private String nif;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private Double maxAvales;
	
	@ToString.Exclude
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "telefono")
	private List<Telefono> telefonos;
	
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
		 name = "ClientesPorCuentas",
		 joinColumns = { @JoinColumn(name = "Cliente", nullable = false) },
		 inverseJoinColumns = { @JoinColumn(name = "Cuenta", nullable = false) }
	)
	private Set<Cuenta> cuentas;
	
	
	// Adecuado no estar aquí
	public static Cliente leer() {		
		final String nif = Input.leerCadena("Introduce el nif: ");
		final String nombre = Input.leerCadena("Introduce el nombre: ");
		final double maxAvales = Input.leerReal("Introduce el valor de avales máximo: ");
		
		final Integer limitTelefonos = Input.leerEntero("Introduce el total de teléfonos: ");
		List<Telefono> telefonos = new ArrayList<>();
		
		if (limitTelefonos != null) {
			for (int count = 0; count < limitTelefonos; ++count) {
				String telf = Input.leerCadena("Número de teléfono: ");
				String comp = Input.leerCadena("Nombre de compaía: ");
				telefonos.add(Telefono.builder().numero(telf).compania(comp).build());
			}
		}
		
		return Cliente.builder().nif(nif).nombre(nombre).maxAvales(maxAvales).telefonos(telefonos).build();
	}
}
