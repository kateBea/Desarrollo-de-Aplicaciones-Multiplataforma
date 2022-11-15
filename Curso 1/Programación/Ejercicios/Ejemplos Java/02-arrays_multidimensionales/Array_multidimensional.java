/* Los arrays pueden tener dos dimensiones 
 * 
 * Declaración 
 * tipo_Dato [] [] nombre_variable;
 *  
 * Para acceder a elemento:
 * nombre_variable [posicion_fila][posición_Columna]
 */
public class Array_multidimensional {
    public static void main(String[] argumentos) {

        int[][] matriz;
        matriz = new int[3][4]; // 3 filas y 4 columnas

        // Asignamos valores a la primera fila
        matriz[0][0] = 1;
        matriz[0][1] = 2;
        matriz[0][2] = 3;
        matriz[0][3] = 4;

        System.out.println("El valor de la fila 1 y colum 1 es " + matriz[0][0]);
        System.out.println("El valor de la fila 2 y colum 3 es " + matriz[1][2]);
        // En este último elemento muestra 0 porque no se asignó valor y tiene el valor
        // por defecto del tipo
        System.out.println("Num filas " + matriz.length);
        System.out.println("Num cols " + matriz[0].length);

    }

}
