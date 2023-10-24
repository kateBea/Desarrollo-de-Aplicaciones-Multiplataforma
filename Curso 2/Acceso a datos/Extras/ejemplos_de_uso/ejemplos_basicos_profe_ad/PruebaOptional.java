package ejemplos_de_uso.ejemplos_basicos_profe_ad;

import java.util.Optional;

import java.util.function.Consumer;

public class PruebaOptional {

	public static void main(String[] args) {
		Optional<Producto> p1,p2;
		
		p1 = Optional.empty();
		p2 = Optional.of(new Producto("001", 1, true));
		Consumer<Producto> mostrar = new Consumer<Producto> ()
				{

					@Override
					public void accept(Producto t) {
						System.out.println(t);
					}
			
				};
		
		
		p1.ifPresent(mostrar);
		p2.ifPresent(mostrar);
		

	}

}
