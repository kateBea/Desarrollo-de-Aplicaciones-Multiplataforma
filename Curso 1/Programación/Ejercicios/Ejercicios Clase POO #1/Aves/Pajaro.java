package Aves;

/*
 * Esta clase modela un objeto pájaro que
 * es de tipo Ave. El objeto Pájaro consta de un
 * nombre y de unas coordenadas [x, y] en el plano euclídeo.
 * 
 * El usuario puede consultar y modifcar las coordenadas del
 * objeto Pajaro pero el nombre es inmutable una vez instanciado
 * el objeto. Se requiere de almenos el nombre para instanciar un objeto Pajaro
 */

public class Pajaro {
    private String m_Nombre;
    private float m_CoordenadaX;
    private float m_CoordenadaY;

    public Pajaro(String nombre) {
        this.m_Nombre = nombre;
        this.m_CoordenadaX = 0;
        this.m_CoordenadaY = 0; 
    }

    public Pajaro(String nombre, float coordX, float coordY) {
        this.m_Nombre = nombre;
        this.m_CoordenadaX = coordX;
        this.m_CoordenadaY = coordY; 
    }

    /*************************************
     *  CONSULTORAS                      *
     *************************************/

    public String getNombre(String nombre) {
        return this.m_Nombre;
    }

    public float getCoordenadaX(float valor) {
        return this.m_CoordenadaX;
    }

    public float getCoordenadaY(float valor) {
        return this.m_CoordenadaY;
    }

    /*************************************
     *  MODIFICADORAS                    *
     *************************************/

    public void setNombre(String nombre) {
        this.m_Nombre = nombre;
    }

    public void setCoordenadaX(float valor) {
        this.m_CoordenadaX = valor;
    }

    public void setCoordenadaY(float valor) {
        this.m_CoordenadaY = valor;
    }

    public void setCoordenadaY(float desplazamientoX, float desplazamientoY) {
        this.m_CoordenadaX += desplazamientoX;
        this.m_CoordenadaY += desplazamientoY;

        mostrarPosicion();
    }

    public void mostrarPosicion() {
        System.out.print("El pájaro " + this.m_Nombre + " está en la posición ");
        System.out.println("X = " + this.m_CoordenadaX + ", Y = " + this.m_CoordenadaY);
    }
}