package dam2.taller;

import dam2.taller.modelo.*;
import dam2.taller.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Order(0)
@Component
public class CargarDatos implements CommandLineRunner {
    @Autowired
    @Qualifier("materialServicioImpl")
    IMaterialServicio materialServicio;

    @Autowired
    @Qualifier("trabajoServicioImpl")
    ITrabajoServicio trabajoServ;

    @Autowired
    @Qualifier("asignacionServicioImpl")
    IAsignacionServicio trabajoAsigServ;

    @Autowired
    @Qualifier("mecanicoServicioImpl")
    IMecanicoServicio mecServ;

    @Autowired
    @Qualifier("piezaServicioImpl")
    IPiezaServicio piezaServicio;

    @Override
    public void run(String... args) throws Exception {
        Pieza p1 = Pieza.builder().numRef("123").nombre("pieza1").precioUnidad(12.2f).build();
        Pieza p2 = Pieza.builder().numRef("234").nombre("pieza2").precioUnidad(8.44f).build();

        Set.of(p1, p2).forEach(p -> piezaServicio.insertar(p));
        System.out.println("Piezas insertadas");

        Mecanico mec1 = Mecanico.builder().nickname("alex").contrasena("123").fechaAlta(LocalDate.now()).build();
        Mecanico mec2 = Mecanico.builder().nickname("raul").contrasena("234").fechaAlta(LocalDate.now().minusDays(2)).build();

        Set.of(mec1, mec2).forEach(mec -> mecServ.insertar(mec));
        System.out.println("Mecánicos insertados");

        Trabajo tb1 = Trabajo.builder().descripcion("descripcion1").build();
        Trabajo tb2 = Trabajo.builder().descripcion("descripcion2").build();

        trabajoServ.insertar(tb1);
        trabajoServ.insertar(tb2);

        Material us1 = Material.builder().pieza(p1).cantidad(2).build();
        Material us2 = Material.builder().pieza(p2).cantidad(1).build();

        us1 = materialServicio.insertar(us1).orElse(us1);
        us2 = materialServicio.insertar(us2).orElse(us1);

        Asignacion asig1 = Asignacion.builder().
                estado(Estado.FINALIZADO).
                horasDedicadas(4).
                mecanico(mec2).
                materiales(Set.of()).
                trabajo(tb2).build();

        Material us3 = Material.builder().pieza(p1).cantidad(4).build();
        us3 = materialServicio.insertar(us3).orElse(us3);
        Asignacion asig2 = Asignacion.builder().
                estado(Estado.EN_PROCESO).
                horasDedicadas(2).
                mecanico(mec2).
                materiales(Set.of(us3)).
                trabajo(tb2).build();

        Asignacion asig3 = Asignacion.builder().
                estado(Estado.EN_ESPERA).
                horasDedicadas(0).
                mecanico(null).
                materiales(Set.of()).
                trabajo(tb2).build();

        asig1 = trabajoAsigServ.insertar(asig1).orElse(asig1);
        asig2 = trabajoAsigServ.insertar(asig2).orElse(asig2);
        asig3 = trabajoAsigServ.insertar(asig3).orElse(asig3);
    }
}
