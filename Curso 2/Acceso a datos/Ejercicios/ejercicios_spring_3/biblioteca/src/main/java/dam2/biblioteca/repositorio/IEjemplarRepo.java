package dam2.biblioteca.repositorio;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dam2.biblioteca.modelo.Ejemplar;

@Repository
public interface IEjemplarRepo extends CrudRepository<Ejemplar, String>{
	
	@Query("DELETE FROM Ejemplar e WHERE e.libro.isbn = :idLirbo")
	@Modifying
	public void borrarEjemplares(@Param("idLirbo") String idLibro);
}
