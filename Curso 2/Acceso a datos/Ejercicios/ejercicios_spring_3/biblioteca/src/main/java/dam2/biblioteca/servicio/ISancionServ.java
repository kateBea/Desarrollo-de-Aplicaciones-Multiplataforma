package dam2.biblioteca.servicio;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.biblioteca.modelo.Sancion;

@Service
public interface ISancionServ {
	// Consultar
	Optional<Sancion> buscarPorId(String id);
	Set<Sancion> consultarTodas();
	Set<Sancion> consultarTodasDeUsuario(String dni);
	boolean existePorId(String id);
	
	// Añadir
	Optional<Sancion> insertar(Sancion sancion);
	
	// Modificar
	Optional<Sancion> modificar(Sancion sancion);
	
	// Borrar
	boolean borrarPorId(String id);
}
