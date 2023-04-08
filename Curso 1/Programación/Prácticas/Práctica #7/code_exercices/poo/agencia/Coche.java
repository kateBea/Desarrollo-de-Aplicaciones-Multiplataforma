package poo.agencia;

/**
 * Representa un Coche
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Coche extends Vehiculo {
    // Número de puertas de este Coche
    private int m_Puertas;

    /**
     * Inicializa este Coche con los valores que se pasa 
     * como parámetros. Si las referencias son nulas, se consideran
     * desconocidos y, en caso de ser negativa la potencia, esta se inicializa a 0
     * @param matricula Matrícula para este Coche
     * @param marca Marca para este Coche
     * @param modelo Modelo para este Coche
     * @param potencia Caballos de potencia para este Coche
     * @param puertas Número de puertas para este Coche
     */
    public Coche(String matricula, String marca, String modelo, double potencia, int puertas) {
        super(matricula, marca, modelo, potencia);
        m_Puertas = puertas < 0 ? 2 : puertas;
    }

    /**
     * Retorna el número de puertas de este coche
     * @return Número de puertas de este Coche
     */
    public int getPuertas() {
        return m_Puertas;
    }

    /**
     * Cambia el número de puertas de este Coche
     * por el que se pasa como parámetro. Si el parámetro es
     * negativo, esta función no tiene efecto.
     * @param puertas
     */
    public void setPuertas(int puertas) {
        if (puertas > 0)
            m_Puertas = puertas;
        else
            System.out.println("Valor de puertas inválido");
    }
}
