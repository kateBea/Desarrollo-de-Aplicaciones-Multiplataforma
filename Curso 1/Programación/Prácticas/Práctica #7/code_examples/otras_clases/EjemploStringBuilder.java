package otras_clases;

/**
 * Este ejemplo muestra un uso básico de la clase
 * StringBuilder para construir un String
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class EjemploStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("Esto es una ");
        sb.append("prueba");

        String resultado = sb.toString();
        System.out.println(resultado);

    }
}
