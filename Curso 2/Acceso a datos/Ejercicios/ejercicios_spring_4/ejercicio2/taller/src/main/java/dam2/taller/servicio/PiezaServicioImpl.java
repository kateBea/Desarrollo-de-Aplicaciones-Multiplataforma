package dam2.taller.servicio;

import dam2.taller.modelo.Pieza;
import dam2.taller.repositorio.IPiezaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PiezaServicioImpl implements IPiezaServicio {

    @Autowired
    IPiezaRepo piezaRepo;

    @Override
    public Optional<Pieza> buscarPorId(String numRef) {
        return piezaRepo.findById(numRef);
    }

    @Override
    public boolean existePorId(String id) {
        return piezaRepo.existsById(id);
    }

    @Override
    public Set<Pieza> buscarTodas() {
        return StreamSupport.stream(piezaRepo.findAll().spliterator(), false).
                collect(Collectors.toSet());
    }

    @Override
    public Optional<Pieza> insertar(Pieza nueva) {
        return Optional.of(piezaRepo.save(nueva));
    }

    @Override
    public Optional<Pieza> actualizar(Pieza nueva) {
        return Optional.of(piezaRepo.save(nueva));
    }

    @Override
    public boolean borrarPorId(String numRef) {
        piezaRepo.deleteById(numRef);

        return existePorId(numRef);
    }
}
