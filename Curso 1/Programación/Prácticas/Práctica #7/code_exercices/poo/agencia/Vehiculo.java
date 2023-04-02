package poo.agencia;

public abstract class Vehiculo {
    private String m_Matricula;
    private String m_Marca;
    private String m_Modelo;

    // representa los caballos de potencia
    private double m_Potencia;

    public Vehiculo(String matricula, String marca, String modelo, double potencia) {
        m_Matricula = matricula;
        m_Marca = marca;
        m_Modelo = modelo;

        if (!(potencia < .0))
            m_Potencia = potencia;
        else {
            m_Potencia = 0;
            System.out.println("Los caballos de potencia deber ser indicados por un valor positivo");
        } 
    }

    public String getMatricula() {
        return m_Matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula != null)
            m_Matricula = matricula;
    }

    public String getMarca() {
        return m_Marca;
    }

    public void setMarca(String marca) {
        if (marca != null)
            m_Marca = marca;
    }

    public String getModelo() {
        return m_Modelo;
    }

    public double getPotencia() {
        return m_Potencia;
    }

    public void setPotencia(double potencia) {
        if (!(potencia < .0)) {
            m_Potencia = potencia;
        }
    }
}
