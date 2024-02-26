package dam2.taller.servicio;

import dam2.taller.modelo.Material;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IMaterialServicio {
    Optional<Material> buscarPorId(Long id);
    boolean existePorId(Long id);
    Set<Material> buscarTodos();

    Optional<Material> insertar(Material nuevo);
    Optional<Material> actualizar(Material nuevo);

    boolean borrarPorId(Long id);
}
