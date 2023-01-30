package Vehiculo;

/**
 * <h2>Representa un objeto vehículo</h2> 
 * 
 * Para más clases:
 * <a href="https://github.com/kateBea/Desarollo-de-Aplicaciones-Multiplataforma">GitHub ref</a>
 * 
 * Representa un vehículo. Para cada instancia de la
 * clase se recogen propiedades como la matrícula, la marca,
 * el modelo la velocidad, en este caso hace referencia a
 * la velocidad punta, que sería la velocidad máxima alcanzable 
 * en un trayecto en línea recta, y, por último, se guarda
 * inforación sobre el estado actual de las luces que podrían 
 * estar apagadas o encendidas. A continuación un recogido de los
 * atributos de con sus respectivas descripciones:
 *  
 * <ul>
 *     <li><b>Matrícula:</b> Hace referencia a la matrícula actual del vehículo</li>
 *     <li><b>Marca:</b> Hace referencia a la marca del vehículo</li>
 *     <li><b>Modelo:</b> Describe el modelo del vehículo</li>
 *     <li><b>Velocidad:</b> Guarda la velocidad punta del vehículo</li>
 *     <li><b>Luces:</b> Indica si las luces están apagadas o encendidas</li>
 * </ul>
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Vehiculo {
    // Atributos privados de la clase

    // matrícula de vehículo
    private String m_Matricula;
    // marca de vehículo
    private String m_Marca;
    // modelo de vehículo
    private String m_Modelo;
    // velocidad punta de vehículo
    private double m_Velocidad;
    // indica si las luces están encendiaas (true)
    // o las luces están apagadas (false)
    private boolean m_LucesEncendidas;

    /**
     * Este método no recibe parámetros construye un objeto Vehiculo con los
     * atributos por defecto, es decir, cada uno de los atributos
     * se construye con su valor por defector, tenemos entonces
     * las luces apagadas, las cadenas son referencias nulas y la velocidad
     * es 0.0
     * 
     */
    public Vehiculo() {
        m_Matricula = null;
        m_Marca = null;
        m_Modelo = null;
        m_Velocidad = 0.0;
        m_LucesEncendidas = false;
    }

    /**
     * Este método contruye un objeto vehículo con los atributos
     * que se le pasan como parámetros.
     * 
     * @param marca marca del vehículo
     * @param modelo modelo del vehículo
     * @param matricula matricula del vehículo
     * @param velocidad velocidad del vehículo
     * @param estadoLuces estado de luces del vehículo
     */
    public Vehiculo(String marca, 
                    String modelo,
                    String matricula,
                    double velocidad,
                    boolean estadoLuces) {
        
        m_Matricula = matricula;
        m_Marca = marca;
        m_Modelo = modelo;
        m_Velocidad = velocidad;
        m_LucesEncendidas = estadoLuces;
    }

    /**
     * Retorna una cadena representando la matrícula del vehículo
     * 
     * @return matrícula del vehículo
     */
    public String getMatricula() {
        return m_Matricula;
    }

    /**
     * Cambia el valor de la matrícula a la matrícula que se pasa
     * por parámetro
     * 
     * @param matricula matrícula a la que se cambia la matrícula actual
     */
    public void setMatricula(String matricula) {
        this.m_Matricula = matricula;
    }

    /**
     * Retorna una cadena representando el modelo del vehículo
     * 
     * @return marca del vehículo
     */
    public String getMarca() {
        return m_Marca;
    }

    /**
     * Cambia el valor de la marca al valor que se pasa
     * por parámetro
     * 
     * @param marca marca por la que se cambia la actual
     */
    public void setMarca(String marca) {
        this.m_Marca = marca;
    }

    /**
     * Retorna una cadena representando el modelo del vehículo
     * 
     * @return modelo del vehículo
     */
    public String getModelo() {
        return m_Modelo;
    }

    /**
     * Cambia el modelo del vehículo al modelo que se pasa
     * por parámetro
     * 
     * @param modelo modelo al cual se cambia el actual
     */
    public void setModelo(String modelo) {
        this.m_Modelo = modelo;
    }

    /**
     * Retorna un valor representando la velocidad punta
     * del vehículo
     *
     * @return velocidad punta del vehículo
     */
    public double getVelocidad() {
        return m_Velocidad;
    }

    /**
     * Cambia la velocidad del vehículo a la que que se pasa
     * por parámetro
     * 
     * @param velocidad velocidad a la que se actualiza la actual
     */
    public void setVelocidad(double velocidad) {
        this.m_Velocidad = velocidad;
    }

    /**
     * Devuelve cierto si las luces están encendidas, falso en 
     * caso contrario
     * 
     * @return cierto si las luces están encendidas, falso en caso contrario
     */
    public boolean lucesEncendidas() {
        return m_LucesEncendidas;
    }

    /**
     * Cambia el estado de las luces del vehículo al 
     * modelo que se pasa por parámetro.
     * 
     * @param estado estado al cual se cambia el estado actual de las luces
     */
    public void switchLuces(boolean estado) {
        this.m_LucesEncendidas = estado;
    }

    /**
     * Retorna una cadena formateada que describe la clase.
     * Para cada atributo muestra su valor con un buen formateado.
     * 
     * @return cadena formateada que describe el objeto
     */
    @Override
    public String toString() {
        return String.format("Matrícula: %s\nMarca: %s\nModelo: %s\nVelocidad: %.3f\nEstado luces: %s\n------------------------\n", 
            m_Matricula, m_Marca, m_Modelo, m_Velocidad, (m_LucesEncendidas ? "encendidas" : "apagadas"));
    } 
}