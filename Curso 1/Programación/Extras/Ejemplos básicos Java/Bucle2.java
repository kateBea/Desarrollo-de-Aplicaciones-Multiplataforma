/* ejemplo bucle do-while

 * sintaxis:
  do{
     // bloque sentencias repetir

  }while (condicion);

 *ojo: cambiar condición dentro bucle para no tener bucle infinito
 * Ejemplo: calcular el factorial
 */

public class Bucle2 {
    public static void main (String [] args){
        int n=5; //Se calcula el factorial de 5!
        int factorial = 1;
        int i=1;
        
        do{
            factorial = factorial * i;
            i++; // equivale i = i +1
        } while (i<=n);

        System.out.println ("El factorial es " + factorial);

    }

    
}
