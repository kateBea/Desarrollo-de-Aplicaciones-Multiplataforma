package dam2.taller.servicio;

import dam2.taller.modelo.Mecanico;
import dam2.taller.repositorio.IMecanicoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MecanicoServicioImpl implements IMecanicoServicio {
    @Autowired
    IMecanicoRepo mecanicoRepo;

    @Override
    public Optional<Mecanico> buscarPorId(String nickname) {
        return mecanicoRepo.findById(nickname);
    }

    @Override
    public boolean existePorId(String nickname) {
        return mecanicoRepo.existsById(nickname);
    }

    @Override
    public Set<Mecanico> buscarTodos() {
        return StreamSupport.stream(mecanicoRepo.findAll().spliterator(), false).
                collect(Collectors.toSet());
    }

    @Override
    public Optional<Mecanico> insertar(Mecanico mecanico) {
        mecanico.setFechaAlta(LocalDate.now());
        return Optional.of(mecanicoRepo.save(mecanico));
    }

    @Override
    public Optional<Mecanico> actualizar(Mecanico mecanico) {
        return Optional.of(mecanicoRepo.save(mecanico));
    }

    @Override
    public boolean borrarPorId(String nickname) {
        mecanicoRepo.deleteById(nickname);

        return existePorId(nickname);
    }
}
