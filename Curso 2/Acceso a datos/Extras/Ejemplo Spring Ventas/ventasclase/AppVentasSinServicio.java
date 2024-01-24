package com.dam2.ventas;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dam2.ventas.modelo.Producto;
import com.dam2.ventas.modelo.Usuario;
import com.dam2.ventas.modelo.Ventas;
import com.dam2.ventas.repositorio.UsuarioRepositorio;
import com.dam2.ventas.servicio.ProductoServicio;
import com.dam2.ventas.servicio.ServicioVentas;
import com.dam2.ventas.servicio.UsuarioServicio;

import daw.com.Teclado;

@Component
public class AppVentasSinServicio implements CommandLineRunner {
	
	@Autowired
	UsuarioServicio usuarioServicio;
	@Autowired 
	ProductoServicio productoServicio;
	@Autowired
	ServicioVentas ventasServicio;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Usuario usuario = Usuario.builder().
						nif("001").
						nombre("usu1").
						saldo(1000).
						build();
		
		usuarioServicio.insertar(usuario);
		usuarioServicio.obtenerUsuarios().forEach(System.out::println);
		Producto p = Producto.builder().
						referencia("001").
						nombre("producto1").
						stock(10).
						pvp(20).
						build();
		productoServicio.insertar(p);
		
		insertarVenta();
		
		
		
	}
	private void insertarVenta() {
		// TODO Auto-generated method stub

		String ref, nif;
		Optional<Producto> p;
		int unidades;
		Usuario usuario = Usuario.builder().
				nif("001").build();
		
		do {
			ref = Teclado.leerString("referencia");
			
			p = productoServicio.obtenerProducto(ref);
		}while (p.isEmpty());
		
		do {
			unidades = Teclado.leerInt("unidades");
		}while (unidades< p.get().getStock());
		
		Ventas v = Ventas.builder().
				producto(p.get()).
				usuario(usuario).
				fecha(LocalDate.now()).
				unidades(5).build();
		
		ventasServicio.insertar(v);
		
	}	

}

	
