package Taller;

/**
 * 
 */

public class Taller {
    private String m_Nombre;
    private String m_Telefono;
    private double m_PrecioReparacion;

    public Taller(String nombre, String telefono, double precio) {
        m_Nombre = nombre;
        m_Telefono = telefono;
        m_PrecioReparacion = precio < 0.0 ? 0.0 : precio;
    }

    public void setNombre(String nombre) {
        m_Nombre = nombre;
    }

    public String getNombre() {
        return m_Nombre;
    }

    public String getTelefono() {
        return m_Telefono;
    }

    public void setTelefono(String telefono) {
        m_Telefono = telefono;
    }

    public double getPrecioReparacion() {
        return m_PrecioReparacion;
    }

    public void setPrecioReparacion(String telefono) {
        m_Telefono = telefono;
    }

    public double repararVehiculo(Vehiculo veh, double horas) {
        // NOTA: El enunciado es poco aclarativo respecto este método
        double importeReparacion = 0;
        for (Pieza item : veh.getPiezas()) 
            importeReparacion += + item.getPrecio();
        
        importeReparacion += horas * getPrecioReparacion();

        return importeReparacion;
    }
}