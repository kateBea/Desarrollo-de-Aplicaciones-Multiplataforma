package dam2.biblioteca.servicio;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.biblioteca.modelo.Usuario;

@Service
public interface IUsuarioServ {
	// Consultar
	Optional<Usuario> buscarPorId(String id);
	Set<Usuario> consultarTodos();
	boolean existePorId(String id);
	
	// Añadir
	Optional<Usuario> insertar(Usuario usuario);
	
	// Modificar
	Optional<Usuario> modificar(Usuario usuario);
	
	// Borrar
	boolean borrarPorId(String id);
}
