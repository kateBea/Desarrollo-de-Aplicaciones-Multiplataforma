package Ejercicio1;

public class Localidad {
    private String m_Nombre;
    private String m_Provincia;
    private int m_NumHabitantes;
    private float m_DistanciaACapital;
    private float m_Superficie;
    private float m_RentaPerCapita;

    public Localidad(String nombre,
              String provincia,
              int numHabitantes,
              float distanciaACapital,
              float superficie,
              float rentaPerCapita) {    
        m_Nombre = nombre;
        m_Provincia = provincia;
        m_NumHabitantes = numHabitantes;
        m_DistanciaACapital = distanciaACapital;
        m_Superficie = superficie;
        m_RentaPerCapita = rentaPerCapita;
    }

    /*     Getters      */
    public String getNombre() {
        return m_Nombre;
    }

    public String getProvinvia() {
        return m_Provincia;
    }

    public int getNumeroHabitantes() {
        return m_NumHabitantes;
    }

    public float getDistanciaACapital() {
        return m_DistanciaACapital;
    }

    public float getSuperficie() {
        return m_Superficie;
    }

    public float getRentaPerCapita() {
        return m_RentaPerCapita;
    }

    public boolean tieneMasPoblacion(Localidad other) {
        return getNumeroHabitantes() > other.getNumeroHabitantes();
    }

    public void mostrar() {
        System.out.println("Nombre: " + m_Nombre);
        System.out.println("Provincia: " + m_Provincia);
        System.out.println("Número de habitantes: " + m_NumHabitantes);
        System.out.println("Distancia a capital: " + m_DistanciaACapital + " kM (s)");
        System.out.println("Superficie: " + m_Superficie + " kM2 (s)");
        System.out.println("Renta per capita: " + m_RentaPerCapita);
        System.out.println("----------------------------------");
    }

    public float densidadDePoblacion() {
        // en habitantes por kilómetro cuadrado
        return getNumeroHabitantes() / getSuperficie();
    }

    /*     Setters      */
    public void setNombre(String nombre) {
        m_Nombre = nombre;
    }

    public void setProvinvia(String provincia) {
        m_Provincia = provincia;
    }

    public void setNumeroHabitantes(int numHabitantes) {
        m_NumHabitantes = numHabitantes;
    }

    public void setDistanciaACapital(float distancia) {
        m_DistanciaACapital = distancia;
    }

    public void setSuperficie(float superficie) {
        m_Superficie = superficie;
    }

    public void setRentaPerCapita(float rpc) {
        m_RentaPerCapita = rpc;
    }
}