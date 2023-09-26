package dam2.pruebadam2;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println( "Hello World! Maven!" );
        
        Alumno alumno;
        
        alumno = new Alumno.AlumnoBuilder().nia("002").nota(0).nombre("Claudia").fecha(LocalDate.of(2001, 2, 13)).build();
        
        System.out.println("NIA: " + alumno.getNia());
        System.out.println("Nombre: " + alumno.getNombre());
        System.out.println("Fecha: " + alumno.getFecha());
        
        System.out.println(alumno);
    }
}
