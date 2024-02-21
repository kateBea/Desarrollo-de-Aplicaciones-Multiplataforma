package dam2.biblioteca.repositorio;

import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dam2.biblioteca.modelo.Ejemplar;

@Repository
public interface IEjemplarRepo extends CrudRepository<Ejemplar, String>{
	
	@Modifying
	@Query("DELETE FROM Ejemplar e WHERE e.libro.isbn = :idLirbo")
	public void borrarEjemplares(@Param("idLirbo") String idLibro);
	
	@Query("SELECT e FROM Ejemplar e WHERE e.libro.isbn NOT IN (SELECT p.ejemplar.libro.isbn FROM Prestamo p WHERE p.devuelto <> true)")
	Set<Ejemplar> ejemplaresLibres();
	
	@Query("SELECT e FROM Ejemplar e WHERE e.libro.isbn = :isbn AND "
			+ "e.libro.isbn NOT IN (SELECT p.ejemplar.libro.isbn FROM "
			+ "Prestamo p WHERE p.devuelto <> true)")
	Set<Ejemplar> ejemplaresLibresLibro(@Param("isbn") String isbn);
}
