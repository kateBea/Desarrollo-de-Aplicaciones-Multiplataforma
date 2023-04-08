package poo.math;

// TODO: añadir Javadocs

public class Intervalo {
    private double m_CotaInferior;
    private double m_CotaSuperior;

    public Intervalo(double minimo, double maximo) {
        if (minimo > maximo)
            throw new InvalidRangeException("Intervalo inválido, cota inferior supera cota superior");

        m_CotaInferior = minimo;
        m_CotaSuperior = maximo;
    }

    public Intervalo() {
        m_CotaInferior = .0;
        m_CotaSuperior = .0;
    }

    public Intervalo(double maximo) {
        if (maximo < .0)
            throw new InvalidRangeException("Intervalo no puede ser negativo para este constructor");

        m_CotaInferior = .0;
        m_CotaSuperior = maximo;
    }

    public Intervalo(Intervalo other) {
        this(other.getCotaInferior(), other.getCotaSuperior());
    }

    public double getCotaInferior() {
        return m_CotaInferior;
    }

    public void setCotaInferior(double minimo) {
        if (minimo > m_CotaSuperior)
            throw new InvalidRangeException("El valor excede la cota superior");
        else {
            m_CotaInferior = minimo;
        }
    }

    public double getCotaSuperior() {
        return m_CotaSuperior;
    }

    public void setCotaSuperior(double maximo) {
        if (maximo < m_CotaInferior)
            throw new InvalidRangeException("El valor está por debajo de la cota inferior");
        else {
            m_CotaSuperior = maximo;
        }
    }

    public boolean valido() {
        // siempre retorna cierto
        return m_CotaInferior <= m_CotaSuperior;
    }

    public double longitud() {
        return Math.abs(m_CotaSuperior) - Math.abs(m_CotaInferior);
    }

    public double puntoMedio() {
        return (m_CotaSuperior + m_CotaInferior) / 2.0;
    }

    public void desplazar(double offset) {
        m_CotaInferior += offset;
        m_CotaSuperior += offset;
    }

    Intervalo copia(Intervalo other) {
        return new Intervalo(other);
    }

    public boolean equals(Intervalo other) {
        return m_CotaInferior == other.getCotaInferior() && m_CotaSuperior == other.getCotaSuperior();
    }

    public boolean iguales(Intervalo other) {
        return this.equals(other);
    }

    public boolean incluye(double punto) {
        return punto >= m_CotaInferior && punto <= m_CotaSuperior; 
    }

    public boolean incluye(Intervalo other) {
        return this.incluye(other.getCotaInferior()) && this.incluye(other.getCotaSuperior()); 
    }

    public Intervalo[] troceado(int porciones) {
        double incremento = this.longitud() / porciones;
        double offset = .0;
        int index = 0;
        Intervalo[] resultado = new Intervalo[porciones];

        for ( ; index < porciones; ++index) {
            resultado[index] = new Intervalo(this.getCotaInferior() + offset, this.getCotaInferior() + offset + incremento);
            offset += incremento;

        }

        return resultado;
    }

    public void mostrar() {
        System.out.println(this.toString());
    }

    public void escalar(double valor) {
        m_CotaInferior *= valor;
        m_CotaSuperior *= valor;
    }

    public Intervalo desplazado(double offset) {
        return new Intervalo(this.getCotaInferior() + offset, this.getCotaSuperior() + offset);
    }

    public Intervalo interseccion(Intervalo other) {
        // se aume que ambos intervalos se intersectan en el menos un punto
        Intervalo resultado = null;

        resultado = new Intervalo(
                Math.max(this.getCotaInferior(), other.getCotaInferior()), 
                Math.min(this.getCotaSuperior(), other.getCotaSuperior())
            );

        return resultado;
    }

    public Intervalo simetrico() {
        return new Intervalo(this.getCotaInferior() - longitud(), this.getCotaInferior());
    }

    @Override
    public String toString() {
        return String.format("[%.3f, %.3f]", this.getCotaInferior(), this.getCotaSuperior());
    }
}
