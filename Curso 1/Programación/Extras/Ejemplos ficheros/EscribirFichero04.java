import java.io.FileWriter;

/* Ejemplo agregar una sola línea a un archivo existente usando FileWriter */
public class EscribirFichero04
{
    public static void main(String args[])
    {
        try
        {
            String filePath = "prueba.txt";
            FileWriter fw = new FileWriter(filePath, true); 
            String lineToAppend = "\r\nHasta Luego....";    
            fw.write(lineToAppend);
            fw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     }
}