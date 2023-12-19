package dam2.preexamen;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "Cuentas")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract public class Cuenta implements Serializable {
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@Column(nullable = false)
	private String numero;
	
	@Column(nullable = false)
	private Double saldo;
	
	@ToString.Exclude
	// Usa mappedBy (en una de las clases, sin el JoinTable) considerando una de las entidades como fuerte
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
		 name = "CuentasPorClientes",
		 joinColumns = { @JoinColumn(name = "Cuenta", nullable = false) },
		 inverseJoinColumns = { @JoinColumn(name = "Cliente", nullable = false) }
	)
	protected List<Cliente> clientes;
	
	private static final Double SALDO_INICIAL = 0.0;
	
	/**
	 * La cantidad ingresada se incrementa en el saldo de la cuenta.
	 * @param ingreso Cantidad a ser ingresada.
	 * @return El saldo actual si se ha hecho el ingreso, -1 en cualquier otro caso.
	 * */
	public Double ingresar(double ingreso) {
		if (ingreso > 0.0) {
			saldo += ingreso;
			return saldo;
		}
		
		return -1.0;
	}
	
	
	/**
	 * No debe estar aquí, es una consulta puntual que debería
	 * ser parte de la aplicación y no de nuestro.
	 * */
	public boolean esPropietario(String clienteNif) {
		return !clientes.stream()
			.filter(cliente -> cliente.getNif().equalsIgnoreCase(clienteNif))
			.findFirst()
			.isEmpty();
	}
	
	
	/**
	 * La cantidad de dinero solicitado se descuenta del saldo de la cuenta. Si 
	 * la cuenta es personal no se podrá quedar con un saldo negativo inferior a 
	 * la mitad del total de valor máximo de los avales de sus titulares. En el 
	 * caso de tratarse de una cuenta de empresa se permitirá tener un saldo 
	 * negativo de hasta el doble de la suma del valor máximo de los avales de 
	 * sus titulares.
	 * 
	 * @param Cantidad cantidad a retirar
	 * @return -1 si no se ha podido hacer la retirada, el saldo actual en caso contrario.
	 * */
	public abstract double retirar(double cantidad);
	
	
	/**
	 * Transferir dinero de esta cuenta a la destino
	 * @param destino Cuenta destino.
	 * @param cantidad Cantidad a transferir de esta cuenta a la destino.
	 * @return Cierto si la transferencia se realiza con éxito, falso en caso contrario.
	 * */
	public abstract boolean transferir(Cuenta destino, double cantidad);
	
	
	/**
	 * Para leer cuenta desde la entrada estánmdard de datos.
	 * Adecuado no estar aquí. Inutiliza la herencia, la clase padre
	 * es consciente de las clases hijas. No debería estar aquí, hace responsable a
	 * la clase padre de tareas de las especializaciones.
	 * @return Objeto cuenta creado a partir de datos leídos.
	 * */
	public static Cuenta leer(List<Cliente> clientes) {
		final String numero = Input.leerCadena("Introduce el número de cuenta: ");
		final String tipo = Input.leerCadena("Introduce el tipo de cuenta (particular (p) o empresa (e)): ");
		Cuenta result = null;
		
		if (tipo.equalsIgnoreCase("e") || tipo.equalsIgnoreCase("empresa")) {
			// empresa
			final String nombreE = Input.leerCadena("Introduce el nombre de empresa: ");
			final String cifE = Input.leerCadena("Introduce el CIF de empresa: ");
			final LocalEmpresa tipoLocal = LocalEmpresa.fromStr(Input.leerCadena("Introduce el tipo de local de empresa (propio (p) o alquilado (a): "));
			
			result = CuentaEmpresa.builder().numero(numero).saldo(SALDO_INICIAL).nombreEmpresa(nombreE).cifEmpresa(cifE).tipoLocal(tipoLocal).clientes(clientes).build();
		} else {
			// particular
			final String respuesta = Input.leerCadena("¿Tiene tarjeta de crédito? S/n: ");
			final boolean tiene = respuesta.equalsIgnoreCase("S") || respuesta.equalsIgnoreCase("Si");
			
			result = CuentaParticular.builder().numero(numero).saldo(SALDO_INICIAL).tieneTarjetaCredito(tiene).clientes(clientes).build();
		}
		
		return result;
	}
}
