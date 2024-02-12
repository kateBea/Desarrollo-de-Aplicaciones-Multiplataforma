package dam2.biblioteca.servicio;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.biblioteca.modelo.Prestamo;
import dam2.biblioteca.modelo.Sancion;
import dam2.biblioteca.repositorio.IEjemplarRepo;
import dam2.biblioteca.repositorio.IPrestamoRepo;
import dam2.biblioteca.repositorio.ISancionRepo;
import dam2.biblioteca.repositorio.IUsuarioRepo;
import jakarta.transaction.Transactional;

@Service
public class PrestamoServImpl implements IPrestamoServ {
	
	@Autowired
	IPrestamoRepo prestamoRepo;
	
	@Autowired
	ISancionRepo sancionRepo;
	
	@Autowired
	IUsuarioRepo usuarioRepo;
	
	@Autowired
	IEjemplarRepo ejemplarRepo;

	@Override
	public Optional<Prestamo> buscarPorId(String id) {
		// TODO Auto-generated method stub
		return prestamoRepo.findById(id);
	}

	@Override
	public boolean existePorId(String id) {
		// TODO Auto-generated method stub
		return prestamoRepo.existsById(id);
	}

	@Override
	@Transactional
	public Optional<Prestamo> insertar(Prestamo prestamo) {
		// TODO Auto-generated method stub
		
		// Comprobamos si el usuario existe y está sancionado
		Set<Sancion> sanciones = prestamo.getUsuario().getSanciones();
		final Predicate<Sancion> SANCION_ACTIVA = s -> 
			Period.between(s.getFechaAlta(), LocalDate.now()).getDays() <= s.getDias();
		if (!usuarioRepo.existsById(prestamo.getUsuario().getDni()) || 
				sanciones.stream().anyMatch(SANCION_ACTIVA)) {
			// Lanzar excepción
			return Optional.empty();
		}
		
		// Comprobamos si tiene préstamo pendiente, si tiene al menos uno, denegamos el préstamo
		Set<Prestamo> todos = consultarTodos();
		if (todos.stream().anyMatch(
				p -> p.getUsuario().equals(prestamo.getUsuario()) && !prestamo.isDevuelto())) {
			
			// Lanzar excepción
			return Optional.empty();
		}
		
		prestamo.setFecha(LocalDate.now());
		prestamo.setDevuelto(false);
		
		return Optional.of(prestamoRepo.save(prestamo));
	}

	@Override
	@Transactional
	public Optional<Prestamo> modificar(Prestamo prestamo) {
		// TODO Auto-generated method stub
		
		return Optional.of(prestamoRepo.save(prestamo));
	}
	
	@Override
	@Transactional
	public Optional<Prestamo> hacerDevolucion(Prestamo prestamo) {
		// TODO Auto-generated method stub
		
		// Comprobamos si existe el usuario
		if (!usuarioRepo.existsById(prestamo.getUsuario().getDni())) {
			return Optional.empty();
		}
		
		// Comprobamos la existencia del ejemplar
		if (!ejemplarRepo.existsById(prestamo.getEjemplar().getNumRegistro())) {
			return Optional.empty();
		}
		
		// Sanción si la devolución está fuera de plazo
		if (Period.between(prestamo.getFecha(), LocalDate.now()).getDays() > prestamo.getEjemplar().getDiasPrestamo()) {
			Predicate<Sancion> DE_ESTE_ANIO = s -> s.getFechaAlta().getYear() == LocalDate.now().getYear();
			
			final long sancionesAnioActual = prestamo.getUsuario().getSanciones().stream().filter(DE_ESTE_ANIO).collect(Collectors.counting());
			final int diasPasados = Period.between(prestamo.getFecha(), LocalDate.now()).getDays() - prestamo.getEjemplar().getDiasPrestamo();
			
			Sancion sancion = Sancion.builder().
					dias(Sancion.diasPorSancionesAnuales(sancionesAnioActual, diasPasados)).
					fechaAlta(LocalDate.now()).
					build();
			
			sancionRepo.save(sancion);
			System.err.println("Sanción a usuario " + prestamo.getUsuario().getNombre() + sancion.toString());
		}
		
		return Optional.of(prestamoRepo.save(prestamo));
	}

	@Override
	public boolean borrarPorId(String id) {
		// TODO Auto-generated method stub
		prestamoRepo.deleteById(id);
		
		return existePorId(id);
	}

	@Override
	public Set<Prestamo> consultarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(prestamoRepo.findAll().spliterator(), false).
				collect(Collectors.toSet());
	}

}
