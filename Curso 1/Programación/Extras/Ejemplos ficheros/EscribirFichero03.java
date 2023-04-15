import java.io.FileOutputStream;
/* Ejemplo agregar una sola línea a un archivo existente usando FileOutputStream */
public class EscribirFichero03
{
    public static void main(String args[])
    {
        try
        {
            String filePath = "prueba.txt"; // el fichero prueba.txt existe previamente
            FileOutputStream f = new FileOutputStream(filePath, true);
            String lineToAppend = "\r\nHola este es un mensaje";    
            byte[] byteArr = lineToAppend.getBytes(); //converting string into byte array
            f.write(byteArr);
            f.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     }
}