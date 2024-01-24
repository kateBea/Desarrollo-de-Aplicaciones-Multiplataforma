package com.dam2.ventas.servicio;

import java.util.Optional;
import java.util.stream.Stream;

import com.dam2.ventas.modelo.Usuario;
import com.dam2.ventas.modelo.Ventas;

public interface ServicioVentas {
	public Optional<Ventas> insertar(Ventas venta);
	public boolean eliminar (Usuario usuario);
	public Stream<Ventas> obtenerVentas ();

}
