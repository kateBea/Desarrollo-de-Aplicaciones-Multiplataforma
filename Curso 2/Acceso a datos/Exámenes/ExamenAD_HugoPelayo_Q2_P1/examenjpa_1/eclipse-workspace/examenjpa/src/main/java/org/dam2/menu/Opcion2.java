package org.dam2.menu;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.dam2.examenjpa.Contexto;
import org.dam2.modelo.Cliente;
import org.dam2.modelo.Producto;
import org.dam2.modelo.Venta;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Opcion2 extends OpcionMenu {

	@Override
	public void accion() {
		final String nifCliente = daw.com.Teclado.leerString("NIF cliente: ");
		
		Optional<Cliente> cliente = Contexto.getDaoCliente().findById(nifCliente);
		
		if (cliente.isEmpty()) {
			System.err.println("El cliente no existe");
			return;
		}
		
		List<Producto> productos = Contexto.getDaoProducto().findAll();
		
		System.out.println("Productos:");
		productos.stream().
			filter(prod -> prod.getStock() > prod.getUnidadesPorPedido()).
			forEach(System.out::println);
		
		final String ref = daw.com.Teclado.leerString("Referencia:");
		final int cantidad = daw.com.Teclado.leerInt("Cantidad:");
		
		Optional<Producto> producto = productos.stream().
			filter(prod -> prod.getNumReferencia().equals(ref)).
			findFirst();
	
		if (producto.isPresent() && cantidad <= producto.get().getStock()) {
			producto.get().setStock(producto.get().getStock() - cantidad);
			
			// Registramos la venta
			Contexto.getDaoVenta().save(
				Venta.builder().
					cliente(cliente.get()).
					fecha(LocalDate.now()).
					producto(producto.get()).
					build()
			);			
		} else {
			System.err.println("Error al realizar la venta");
		}
	}

}
