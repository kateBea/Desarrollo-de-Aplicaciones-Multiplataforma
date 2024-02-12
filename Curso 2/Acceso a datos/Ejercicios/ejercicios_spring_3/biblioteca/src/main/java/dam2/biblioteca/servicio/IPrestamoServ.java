package dam2.biblioteca.servicio;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.biblioteca.modelo.Prestamo;

@Service
public interface IPrestamoServ {
	// Consultar
	Optional<Prestamo> buscarPorId(String id);
	Set<Prestamo> consultarTodos();
	boolean existePorId(String id);
	
	// Añadir
	Optional<Prestamo> insertar(Prestamo prestamo);
	
	// Modificar
	Optional<Prestamo> modificar(Prestamo prestamo);
	Optional<Prestamo> hacerDevolucion(Prestamo prestamo);
	
	// Borrar
	boolean borrarPorId(String id);
}
