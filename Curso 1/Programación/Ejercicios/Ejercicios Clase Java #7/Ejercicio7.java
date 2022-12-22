import java.io.*;

public class Ejercicio7 {
    enum ORDEN {
        OrdenPeso,
        OrdenEdad,
    }

    public static void main(String[] args) throws IOException {
        gestor();
    }

    public static void gestor() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);

        int opcion;
        int limitePersonas;
        final int LIMITE_DATOS = 5;
        String[][] personas;
        
        System.out.println("********** BIENVENIDO A GESTOR DE PERSONAS **********");
        System.out.print("¿Cuántas personas deseas registrar? ");
        limitePersonas = Integer.parseInt(lector.readLine());
        personas = new String[limitePersonas][LIMITE_DATOS];
        
        System.out.println("A continuación introduzca los datos de las personas");
        System.out.println("A destacar [Nombre, Dirección, Edad, Peso y Altura]:");
        leerDatos(personas);

        do {
            mostrarMenu();
            System.out.print("Elige tu opción [Introducir índice]: ");
            opcion = Integer.parseInt(lector.readLine());

            switch (opcion) {
                case 1 -> mostrarDatos(personas);
                case 2 -> ordenar(personas, ORDEN.OrdenPeso);
                case 3 -> ordenar(personas, ORDEN.OrdenEdad);
                
                //case 4 -> ;
                //case 5 -> ;
                //case 6 -> ;
                //case 7 -> ;
                //case 8 -> ;
                //case 9 -> ;
            }

            System.out.println();
        }
        while (opcion != 9);
    }

    public static void ordenar(String[][] personas, ORDEN orden) {
        ordenar(personas, orden, 0, personas.length - 1);
    }

    static void ordenar(String[][] personas, ORDEN orden, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            ordenar(personas, orden, left, mid);
            ordenar(personas, orden, mid + 1, right);
            ordenar(personas, orden, left, mid, right);
        }
    }

    static void ordenar(String[][] personas, ORDEN orden, int left, int mid, int right) {
        int newSize = (right - left) + 1;
        int idxSubvectorIzq = left;
        int idxSubvectorDer = mid + 1; 
        int idxArrayAuxiliar = 0;

        String[][] arrayAuxiliar = new String[newSize][5];

        if (orden == ORDEN.OrdenEdad) {
            while (idxSubvectorIzq <= mid && idxSubvectorDer <= right) {
                if (ordenPorEdad(Integer.parseInt(personas[idxSubvectorIzq][2]), Integer.parseInt(personas[idxSubvectorDer][2])))
                    arrayAuxiliar[idxArrayAuxiliar++] = personas[idxSubvectorIzq++];
                else 
                    arrayAuxiliar[idxArrayAuxiliar++] = personas[idxSubvectorDer++];
            }
        }
        else if (orden == ORDEN.OrdenPeso) {
            while (idxSubvectorIzq <= mid && idxSubvectorDer <= right) {
                if (ordenPorPeso(Float.parseFloat(personas[idxSubvectorIzq][3]), Float.parseFloat(personas[idxSubvectorDer][3])))
                    arrayAuxiliar[idxArrayAuxiliar++] = personas[idxSubvectorIzq++];
                else 
                    arrayAuxiliar[idxArrayAuxiliar++] = personas[idxSubvectorDer++];
            }
        }

        if (idxSubvectorIzq <= mid)
            System.arraycopy(personas, idxSubvectorIzq, arrayAuxiliar, idxArrayAuxiliar, (mid - idxSubvectorIzq) + 1);
        if (idxSubvectorDer <= right)
            System.arraycopy(personas, idxSubvectorDer, arrayAuxiliar, idxArrayAuxiliar, (right - idxSubvectorDer) + 1);

        System.arraycopy(arrayAuxiliar, 0, personas, 0 + left, newSize);
    }

    public static boolean ordenPorPeso(float a, float b) {
        return a <= b;
    }

    public static boolean ordenPorEdad(int a, int b) {
        return a <= b;
    }

    public static void leerDatos(String[][] lista) throws IOException {
        for (int fila = 0; fila < lista.length; ++fila) 
            leerPersona(lista[fila]);
    }

    public static void leerPersona(String[] persona) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        System.out.print("Introduzca el nombre: ");
        persona[0] = lector.readLine();
        System.out.print("Introduzca la dirección: ");
        persona[1] = lector.readLine();
        System.out.print("Introduzca la edad: ");
        persona[2] = lector.readLine();
        System.out.print("Introduzca peso (en kilogramos): ");
        persona[3] = lector.readLine();
        System.out.print("Introduzca la altura (en centímetros): ");
        persona[4] = lector.readLine();
    }

    public static void mostrarMenu() {
        System.out.println("1. Mostrar datos.");
        System.out.println("2. Ordenar por peso.");
        System.out.println("3. Ordenar por edad.");
        System.out.println("4. Mostrar pareja con mayor / menor edades.");
        System.out.println("5. Mostrar pareja con mayor / menor pesos.");
        System.out.println("6. Mostrar la media de peso.");
        System.out.println("7. Mostrar la media de edad.");
        System.out.println("8. Mostrar el número de personas con misma edad");
        System.out.println("9. Salir.\n");
    }

    public static void mostrarDatos(String[][] personas) {
        System.out.println("Nombre         Dirección         Edad         Peso         Altura");
        System.out.println("------         ---------         ----         ----         ------");
        for (int fila = 0; fila < personas.length; ++fila) 
            imprimirDatosPersona(personas[fila]);
        
        
    }

    public static void imprimirDatosPersona(String[] persona) {
        System.out.print(persona[0] + "        " + persona[1] + "        " + persona[2] + "           ");
        System.out.println(persona[3] + "            " + persona[4]);
    }
}