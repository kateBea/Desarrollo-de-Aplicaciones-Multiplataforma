/* UT5: Clases y objetos
 * Modelar la clase Pajaro donde se guarda el
 * nombre, coordenada_X, coordenada_Y
 * crear constructor y métodos get/set, así como
 * un método para volar
 */
package basico;
public class Pajaro {
    // Declaración de atributos
    private String nombre;
    private int posX, posY;

    //Método constructor
    public Pajaro(String nb, int x, int y){
        nombre = nb;
        posX=x;
        posY=y;

    }
    public Pajaro (String nb){
        nombre = nb;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nb){
        nombre = nb;
    }
    
    public int getPosX(){
        return posX;

    }
    public void setPosX(int x){
        posX=x;
    }
    public int getPosY(){
        return posY;

    }
    public void setPosY(int y){
        posY=y;
    }

    public void volar (int desplazamientoX, int desplazamientoY){
        posX=posX+desplazamientoX;
        posY=posY+desplazamientoY;
    }

    public void mostrarPosicion(){
        System.out.println ("El pájaro " + nombre + " está en la posición x=" +posX + ", y=" + posY);
    }



}
