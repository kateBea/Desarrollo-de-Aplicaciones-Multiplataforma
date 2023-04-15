import java.io.File;
import java.io.FilenameFilter;

public class Example04 {
    public static void main(String[] args) {
        File fichero = new File (".");
        String[] listaArchivos=fichero.list();

        System.out.println ("Se listan todos los ficheros");
        for(int i=0; i<listaArchivos.length; i++){
            System.out.println(listaArchivos[i]);
        }
        System.out.println ("\n\nSe listan únicamente ficheros Java");
        listaArchivos=fichero.list(new Filtro(".java"));
        for(int i=0; i<listaArchivos.length; i++){
            System.out.println(listaArchivos[i]);
        }
    }
}

class Filtro implements FilenameFilter{
    String extension;
    Filtro(String extension){ //constructor con la extensión
        this.extension=extension;
    }
    public boolean accept(File dir, String name){ // se debe implementar el método abstracto accept
        return name.endsWith(extension);
    }
}