package dam2.biblioteca.servicio;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.biblioteca.modelo.Libro;
import dam2.biblioteca.repositorio.IEjemplarRepo;
import dam2.biblioteca.repositorio.ILibroRepo;
import jakarta.transaction.Transactional;

@Service
public class LibroServImpl implements ILibroServ {
	
	@Autowired
	ILibroRepo libroRepo;
	
	@Autowired
	IEjemplarRepo ejemplarRepo;

	@Override
	public Optional<Libro> buscarPorId(String id) {
		// TODO Auto-generated method stub
		return libroRepo.findById(id);
	}

	@Override
	public boolean existePorId(String id) {
		// TODO Auto-generated method stub
		return libroRepo.existsById(id);
	}

	@Override
	public Optional<Libro> insertar(Libro libro) {
		// TODO Auto-generated method stub
		return Optional.of(libroRepo.save(libro));
	}

	@Override
	public Optional<Libro> modificar(Libro libro) {
		// TODO Auto-generated method stub
		return Optional.of(libroRepo.save(libro));
	}

	@Override
	@Transactional
	public boolean borrarPorId(String id) {
		// TODO Auto-generated method stub
		libroRepo.deleteById(id);
		
		// Borrar todos sus ejemplares
		ejemplarRepo.borrarEjemplares(id);
		
		return existePorId(id);
	}

	@Override
	public Set<Libro> consultarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(libroRepo.findAll().spliterator(), false).
			collect(Collectors.toSet());
	}
	
}
