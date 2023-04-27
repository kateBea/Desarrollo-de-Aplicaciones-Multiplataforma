/* ejemplo bucle for

 * sintaxis:
  for ( inicialización ; condicion ;  salto){
        // bloque_sentencias_repiten
  }

 * Ejemplo: calcular el factorial
 */
public class Bucle3 {
    public static void main (String [] args){
        int n=5; //Se calcula el factorial de 5!
        int factorial = 1;
           
        for (int i=1; i<=n; i++){
            factorial = factorial * i;
        }         

        System.out.println ("El factorial es " + factorial);

    }
    
}
