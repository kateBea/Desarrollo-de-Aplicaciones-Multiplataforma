package dam2.taller.repositorio;

import dam2.taller.modelo.Asignacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAsignacionRepo extends CrudRepository<Asignacion, Long> {

    @Query("SELECT a FROM Asignacion a WHERE a.trabajo.id = :idTrabajo")
    Optional<Asignacion> findByTrabajoId(@Param("idTrabajo") Long idTrabajo);

}
