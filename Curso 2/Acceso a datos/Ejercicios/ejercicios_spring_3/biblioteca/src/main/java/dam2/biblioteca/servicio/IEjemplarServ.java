package dam2.biblioteca.servicio;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.biblioteca.modelo.Ejemplar;

@Service
public interface IEjemplarServ {
	// Consultar
	Optional<Ejemplar> buscarPorId(String id);
	Set<Ejemplar> consultarTodos();
	Set<Ejemplar> ejemplaresDisponibles();
	Set<Ejemplar> ejemplaresDisponiblesDe(String isbn);
 	boolean existePorId(String id);
	
	// Añadir
	Optional<Ejemplar> insertar(Ejemplar ejemplar);
	
	// Modificar
	Optional<Ejemplar> modificar(Ejemplar ejemplar);
	
	// Borrar
	boolean borrarPorId(String id);

}
