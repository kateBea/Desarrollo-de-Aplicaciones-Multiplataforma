/* 
 * Este programa gestiona la información relativa a una persona, a destacar, el nombre
 * la dirección, la edad, el peso y la altura. Para ello no os ofrece una serie de operaciones
 * como el sorteo de personas por edad, peso, cálculo de la media de pesos, media de alturas, 
 * entre otras operaciones que nos muestra el programa por pantalla. Los datos vienen
 * representados mediante una matriz de String. Cada fila de la matriz represennta 
 * los datos de una persona en formato de String y cada columna representa un campo de
 * información como se indica a continuación:
 * 
 * Nombre -> columna 0
 * Dirección -> columna 1
 * Edad -> columna 2
 * Peso -> columna 3
 * Altura -> columna 4
 * 
 * @author Hugo
 * @version 1.0
 * @date 14 de enero de 2023
 */

import java.io.*;
import java.util.Arrays;

public class Ejercicio7 {
    // Utilidades para la lectura de datos
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    // Enumerador que indica un
    // método de ordenamiento
    enum ORDEN {
        OrdenPeso,
        OrdenEdad,
    }

    public static void main(String[] args) throws IOException {
        gestor();
    }

    /*
     * Lee de la entrada de datos la información relativa a una serie de personas
     * y ofrece operaciones sobre este listado.
     * 
     * @param None
     * @return void
     * @author Hugo
     */
    public static void gestor() throws IOException {
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

    /*
     * Ordena una matriz de String acorde con el ORDEN indicado
     * 
     * @param personas matriz que contiene información a ser ordenada
     * @return void
     * @author Hugo
     */
    public static void ordenar(String[][] personas, ORDEN orden) {
        ordenar(personas, orden, 0, personas.length - 1);
    }

    /*
     * Ordena una matriz de String acorde con el ORDEN indicado.
     * Implementa ordenación por fusión. Los dos índices pasados como parámetro 
     * representan un subconjunto de filas dentro del rango de filas de la matriz.
     * Ambos índices están comprendidos en el rango [0, personas[0].length() - 1]
     * 
     * @param personas matriz a ser ordenada
     * @param orden el tipo de ordenamiento
     * @param left índice dentro del rango de filas de la matriz
     * @param right índice dentro del rango de filas de la matriz
     * @return void
     * @author Hugo
     */
    public static void ordenar(String[][] personas, ORDEN orden, int left, int right) {
        // ordenamos si el intervalo entre left y right (ambos inclusos)
        // contiene al menos un elemento
        if (left < right) {
            // divide arreglo a la mitad del tamaño
            // (right - left) + 1 es el número de elementos comprendido
            // en el rango que se trata actualmente
            int mid = (left + right) / 2;

            // ordenar mitad izquierda del rango actual del arreglo (la matriz es un arreglo de arreglos)
            ordenar(personas, orden, left, mid);

            // ordenar mitad derecha del rango actual del arreglo
            ordenar(personas, orden, mid + 1, right);

            // combinar ambas partes
            combinar(personas, orden, left, mid, right);
        }
    }

    /*
     * Fusiona los dos subconjuntos de filas de forma ordenada dentro de la matriz.
     * Los dos índices (left y right) pasados como parámetro representan un subconjunto de filas 
     * dentro del rango de filas de la matriz. El índice mid hace de separador entre ambos
     * subconjuntos de filas.
     * 
     * Los tres índices están comprendidos en el rango [0, personas[0].length() - 1]
     * 
     * @param personas matriz a ser ordenada
     * @param orden el tipo de ordenamiento
     * @param left índice dentro del rango de filas de la matriz
     * @param right índice dentro del rango de filas de la matriz
     * @return void
     * @author Hugo
     */
    public static void combinar(String[][] personas, ORDEN orden, int left, int mid, int right) {
        // tamaño del vector auxiliar
        int newSize = (right - left) + 1;
        // índice que itera sobre el subconjnto de filas superior
        int idxSubvectorIzq = left;
        // índice que itera sobre el conjunto de filas inferior
        int idxSubvectorDer = mid + 1; 
        // índice que itera sobre el vector auxiliar
        int idxArrayAuxiliar = 0;

        String[][] arrayAuxiliar = new String[newSize][5];

        if (orden == ORDEN.OrdenEdad) {
            // ordenación de la matriz por edad
            // dado un personas[i] donde i es un índice, personas[i][2] representa la edad 
            while (idxSubvectorIzq <= mid && idxSubvectorDer <= right) {
                if (ordenPorEdad(Integer.parseInt(personas[idxSubvectorIzq][2]), Integer.parseInt(personas[idxSubvectorDer][2])))
                    arrayAuxiliar[idxArrayAuxiliar++] = personas[idxSubvectorIzq++];
                else 
                    arrayAuxiliar[idxArrayAuxiliar++] = personas[idxSubvectorDer++];
            }
        }
        else if (orden == ORDEN.OrdenPeso) {
            // ordenación de la matriz por peso
            // dado un personas[i] donde i es un índice, personas[i][3] representa el peso
            while (idxSubvectorIzq <= mid && idxSubvectorDer <= right) {
                if (ordenPorPeso(Float.parseFloat(personas[idxSubvectorIzq][3]), Float.parseFloat(personas[idxSubvectorDer][3])))
                    arrayAuxiliar[idxArrayAuxiliar++] = personas[idxSubvectorIzq++];
                else 
                    arrayAuxiliar[idxArrayAuxiliar++] = personas[idxSubvectorDer++];
            }
        }

        // copia elementos restantes de las filas superiores
        // al arreglo auxiliar
        if (idxSubvectorIzq <= mid)
            System.arraycopy(personas, idxSubvectorIzq, arrayAuxiliar, idxArrayAuxiliar, (mid - idxSubvectorIzq) + 1);
        
        // copia elementos restantes de las filas inferiores
        // al arreglo auxiliar
        if (idxSubvectorDer <= right)
            System.arraycopy(personas, idxSubvectorDer, arrayAuxiliar, idxArrayAuxiliar, (right - idxSubvectorDer) + 1);

        // copia los elementos ya ordenados del arreglo auxiliar a la matriz
        System.arraycopy(arrayAuxiliar, 0, personas, 0 + left, newSize);
    }

    /*
     * Esta función devuelve cierto si el primero valor es más grande 
     * que el segundo. Se asume que ambos parámetros son números reales.
     * 
     * @param a valor a ser evaluado
     * @param b valor a ser evaluado
     * 
     * @return boolean cierto si a es más grande que b. Falso en caso contrario
     * @author Hugo
     */
    public static boolean ordenPorPeso(float a, float b) {
        return a <= b;
    }

    /*
     * Esta función devuelve cierto si el primero valor es más grande 
     * que el segundo. Funciona similar a orden por peso pero en este caso
     * recibe números enteros.
     * 
     * @param a valor a ser evaluado
     * @param b valor a ser evaluado
     * 
     * @return boolean cierto si a es más grande que b. Falso en caso contrario
     * @author Hugo
     */
    public static boolean ordenPorEdad(int a, int b) {
        return a <= b;
    }

    /*
     * Lee los datos de personas de la entrada de datos y los almacena en una matriz
     * de String. Por cada fila lee cinco cadenas que representan el nombre, dirección,
     * edad, peso y altura de una persona.
     * 
     * @param lista la matriz a ser rellenada
     * @return void
     * @author Hugo
     */
    public static void leerDatos(String[][] lista) throws IOException {
        for (int fila = 0; fila < lista.length; ++fila) {
            System.out.println("\nDatos persona#" + (fila + 1) + ":");
            leerPersona(lista[fila]);
        }
    }

    /*
     * Esta función lee los datos de una persona y los almacena
     * en un arreglo de String.
     * 
     * @param persona el arreglo a ser rellenado
     * @return void
     * @author Hugo
     */
    public static void leerPersona(String[] persona) throws IOException {
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

    /*
     * Esta función muestra por pantalla una serie de operaciones que el usuario
     * puede realizar sobre la matriz que representa datos sobre personas.
     * 
     * @param None
     * @return void
     * @author Hugo
     */
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

    /*
     * Esta función muestra de forma formateada por la salida de datos 
     * la información de personas contenida en una matriz de String
     * 
     * @param personas la matriz a imprimir
     * @return void
     * @author Hugo
     */
    public static void mostrarDatos(String[][] personas) {
        System.out.println("-----------------------------------------------------------------");
        for (int fila = 0; fila < personas.length; ++fila) 
            imprimirDatosPersona(personas[fila]);

        System.out.println("-----------------------------------------------------------------");
    }

    /*
     * Función auxiliar que se usa en conjunto con mostrarDatos(String[][])
     * para imprimir los datos sobre una persona individual.
     * 
     * @param persona arreglo conteniendo información sobre una persona
     * @return void
     * @author Hugo
     */
    public static void imprimirDatosPersona(String[] persona) {
        System.out.println("Nombre:      " + persona[0]);
        System.out.println("Direciión:   " + persona[1]);
        System.out.println("Edad:        " + persona[2]);
        System.out.println("Peso (kg):   " + persona[3]);
        System.out.println("Altura (cm): " + persona[4]);
        System.out.println();
    }

    /*
     * Dada una matriz con información sobre personas, calcula la edad mínima
     * y la edad máxima entre las personas contenidas en la matriz y muestra 
     * dichos valores por pantalla.
     * 
     * @param personas la matriz que contiene información sobre personas
     * @return void
     * @author Hugo
     */
    public static void margenesEdades(String[][] personas) {
        // contiene el valor del menor edad
        int minValor;
        // contiene el valor del mayor edad
        int maxValor;

        // contiene el índice a la persona con menor edad
        int indiceMin;
        // contiene el índice a la persona con mayor edad
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

    /*
     * Dada una matriz con información sobre personas, calcula el peso mínimo
     * y la peso máximo entre las personas contenidas en la matriz y muestra 
     * dichos valores por pantalla.
     * 
     * @param personas la matriz que contiene información sobre personas
     * @return void
     * @author Hugo
     */
    public static void margenesPesos(String[][] personas) {
        // contiene el valor del menor peso
        float minValor;
        // contiene el valor del mayor peso
        float maxValor;

        // contiene el índice a la persona con menor peso
        int indiceMin;
        // contiene el índice a la persona con mayor peso
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

    /*
     * Dada una matriz con la información de personas, muestra por
     * pantalla la media aritmética del peso de todas las del listado.
     * 
     * @param personas matriz que contiene información sobre personas
     * @return void
     * @author Hugo
     */
    public static void mostrarMediaPeso(String[][] personas) {
        float pesoMedio = 0;
        for (int i = 0; i < personas.length; ++i) 
        pesoMedio += Float.parseFloat(personas[i][3]);

        System.out.println("La media de peso es de: " + (pesoMedio / personas.length));
    }

    /*
     * Dada una matriz con la información de personas, muestra por
     * pantalla la media aritmética de la edad de todas las del listado.
     * 
     * @param personas matriz que contiene información sobre personas
     * @return void
     * @author Hugo
     */
    public static void mostrarMediaEdad(String[][] personas) {
        float edadMedia = 0;
        for (int i = 0; i < personas.length; ++i) 
            edadMedia += (float)Integer.parseInt(personas[i][2]);

        System.out.println("La edad media de edad es de: " + (edadMedia / personas.length));
    }

    public static void totalPersonasConMismaEdad(String[][] personas) {
        // 1. Varios grupos de personas con misma edad (mostrar las que tienen mayor/menor edad? )
        // 2. Mostrar todos indicando la cantidad para cada grupo.
        // ...

        // guardará las edades de las personas en el formato de
        // entero para el proceso de conteo más delante
        int[] edades = new int[personas.length];

        // para iterar sobre el vector edades
        int indice = 0;

        // cuenta el número de personas con una cierta edad
        int totalConEdad = 1; 

        // obtener edades
        for (String[] persona : personas)
            edades[indice++] = Integer.parseInt(persona[2]);

        // ordenar las edades para contarlas
        // por grupos de menor edad a mayor edad
        Arrays.sort(edades);
        
        // totalConEdad vale 1 porque al entrar al bucle se asume
        // que hay al menos una persona con la edad que se va a tratar y
        // se repite esto cada vez que tenemos una edad nueva (cada grupo de edades)
        for (indice = 0; indice < edades.length - 1; ++indice) {
            if (edades[indice] == edades[indice + 1])
                totalConEdad++;
            else {
                System.out.println("Total de personas con " + edades[indice] + " años: " + totalConEdad);
                totalConEdad = 1;

                // trato caso final, si la última persona de la lista
                // y la penúltima no tienen la misma edad
                if (indice == edades.length - 2)
                    System.out.println("Total de personas con " + edades[indice + 1] + " años: " + totalConEdad);
            }
        }

    }
}