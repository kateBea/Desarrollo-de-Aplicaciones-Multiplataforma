package poo.agencia;

/**
 * Representa un Vehículo
 * @author Hugo Pelayo
 * @version 1.0
 */
public abstract class Vehiculo {
    /*
     * Describe un tipo de Vehículo
     */
    public static enum VehiculoType {
        COCHE, 
        FURGONETA,
        MOTO,
    }

    // Matrícula de este Vehículo
    private String m_Matricula;
    // Marca de este Vehículo
    private String m_Marca;
    // Modelo de este Vehículo
    private String m_Modelo;
    // Caballos de potencia de este Vehículo
    private double m_Potencia;

    /**
     * Inicializa este Vehículo con los valores que se pasa 
     * como parámetros. Si las referencias son nulas, se consideran
     * desconocidos y, en caso de ser negativa la potencia, esta se inicializa a 0
     * @param matricula Matrícula para este Vehículo
     * @param marca Marca para este Vehículo
     * @param modelo Modelo para este Vehículo
     * @param potencia Caballos de potencia para este Vehículo
     */
    public Vehiculo(String matricula, String marca, String modelo, double potencia) {
        m_Matricula = matricula == null ? "Unknown" : matricula;
        m_Marca = marca == null ? "Unknown" : marca;
        m_Modelo = modelo == null ? "Unknown" : modelo;

        if (!(potencia < .0))
            m_Potencia = potencia;
        else {
            m_Potencia = .0;
            System.out.println("Los caballos de potencia deben ser indicados por un valor real positivo");
        } 
    }

    /**
     * Retorna la matrícula de este Vehículo
     * @return Matrícula de este Vehículo
     */
    public String getMatricula() {
        return m_Matricula;
    }

    /**
     * Cambia la matrícula de este Vehiculo por la que se pasa
     * como parámetro. Si la referencia es nula esta función
     * no tiene efecto
     * @param matricula Nueva matrícula para este Vehículo
     */
    public void setMatricula(String matricula) {
        if (matricula != null)
            m_Matricula = matricula;
        else 
            System.out.println("Referencia nula de matricla en setMatricula()...");
    }

    /**
     * Retorna la marca de este Vehículo
     * @return Marca de este Vehículo
     */
    public String getMarca() {
        return m_Marca;
    }

    /**
     * Cambia la marca de este Vehiculo por la que se pasa
     * como parámetro. Si la referencia es nula esta función
     * no tiene efecto
     * @param marca Nueva marca para este Vehículo
     */
    public void setMarca(String marca) {
        if (marca != null)
            m_Marca = marca;
        else 
            System.out.println("Referencia nula de marca en setMarca()...");
    }

    /**
     * Retorna la modelo de este Vehículo
     * @return Modelo de este Vehículo
     */
    public String getModelo() {
        return m_Modelo;
    }

    /**
    * Cambia el modelo de este Vehiculo por el que se pasa
    * como parámetro. Si la referencia es nula esta función
    * no tiene efecto
    * @param modelo Nueva marca para este Vehículo
    */
    public void setModelo(String modelo) {
        if (modelo != null)
            m_Modelo = modelo;
        else 
            System.out.println("Referencia nula de modelo en setModelo()...");
    }

    /**
     * Retorna los caballos de potencia de este Vehículo
     * @return Caballos de potencia de este Vehículo
     */
    public double getPotencia() {
        return m_Potencia;
    }

    /**
    * Cambia los caballos de potencia de este Vehiculo por los que se pasa
    * como parámetro. Si el valor es negativo, esta función no tiene efecto
    * @param potencia Nueva potencia para este Vehículo
    */
    public void setPotencia(double potencia) {
        if (!(potencia < .0)) {
            m_Potencia = potencia;
        }
        else 
            System.out.println("Valor de potencia negativo setPotencia()...");
    }
}
