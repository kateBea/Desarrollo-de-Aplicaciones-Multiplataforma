package dam2.examen_10_10_2023;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Examen Acceso a Datos
 * 
 * Este es un proyecto Maven hecho con Visual Studio Code.
 * Para ejecutarlo hay que abrir la carpeta examen con VS code.
 * El fichero pom.xml contendrá todas las dependencias y la versión de JDK
 * empleda.
 * 
 * @author Hugo Pelayo
 * @date 10.20.2023
 * */
public class App 
{
    // Vueltas
    private static List<Vuelta> vueltas;

    // Contantes
    private static final Predicate<Corredor> ES_MAYOR_EDAD = c -> Period.between(c.getBirthday(), LocalDate.now()).getYears() > 18;

    /** 
     * Listado del nombre, año y director de todas las vueltas 
     * con más de 10 etapas, ordenado en sentido creciente (de menor a mayor).
     * */
    private static class Ej1 implements Runnable {
        @Override
        public void run() {
            System.out.println("\nEj1:");

            final Predicate<Vuelta> VUELTAS_MAS_10_ETAPAS = vuelta -> vuelta.getEtapas() > 10;

            vueltas.stream().
                filter(VUELTAS_MAS_10_ETAPAS).
                sorted(Comparator.comparing(Vuelta::getAnio)).
                forEach(vuelta -> System.out.println("Nombre: " + vuelta.getNombre() + " Año: " + vuelta.getAnio() + " Director: " + vuelta.getDirector()));
        }
    }
    /** 
     * Listado del nombre de todos los corredores que participen
     * en vueltas de ciclistas con un premio superior a 30.000 euros.
     * */
    private static class Ej2 implements Runnable {
        @Override
        public void run() {
            System.out.println("\nEj2:");

            String participadores =
                vueltas.stream().
                filter(vuelta -> vuelta.getPremio() > 30000).
                flatMap(vuelta -> vuelta.getEquipos().stream()).
                flatMap(equipo -> equipo.getCorredores().stream()).
                distinct().
                map(Corredor::getNombre).
                reduce((c1, c2) -> c1 + ", " + c2).orElse("No hay corredores");

            System.out.println(participadores);
        }
    }

    /** 
     * Listado del nombre de los corredores que participen en equipos sin patrocinador.
     * */
    private static class Ej3 implements Runnable {
        @Override
        public void run() {
            System.out.println("\nEj3:");

            String participadores =
                vueltas.stream().
                filter(vuelta -> vuelta.getPremio() > 30000).
                flatMap(vuelta -> vuelta.getEquipos().stream()).
                filter(equipo -> equipo.getPatrocinador().isEmpty()).
                flatMap(equipo -> equipo.getCorredores().stream()).
                distinct().
                map(Corredor::getNombre).
                reduce((c1, c2) -> c1 + ", " + c2).orElse("No hay corredores");

            System.out.println(participadores);            
        }
    }

    /** 
     * Listado de todos los equipos con corredores profesionales menores de edad.
     * */
    private static class Ej4 implements Runnable {
        @Override
        public void run() {
            System.out.println("\nEj4:");

            final Predicate<Corredor> ES_PROFESIONAL = 
                c -> c.isProfesional();
                
            String participadores =
                vueltas.stream().
                flatMap(vuelta -> vuelta.getEquipos().stream()).
                filter(equipo -> {
                    return equipo.getCorredores().stream().
                            filter(ES_MAYOR_EDAD.negate().and(ES_PROFESIONAL)).toList().isEmpty();
                }).
                map(Equipo::getNombre).
                reduce((c1, c2) -> c1 + ", " + c2).orElse("No hay corredores");

            System.out.println(participadores);   
        }
    }

    /** 
     * Listad del nombre y dni de los corredores mayores de edad por nombre 
     * de vuelta ciclista. Es decir, para cada nombre de vuelta ciclista 
     * mostrar el nombre y el dni de sus corredores mayores de edad.
     * */
    private static class Ej5 implements Runnable {
        @Override
        public void run() {
            System.out.println("\nEj5:");

            final Function<Corredor, String> NOMBRE_Y_DNI = 
                c -> "Nombre: " + c.getNombre() + " DNI: " + c.getDni();

            final Function<Vuelta, Stream<Corredor>> CORREDORES_ADULTOS =
                v -> v.getEquipos().stream().flatMap(e -> e.getCorredores().stream().filter(ES_MAYOR_EDAD));


                       
        }
    }

    public static void main( String[] args )
    {
        inicializarDatos();

        List<Runnable> respuestas = new ArrayList<>();
        
        respuestas.add(new Ej1());
        respuestas.add(new Ej2());
        respuestas.add(new Ej3());
        respuestas.add(new Ej4());
        respuestas.add(new Ej5());

        for (Runnable respuesta : respuestas) {
            respuesta.run();
        }
    }

    private static void inicializarDatos() {
        vueltas = new ArrayList<>();
        // 2 vueltas
        // 3 equipos
        // 2 corredores cada equipo

        // Corredores
        Corredor c1 = Corredor.builder().dni("1234567Y").nombre("Adrián").birthday(LocalDate.of(1999, 5, 11)).profesional(true).build();
        Corredor c2 = Corredor.builder().dni("3657483U").nombre("Clara").birthday(LocalDate.of(1992, 1, 11)).profesional(false).build();
        Corredor c3 = Corredor.builder().dni("2645381T").nombre("Laya").birthday(LocalDate.of(1991, 3, 22)).profesional(true).build();
        Corredor c4 = Corredor.builder().dni("2746527O").nombre("Pedro").birthday(LocalDate.of(2005, 5, 21)).profesional(false).build();
        Corredor c5 = Corredor.builder().dni("2645271P").nombre("Miguel").birthday(LocalDate.of(1995, 6, 9)).profesional(false).build();
        Corredor c6 = Corredor.builder().dni("2635398M").nombre("Mario").birthday(LocalDate.of(2008, 9, 1)).profesional(true).build();

        Corredor c7 = Corredor.builder().dni("2645281P").nombre("Adrián").birthday(LocalDate.of(1992, 5, 12)).profesional(true).build();
        Corredor c9 = Corredor.builder().dni("2Y76251M").nombre("Ana").birthday(LocalDate.of(1995, 5, 10)).profesional(true).build();
        Corredor c8 = Corredor.builder().dni("2726387L").nombre("Luis").birthday(LocalDate.of(2007, 4, 9)).profesional(false).build();
        Corredor c10 = Corredor.builder().dni("272621N").nombre("Antonio").birthday(LocalDate.of(2001, 7, 4)).profesional(false).build();
        Corredor c11 = Corredor.builder().dni("272651N").nombre("Tiago").birthday(LocalDate.of(1999, 5, 6)).profesional(false).build();
        Corredor c12 = Corredor.builder().dni("276265B").nombre("Joao").birthday(LocalDate.of(2001, 7, 8)).profesional(true).build();
        
        // Patrocinadores
        Patrocinador p1 = Patrocinador.builder().nombre("Carmen").nacionalidad("España").donacion(2345.22).build();
        Patrocinador p2 = Patrocinador.builder().nombre("Teresa").nacionalidad("Francia").donacion(4821.22).build();
        
        // Equipos
        Equipo eq1 = Equipo.builder().nombre("Madrid").corredores(Arrays.asList(c1, c2)).patrocinador(Optional.of(p1)).build();
        Equipo eq2 = Equipo.builder().nombre("Barcelona").corredores(Arrays.asList(c3, c4)).patrocinador(Optional.empty()).build();
        Equipo eq3 = Equipo.builder().nombre("Osasuna").corredores(Arrays.asList(c5, c6)).patrocinador(Optional.of(p2)).build();

        Equipo eq4 = Equipo.builder().nombre("Betis").corredores(Arrays.asList(c7, c8)).patrocinador(Optional.of(p1)).build();
        Equipo eq5 = Equipo.builder().nombre("Leganes").corredores(Arrays.asList(c9, c10)).patrocinador(Optional.empty()).build();
        Equipo eq6 = Equipo.builder().nombre("Getafe").corredores(Arrays.asList(c11, c12)).patrocinador(Optional.of(p2)).build();

        // Vueltas
        Vuelta v1 = Vuelta.builder().nombre("Vuelta 1").premio(422000.24).director("Diego").etapas(11).anio(2023).equipos(Arrays.asList(eq1, eq2, eq3)).build();
        Vuelta v2 = Vuelta.builder().nombre("Vuelta 2").premio(400028.22).director("Ronaldo").etapas(3).anio(2024).equipos(Arrays.asList(eq4, eq5, eq6)).build();

        vueltas.add(v1);
        vueltas.add(v2);
    }
}
