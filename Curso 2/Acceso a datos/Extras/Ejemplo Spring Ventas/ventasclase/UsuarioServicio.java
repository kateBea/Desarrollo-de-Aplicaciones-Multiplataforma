package com.dam2.ventas.servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.dam2.ventas.modelo.Usuario;
import com.dam2.ventas.repositorio.NombreYSaldo;

public interface UsuarioServicio {
	public Optional<Usuario> insertar (Usuario usuario);
	public boolean eliminar (Usuario usuario);
	public Stream<Usuario> obtenerUsuarios ();
	public List<Usuario> obtenerUsuariosPorNombre (String nombre);
	public List<NombreYSaldo> obtenerSaldos (String nombre, float saldo);
	public Integer actualizarSaldos ();

}
