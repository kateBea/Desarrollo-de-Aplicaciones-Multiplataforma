package dam2.taller.servicio;

import dam2.taller.modelo.Asignacion;
import dam2.taller.modelo.Material;
import dam2.taller.repositorio.IAsignacionRepo;
import dam2.taller.repositorio.IMaterialRepo;
import dam2.taller.repositorio.IMecanicoRepo;
import dam2.taller.repositorio.ITrabajoRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AsignacionServicioImpl implements  IAsignacionServicio {
    @Autowired
    IAsignacionRepo trabajoAsigRepo;

    @Autowired
    ITrabajoRepo trabajoRepo;

    @Autowired
    IMecanicoRepo mecanicoRepo;

    @Autowired
    IMaterialRepo piezaUsadaRepo;

    @Override
    public Optional<Asignacion> buscarPorId(Long id) {
        if (id == null) {
            return Optional.empty();
        }

        return trabajoAsigRepo.findById(id);
    }

    @Override
    public Optional<Asignacion> buscarPorTrabajo(Long idTrabajo) {
        return trabajoAsigRepo.findByTrabajoId(idTrabajo);
    }

    @Override
    public boolean existePorId(Long id) {
        if (id == null) {
            return false;
        }

        return trabajoAsigRepo.existsById(id);
    }

    @Override
    public Set<Asignacion> buscarTodas() {
        return StreamSupport.stream(trabajoAsigRepo.findAll().spliterator(), false).
                collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public Optional<Asignacion> insertar(Asignacion nueva) {
        if (nueva.getMecanico() != null && !mecanicoRepo.existsById(nueva.getMecanico().getNickname())) {
            mecanicoRepo.save(nueva.getMecanico());
        }

        if (nueva.getTrabajo() != null &&
                nueva.getTrabajo().getId() != null &&
                !trabajoRepo.existsById(nueva.getTrabajo().getId())) {
            trabajoRepo.save(nueva.getTrabajo());
        }

        if (nueva.getMateriales() != null) {
            for (Material pieza : nueva.getMateriales()) {
                if (pieza.getId() == null || !piezaUsadaRepo.existsById(pieza.getId())) {
                    piezaUsadaRepo.save(pieza);
                }
            }
        }

        return Optional.of(trabajoAsigRepo.save(nueva));
    }

    @Override
    public Optional<Asignacion> actualizar(Asignacion nueva) {
        return Optional.of(trabajoAsigRepo.save(nueva));
    }

    @Override
    public boolean borrarPorId(Long id) {
        if (id == null) {
            return false;
        }

        trabajoAsigRepo.deleteById(id);

        return existePorId(id);
    }
}
