/* Muestra los ficheros del directorio actual. */
import java.io.File;

public class ExampleFichero02 {
    public static void main(String[] args) {
		String dir = ".";  //directorio actual
		File f = new File(dir);
		String[] archivos = f.list();
		System.out.printf("Ficheros en el directorio actual: %d %n", archivos.length);
        // Nota en https://docs.oracle.com/javase/tutorial/java/data/numberformat.html aparece tabla donde consultar identificadores %
        // %d integer %f float %s string %b boolean %n salto línea
		for (int i = 0; i < archivos.length; i++) {
			File f2 = new File(f, archivos[i]);
			System.out.printf("Nombre: %s, es fichero?: %b, es directorio?:%b %n", archivos[i], f2.isFile(), f2.isDirectory());
		}
	}

}
