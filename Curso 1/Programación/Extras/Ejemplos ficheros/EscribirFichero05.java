import java.io.BufferedWriter;
import java.io.FileWriter;

/* Ejemplo agregar una sola línea a un archivo existente usando BufferedWriter */
public class EscribirFichero05
{
    public static void main(String args[])
    {
        try
        {
            String filePath = "prueba.txt";
            
            FileWriter fw = new FileWriter(filePath, true); 
            BufferedWriter bw = new BufferedWriter(fw);
            String lineToAppend = "\r\nOtra prueba";    
            bw.write(lineToAppend);
            bw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     }
}