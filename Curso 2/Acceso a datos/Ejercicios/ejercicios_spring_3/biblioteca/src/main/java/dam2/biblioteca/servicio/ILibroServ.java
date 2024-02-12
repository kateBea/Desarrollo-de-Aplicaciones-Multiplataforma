package dam2.biblioteca.servicio;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dam2.biblioteca.modelo.Libro;

@Service
public interface ILibroServ {
	// Consultar
	Optional<Libro> buscarPorId(String id);
	boolean existePorId(String id);
	
	// Añadir
	Optional<Libro> insertar(Libro libro);
	
	// Modificar
	Optional<Libro> modificar(Libro libro);
	
	// Borrar
	boolean borrarPorId(String id);
}
