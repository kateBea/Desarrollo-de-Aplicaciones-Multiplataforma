package dam2.taller.servicio;

import dam2.taller.modelo.Material;
import dam2.taller.repositorio.IMaterialRepo;
import dam2.taller.repositorio.IPiezaRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MaterialServicioImpl implements  IMaterialServicio {
    @Autowired
    IMaterialRepo materialRepo;

    @Autowired
    IPiezaRepo piezaRepo;

    @Override
    public Optional<Material> buscarPorId(Long id) {
        return materialRepo.findById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return materialRepo.existsById(id);
    }

    @Override
    public Set<Material> buscarTodos() {
        return StreamSupport.stream(materialRepo.findAll().spliterator(), false).
                collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public Optional<Material> insertar(Material nuevo) {
        if (nuevo.getPieza() == null) {
            throw new RuntimeException("Valor de pieza no puede ser nulo");
        }

        if (!piezaRepo.existsById(nuevo.getPieza().getNumRef())) {
            throw new RuntimeException("La pieza con número de referencia adjunta no existe");
        }

        return Optional.of(materialRepo.save(nuevo));
    }

    @Override
    public Optional<Material> actualizar(Material pieza) {
        return Optional.of(materialRepo.save(pieza));
    }

    @Override
    public boolean borrarPorId(Long id) {
        materialRepo.deleteById(id);

        return existePorId(id);
    }
}
