import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class ExampleSerializable01 {

    public static void main(String args[]) {
 
        try {
            
             //Diversos objetos de tipo empleados
            Empleado obj1 = new Empleado("Juan", "Programador", 30.000);
            Empleado obj2 = new Empleado("María", "Analista", 36.000);

            Empleado [] personal =  {obj1, obj2, null};

            //creamos el flujo de datos  hacia el exterior
            ObjectOutputStream fichero_write = new ObjectOutputStream(new FileOutputStream(("data_empleados.txt")));
            fichero_write.writeObject(personal); //se indica el objeto que se desea transferir al exterior
            fichero_write.close();

            //se puede comprobar que se ha creado el fichero

            ObjectInputStream fichero_read= new ObjectInputStream(new FileInputStream(("data_empleados.txt")));
            //deberemos recoger el contenido que es un array de EMpleados
            Empleado [] personal_almacenado =(Empleado[]) fichero_read.readObject(); // fichero_read.readObject() devuelve un tipo Objetc
            fichero_read.close(); //cierra el flujo

            System.out.println ("Personal almacenado: ");
            for(Empleado e: personal_almacenado){
                System.out.println (e);
            }



        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
  
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
