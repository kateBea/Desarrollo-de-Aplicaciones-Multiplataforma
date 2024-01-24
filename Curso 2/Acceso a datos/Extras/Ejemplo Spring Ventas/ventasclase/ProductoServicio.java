package com.dam2.ventas.servicio;

import java.util.Optional;
import java.util.stream.Stream;

import com.dam2.ventas.modelo.Producto;
import com.dam2.ventas.modelo.Usuario;

public interface ProductoServicio {
	public Optional<Producto> insertar (Producto producto);
	public boolean eliminar (Producto producto);
	public Stream<Producto> obtenerProductos ();
	public Optional<Producto> obtenerProducto (String ref);

}
