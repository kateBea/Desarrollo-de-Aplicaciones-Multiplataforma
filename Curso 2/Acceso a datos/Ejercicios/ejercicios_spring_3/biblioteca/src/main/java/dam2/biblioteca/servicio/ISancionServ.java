package dam2.biblioteca.servicio;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dam2.biblioteca.modelo.Sancion;

@Service
public interface ISancionServ {
	// Consultar
	Optional<Sancion> buscarPorId(String id);
	boolean existePorId(String id);
	
	// Añadir
	Optional<Sancion> insertar(Sancion sancion);
	
	// Modificar
	Optional<Sancion> modificar(Sancion sancion);
	
	// Borrar
	boolean borrarPorId(String id);
}
