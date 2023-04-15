import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/* Ejemplo agregar una sola línea a un archivo existente usando clase Files */
public class EscribirFichero06
{
    public static void main(String args[])
    {
        try
        {
            String file = "prueba.txt";
            
            String lineToAppend = "\r\nMas ejemplos como escribir";    
            byte[] byteArr = lineToAppend.getBytes();
            Files.write(Paths.get(file), byteArr, StandardOpenOption.APPEND);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     }
}