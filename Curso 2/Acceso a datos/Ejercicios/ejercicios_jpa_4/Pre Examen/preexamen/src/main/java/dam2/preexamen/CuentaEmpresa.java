package dam2.preexamen;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
public class CuentaEmpresa extends Cuenta {
	private String nombreEmpresa;
	private String cifEmpresa;
	private LocalEmpresa tipoLocal;
	
	// 1% de la cantidad a transferir
	private static final double COMISION_TRANSFERENCIA = 0.01;
	private static final double MAXIMO_COMISION_TRANSFERENCIA = 6.0;
	
	
	@Override
	public double retirar(double cantidad) {
		double result = -1;
		final double totalAvalesTitulares = clientes.stream().mapToDouble(Cliente::getMaxAvales).sum();
		
		if (Math.abs(cantidad - getSaldo()) > totalAvalesTitulares * 2) {
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
