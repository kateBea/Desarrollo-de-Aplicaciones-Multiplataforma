package dam2.taller.servicio;

import dam2.taller.modelo.Asignacion;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IAsignacionServicio {
    Optional<Asignacion> buscarPorId(Long id);
    Optional<Asignacion> buscarPorTrabajo(Long idTrabajo);
    boolean existePorId(Long id);
    Set<Asignacion> buscarTodas();

    Optional<Asignacion> insertar(Asignacion nueva);
    Optional<Asignacion> actualizar(Asignacion nueva);

    boolean borrarPorId(Long id);
}
