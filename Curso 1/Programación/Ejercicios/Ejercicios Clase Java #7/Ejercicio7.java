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

        // guarda datos de personas
        // [0] Nombre, [1] Dirección, [2] Edad, [3] Peso y [4] Altura, respectivamente
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
                case 4 -> margenesEdades(personas);
                case 5 -> margenesPesos(personas);
                case 6 -> mostrarMediaPeso(personas);
                case 7 -> mostrarMediaEdad(personas);
                case 8 -> totalPersonasConMismaEdad(personas);
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
        for (int fila = 0; fila < lista.length; ++fila) {
            System.out.println();
            System.out.println("Datos persona#" + (fila + 1) + ":");
            leerPersona(lista[fila]);
        }
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
        System.out.println("\n1. Mostrar datos.");
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
        System.out.println(Float.parseFloat(persona[3]) + "            " + Float.parseFloat(persona[4]));
    }

    public static void margenesEdades(String[][] personas) {
        int minValor;
        int maxValor;

        int indiceMin;
        int indiceMax;

        indiceMin = 0;
        indiceMax = 0;

        // asumimos los extremos están al principio
        minValor = Integer.parseInt(personas[indiceMin][2]);
        maxValor = Integer.parseInt(personas[indiceMax][2]);

        for (int i = 0; i < personas.length; ++i) {
            int edad = Integer.parseInt(personas[i][2]);

            if (edad < minValor) {
                minValor = edad;
                indiceMin = i;
            }

            if (edad > maxValor) {
                maxValor = edad;
                indiceMax = i;
            }
        }

        System.out.println("La persona con menor edad es: " + personas[indiceMin][0]);
        System.out.println("La persona con mayor edad es: " + personas[indiceMax][0]);
    }

    public static void margenesPesos(String[][] personas) {
        float minValor;
        float maxValor;

        int indiceMin;
        int indiceMax;

        indiceMin = 0;
        indiceMax = 0;

        // asumimos los extremos están al principio
        minValor = Float.parseFloat(personas[indiceMin][3]);
        maxValor = Float.parseFloat(personas[indiceMax][3]);

        for (int i = 0; i < personas.length; ++i) {
            float peso = Float.parseFloat(personas[i][3]);

            if (peso < minValor) {
                minValor = peso;
                indiceMin = i;
            }

            if (peso > maxValor) {
                maxValor = peso;
                indiceMax = i;
            }
        }

        System.out.println("La persona con menor peso es: " + personas[indiceMin][0]);
        System.out.println("La persona con mayor peso es: " + personas[indiceMax][0]);
    }

    public static void mostrarMediaPeso(String[][] personas) {
        float pesoMedio = 0;
        for (int i = 0; i < personas.length; ++i) 
        pesoMedio += (float)Integer.parseInt(personas[i][3]);

        System.out.println("La media de peso es de: " + (pesoMedio / personas.length));
    }

    public static void mostrarMediaEdad(String[][] personas) {
        float edadMedia = 0;
        for (int i = 0; i < personas.length; ++i) 
            edadMedia += (float)Integer.parseInt(personas[i][2]);

        System.out.println("La edad media es de: " + (edadMedia / personas.length));
    }

    public static void totalPersonasConMismaEdad(String[][] personas) {
        // TODO. Descripción imcomleta del problema para estae caso
    }
}