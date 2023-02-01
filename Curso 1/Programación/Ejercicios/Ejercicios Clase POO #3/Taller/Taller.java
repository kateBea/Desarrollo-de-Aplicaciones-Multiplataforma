package Taller;

/**
 * <h2>Representa un taller</h2>
 * 
 * Para más clases:
 * <a href="https://github.com/kateBea/Desarollo-de-Aplicaciones-Multiplataforma">GitHub ref</a>
 * 
 * Representa una clase taller y nos permite conocer el presupuesto de 
 * reparación de un objeto vehículo.
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */

public class Taller {
    // el nombre del taller
    private String m_Nombre;
    // el número de teléfono del taller
    private String m_Telefono;
    // el precio de reparación por hora del vehículo
    private double m_PrecioReparacion;

    /**
     * Construye un objeto taller a partir de los parámetros
     * 
     * @param nombre nombre del taller
     * @param telefono número de teléfono del taller
     * @param precio precio de reparación por hora del taller
     */
    public Taller(String nombre, String telefono, double precio) {
        m_Nombre = nombre;
        m_Telefono = telefono;
        m_PrecioReparacion = precio < 0.0 ? 0.0 : precio;
    }

    /**
     * Cambia el nombre de este taller. Si el paramétro es nulo,
     * no se realizan cambios
     * 
     * @param nombre nombre al cual se cambia el de este taller
     */
    public void setNombre(String nombre) {
        if (nombre == null)
            m_Nombre = nombre;
    }

    /**
     * Devuelve el nombre de este taller
     * 
     * @return el nombre de este taller
     */
    public String getNombre() {
        return m_Nombre;
    }

    /**
     * Cambia el número de teléfono de este taller, si el parámetro es nulo
     * no se realiza ningún cambio
     * 
     * @param telefono número de teléfono al cual se cambia el de este taller
     */
    public void setTelefono(String telefono) {
        m_Telefono = telefono;
    }

    /**
     * Devuelve el número de teléfono de este taller
     * 
     * @return el nombre de este taller
     */
    public String getTelefono() {
        return m_Telefono;
    }

    /**
     * Cambia el precio de reparación por hora de este taller, si el
     * valor es negativo no se realiza ningún cambio
     * 
     * @param precio precio al cual se cambia el de este taller
     */
    public void setPrecioReparacion(double precio) {
        m_PrecioReparacion = precio;
    }

    /**
     * Devuelve el precio de reparación por hora de este taller
     * 
     * @return el precio de reparación por hora de este taller
     */
    public double getPrecioReparacion() {
        return m_PrecioReparacion;
    }

    /**
     * Calcula el importe de reparación total para el
     * vehículo que se pasa como parámetro por las horas invertidas
     * 
     * @param veh el vehículo a ser evaluado
     * @param horas las horas de reparación invertidas
     * @return importe de reparación
     */
    public double repararVehiculo(Vehiculo veh, double horas) {
        // NOTA: El enunciado es poco aclarativo respecto este método
        double importeReparacion = 0;
        for (Pieza item : veh.getPiezas()) 
            importeReparacion += item.getPrecio();
        
        importeReparacion += horas * getPrecioReparacion();

        return importeReparacion;
    }
}