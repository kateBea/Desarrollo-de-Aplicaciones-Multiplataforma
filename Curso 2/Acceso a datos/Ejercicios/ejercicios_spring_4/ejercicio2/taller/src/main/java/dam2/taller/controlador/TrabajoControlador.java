package dam2.taller.controlador;

import dam2.taller.modelo.Asignacion;
import dam2.taller.modelo.Trabajo;
import dam2.taller.servicio.IAsignacionServicio;
import dam2.taller.servicio.ITrabajoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/taller/trabajos")
public class TrabajoControlador {

    @Autowired
    @Qualifier("trabajoServicioImpl")
    ITrabajoServicio trabajoServicio;


    @Autowired
    @Qualifier("asignacionServicioImpl")
    IAsignacionServicio asignacionServicio;

    @GetMapping("consultar")
    ResponseEntity<List<Trabajo>> consultarTodos() {
        ResponseEntity<List<Trabajo>> response;

        List<Trabajo> trabajos = trabajoServicio.buscarTodos().stream().
            toList();
        response = ResponseEntity.ok().body(trabajos);

        return response;
    }

    @PostMapping("registar")
    ResponseEntity<Asignacion> registrar(@RequestParam String desc) {
        ResponseEntity<Asignacion> response;

        System.err.println("User ha enviado descripción: " + desc);

        try {
            Optional<Asignacion> asignacion = Optional.empty();
            Optional<Trabajo> nuevo =
                trabajoServicio.insertar(Trabajo.builder().
                    descripcion(desc).
                    build()
                );

            if (nuevo.isPresent()) {
                asignacion = asignacionServicio.buscarPorTrabajo(nuevo.get().getId());
            }

            response = ResponseEntity.ok().body(asignacion.get());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            response = ResponseEntity.badRequest().body(null);
        }

        return response;

    }
}
