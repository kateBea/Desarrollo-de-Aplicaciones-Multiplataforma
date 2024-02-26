package dam2.taller.servicio;

import dam2.taller.modelo.Mecanico;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IMecanicoServicio {
    Optional<Mecanico> buscarPorId(String nickname);
    boolean existePorId(String nickname);
    Set<Mecanico> buscarTodos();

    Optional<Mecanico> insertar(Mecanico nuevo);
    Optional<Mecanico> actualizar(Mecanico nuevo);

    boolean borrarPorId(String nickname);
}
