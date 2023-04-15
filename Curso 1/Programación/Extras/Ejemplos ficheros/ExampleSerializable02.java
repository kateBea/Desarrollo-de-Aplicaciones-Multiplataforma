import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;

public class ExampleSerializable02 {

    public static void main(String args[]) {
        try {
            //Fechas de nacimiento
            LocalDate f1 = LocalDate.of(1965, Month.JANUARY, 1);
            LocalDate f2 = LocalDate.of(1975, Month.FEBRUARY, 10);
            LocalDate f3 = LocalDate.of(1980, Month.APRIL, 15);
            LocalDate f4 = LocalDate.of(1985, Month.NOVEMBER, 25);

            //Diversos objetos de tipo persona
            Persona obj1 = new Persona("06634246S", "Javier", f1, "calle1");
            Persona obj2 = new Persona("65834916K", "Pedro", f2, "calle2");
            Persona obj3 = new Persona("91635476F", "Laura", f3, "calle3");
            Persona obj4 = new Persona("15664386T", "Carmen", f4, "calle4");

            /**
             * **** Serialización de los objetos ******
             */
            //Serialización de las personas
            FileOutputStream fosPer = new FileOutputStream("copiasegPer.dat");
            ObjectOutputStream oosPer = new ObjectOutputStream(fosPer);
            oosPer.writeObject(obj1);
            oosPer.writeObject(obj2);
            oosPer.writeObject(obj3);
            oosPer.writeObject(obj4);

            fosPer.close();

            //Lectura de los objetos de tipo persona
            FileInputStream fisPer = new FileInputStream("copiasegPer.dat");
            ObjectInputStream oisPer = new ObjectInputStream(fisPer);

            try {
                while (true) {
                    Persona per = (Persona) oisPer.readObject();
                    System.out.println(per.toString());
                }
            } catch (EOFException e) {
                System.out.println("Lectura de los objetos de tipo Persona finalizada");
            }
            fisPer.close();

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
