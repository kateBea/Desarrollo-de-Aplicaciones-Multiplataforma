package ejemplos_de_uso.ejemplos_basicos_profe_ad;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import daw.com.Teclado;

import java.util.ArrayList;
import java.util.Comparator;

public class AppProductos {

	public static void main(String[] args) {
		List<Producto> productos = new ArrayList<>();
		List<Producto> copia;
		Consumer<Producto> mostrar,subirPrecio;
		Predicate<Producto> noPerecedero,masCaro;
		Comparator<Producto> porPrecio;
		float valor, valorFinal;
		
		
		productos.add(new Producto("001",1,true));
		productos.add(new Producto("002",10,false));
		productos.add(new Producto("003",30,true));
		productos.add(new Producto("004",5,false));
		
		copia = new ArrayList<>(productos);
		
		mostrar = new Consumer<Producto>()
				{

					@Override
					public void accept(Producto t) {
						System.out.println(t.getReferencia() + "," + t.getPrecio());
					}
			
				};
				
		noPerecedero = new Predicate<Producto> ()
				{

					@Override
					public boolean test(Producto t) {
						return !t.isPerecedero();
					}
			
				};
			
			porPrecio = new Comparator<Producto> ()
					{

						@Override
						public int compare(Producto o1, Producto o2) {
							return Float.compare(o1.getPrecio(), o2.getPrecio());
						}
				
					};
				
					
			do
			{

				valor = Teclado.leerFloat("valor");
			}while (valor <= 0);
			masCaro = new MasCaro(valor);
					
			productos.forEach(mostrar);
			
			productos.removeIf(noPerecedero.negate());
			productos.removeIf(masCaro.negate());
			productos.sort(porPrecio);
			productos.forEach(mostrar);
			
			((MasCaro)masCaro).setValor(10);
			masCaro = new MasCaro(10);
			productos.removeIf(masCaro);
			
			subirPrecio = new Consumer<Producto>()
					{

						@Override
						public void accept(Producto t) {
							t.setPrecio(t.getPrecio()*1.1f);
						}
				
					};
					
			productos.forEach(subirPrecio);
			productos.forEach(mostrar);

		

	}

}
