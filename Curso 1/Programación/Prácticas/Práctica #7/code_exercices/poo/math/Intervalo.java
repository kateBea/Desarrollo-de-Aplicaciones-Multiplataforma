package poo.math;

public class Intervalo {
    private double m_CotaInferior;
    private double m_CotaSuperior;

    public Intervalo(double minimo, double maximo) throws InvalidRangeException {
        if (minimo > maximo)
            throw new InvalidRangeException("Intervalo inválido, cota inferior super a cota superior");

        
    }
}