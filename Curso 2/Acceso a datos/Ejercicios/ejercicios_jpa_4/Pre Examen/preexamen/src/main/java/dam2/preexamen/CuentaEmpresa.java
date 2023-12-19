package dam2.preexamen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "CuentasDeEmpresa")
public class CuentaEmpresa extends Cuenta {
	@Column(nullable = false)
	private String nombreEmpresa;
	
	@Column(nullable = false)
	private String cifEmpresa;
	
	@Enumerated(EnumType.STRING)
	private LocalEmpresa tipoLocal;
	
	// 1% de la cantidad a transferir
	private static final double COMISION_TRANSFERENCIA = 0.001;
	private static final double MAXIMO_COMISION_TRANSFERENCIA = 6.0;
	
	
	@Override
	public double retirar(double cantidad) {
		double result = -1;
		final double totalAvalesTitulares = clientes.stream().mapToDouble(Cliente::getMaxAvales).sum();
		
		if (Math.abs(getSaldo() - cantidad) > totalAvalesTitulares * 2) {
			setSaldo(getSaldo() - cantidad);
		}
		
		return result;
	}
	
	
	@Override
	public boolean transferir(Cuenta destino, double cantidad) {
		if (cantidad < 0.0) {
			return false;
		}
		
		final double comision = COMISION_TRANSFERENCIA * cantidad;	
		final double transferencia = comision > MAXIMO_COMISION_TRANSFERENCIA ?
			cantidad - MAXIMO_COMISION_TRANSFERENCIA :
			cantidad - comision;
		
		setSaldo(getSaldo() - transferencia);
		destino.setSaldo(getSaldo() + transferencia);
		
		return true;
	}
}
