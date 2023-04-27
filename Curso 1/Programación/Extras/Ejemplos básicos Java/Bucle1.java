/* ejemplo bucle while

 * sintaxis:
 * while (condicion){
 *   //bloque sentencias a repetir
 * 
 * }
 *ojo: cambiar condición dentro bucle para no tener bucle infinito
 * Ejemplo: calcular el factorial
 */

public class Bucle1 {
    public static void main (String [] args){
        int n=5; //Se calcula el factorial de 5!
        int factorial = 1;
        int i=1;
        
        while (i<=n){
            factorial = factorial * i;
            i++; // equivale i = i +1
        }

        System.out.println ("El factorial es " + factorial);

    }

    
}
