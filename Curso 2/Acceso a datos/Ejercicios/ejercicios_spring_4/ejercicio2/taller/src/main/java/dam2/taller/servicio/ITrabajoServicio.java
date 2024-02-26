package dam2.taller.servicio;

import dam2.taller.modelo.Trabajo;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface ITrabajoServicio {
    Optional<Trabajo> buscarPorId(Long id);
    boolean existePorId(Long id);
    Set<Trabajo> buscarTodos();

    Optional<Trabajo> insertar(Trabajo nuevo);
    Optional<Trabajo> actualizar(Trabajo nuevo);

    boolean borrarPorId(Long id);
}
