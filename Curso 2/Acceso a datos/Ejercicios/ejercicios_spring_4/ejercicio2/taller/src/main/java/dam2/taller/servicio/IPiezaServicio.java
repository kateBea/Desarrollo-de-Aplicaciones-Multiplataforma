package dam2.taller.servicio;

import dam2.taller.modelo.Pieza;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface IPiezaServicio {
    Optional<Pieza> buscarPorId(String numRef);
    boolean existePorId(String numRef);
    Set<Pieza> buscarTodas();

    Optional<Pieza> insertar(Pieza nueva);
    Optional<Pieza> actualizar(Pieza nueva);

    boolean borrarPorId(String numRef);
}
