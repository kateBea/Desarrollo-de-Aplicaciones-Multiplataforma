package dam2.pruebalombbok;

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
        
        alumno = new Alumno.AlumnoBuilder().nia("002").nota(0).build();
        System.out.println(alumno);
    }
}
