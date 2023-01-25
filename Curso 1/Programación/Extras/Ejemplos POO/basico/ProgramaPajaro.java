package basico;
/*
 * Programa que usa la clase Pajaro
 */
public class ProgramaPajaro {
    public static void main (String[] argumentos){

        Pajaro loro = new Pajaro ("Lu", 50,50);
        loro.volar(10, 10);
        loro.mostrarPosicion();
        System.out.println ("El pájaro " + loro.getNombre() + " está en la posición " + loro.getPosX() + ", " + loro.getPosY());
        loro.setPosY(5);
        loro.mostrarPosicion();
    }
}
