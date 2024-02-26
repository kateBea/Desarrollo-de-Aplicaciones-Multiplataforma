package dam2.taller.servicio;

import dam2.taller.modelo.Asignacion;
import dam2.taller.modelo.Estado;
import dam2.taller.modelo.Mecanico;
import dam2.taller.modelo.Trabajo;
import dam2.taller.repositorio.ITrabajoRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TrabajoServicioImpl implements ITrabajoServicio {
    @Autowired
    private ITrabajoRepo trabajoRepo;


    @Autowired
    @Qualifier("mecanicoServicioImpl")
    private IMecanicoServicio mecanicoServ;

    @Autowired
    @Qualifier("asignacionServicioImpl")
    private IAsignacionServicio asignacionServicio;

    @Override
    public Optional<Trabajo> buscarPorId(Long id) {
        if (id == null) {
            return Optional.empty();
        }

        return trabajoRepo.findById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return trabajoRepo.existsById(id);
    }

    @Override
    public Set<Trabajo> buscarTodos() {
        return StreamSupport.stream(trabajoRepo.findAll().spliterator(), false).
                collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public Optional<Trabajo> insertar(Trabajo trabajo) {
        // Se asume que trabajo no es nulo

        trabajo.setFechaRegistro(LocalDate.now());
        Optional<Trabajo> resultado = Optional.of(trabajoRepo.save(trabajo));

        // buscar mecanico libre
        Set<Mecanico> tienenAsignacion =
            asignacionServicio.buscarTodas().stream().
                filter(asignacion -> asignacion.getMecanico() != null &&
                        asignacion.getEstado().equals(Estado.EN_PROCESO)).
                map(Asignacion::getMecanico).
                collect(Collectors.toSet());

        Set<Mecanico> libres = mecanicoServ.buscarTodos();

        if (libres != null) {

            // Quito los que tienen asignación del total
            libres.removeAll(tienenAsignacion);

            Optional<Mecanico> mec;

            // Si solo hay un mecánico lo pillo, si no pillo el que tiene
            // fecha de registro más antigua
            if (libres.size() > 1) {
                mec = libres.stream().
                    min(Comparator.comparing(Mecanico::getFechaAlta));
            } else {
                mec = libres.stream().findFirst();
            }

            Asignacion asign = null;
            Optional<Asignacion> asignacion = Optional.empty();

            if (mec.isPresent()) {
                // Hay mecanico libre
                asign = Asignacion.builder().
                        estado(Estado.EN_PROCESO).
                        horasDedicadas(0).
                        trabajo(trabajo).
                        mecanico(mec.get()).
                        materiales(Set.of()).
                        build();

            } else {
                // No hay mecanico libre
                asign = Asignacion.builder().
                        estado(Estado.EN_ESPERA).
                        horasDedicadas(0).
                        trabajo(trabajo).
                        mecanico(null).
                        materiales(Set.of()).
                        build();

            }

            asignacion = asignacionServicio.insertar(asign);

            if (asignacion.isPresent()) {
                resultado = Optional.of(asignacion.get().getTrabajo());
            }
        }

        return resultado;
    }

    @Override
    public Optional<Trabajo> actualizar(Trabajo trabajo) {
        Optional<Trabajo> result = buscarPorId(trabajo.getId());

        if (result.isEmpty()) {
            throw new RuntimeException("El trabajo con id " + trabajo.getId() + " no existe");
        }

        return Optional.of(trabajoRepo.save(trabajo));
    }

    @Override
    public boolean borrarPorId(Long id) {
        if (id == null) {
            return false;
        }

        trabajoRepo.deleteById(id);

        return existePorId(id);
    }
}
