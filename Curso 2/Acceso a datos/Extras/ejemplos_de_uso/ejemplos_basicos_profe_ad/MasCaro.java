package ejemplos_de_uso.ejemplos_basicos_profe_ad;

import java.util.function.Predicate;

public class MasCaro implements Predicate<Producto> {
	private float valor;
	
	
	public MasCaro(float valor) {

		this.valor = valor;
	}


	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}


	@Override
	public boolean test(Producto t) {
		// TODO Auto-generated method stub
		return t.getPrecio() > valor;
	}

}
