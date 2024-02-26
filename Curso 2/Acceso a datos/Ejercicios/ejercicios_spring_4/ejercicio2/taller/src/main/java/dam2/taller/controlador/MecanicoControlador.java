package dam2.taller.controlador;

import dam2.taller.modelo.Mecanico;
import dam2.taller.servicio.IMecanicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("taller/mecanicos")
public class MecanicoControlador {

    @Autowired
    @Qualifier("mecanicoServicioImpl")
    IMecanicoServicio mecanicoServicio;

    @GetMapping("consultar")
    ResponseEntity<List<Mecanico>> consultarTodos() {
        ResponseEntity<List<Mecanico>> response;

        List<Mecanico> mecanicos = mecanicoServicio.buscarTodos().stream().toList();
        response = ResponseEntity.ok(mecanicos);

        return response;
    }

    @PostMapping("registrar")
    ResponseEntity<Boolean> registrar(@RequestBody Mecanico mecanico) {
        ResponseEntity<Boolean> response = ResponseEntity.badRequest().body(false);

        try {
            Optional<Mecanico> result = mecanicoServicio.insertar(mecanico);
            response = ResponseEntity.ok(true);
        } catch (Exception e) {
            System.err.println("Error al registrar el mecánico: " + e.getMessage());
        }

        return response;
    }

}
