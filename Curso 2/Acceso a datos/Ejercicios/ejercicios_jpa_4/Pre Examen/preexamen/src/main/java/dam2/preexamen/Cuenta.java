package dam2.preexamen;

import java.io.Serializable;
import java.util.Set;

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
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
		 name = "CuentasPorClientes",
		 joinColumns = { @JoinColumn(name = "Cuenta", nullable = false) },
		 inverseJoinColumns = { @JoinColumn(name = "Cliente", nullable = false) }
	)
	protected Set<Cliente> clientes;
	
	
	/**
	 * La cantidad ingresada se incrementa en el saldo de la cuenta.
	 * */
	public void ingresar(double ingreso) {
		if (ingreso > 0.0) {
			saldo += ingreso;
		}
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
}
