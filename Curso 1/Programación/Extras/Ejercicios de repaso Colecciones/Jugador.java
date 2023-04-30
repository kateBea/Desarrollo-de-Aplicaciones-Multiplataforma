public class Jugador {
    
    private int dorsal;
    private String nombre;
    private int posicion;


    
    public Jugador(int dorsal, String nombre, int posicion) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.posicion = posicion;
    }
    public int getDorsal() {
        return dorsal;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPosicion() {
        return posicion;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    
    @Override
    public String toString() {
        return "Jugador [dorsal=" + dorsal + ", nombre=" + nombre + ", posicion=" + posicion + "]";
    }

    
    

}
