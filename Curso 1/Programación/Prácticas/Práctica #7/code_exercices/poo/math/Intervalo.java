package poo.math;

/**
 * Representa un Intervalo matemático
 * @author Hugo Pelayo
 * @version 1.0
 */
public class Intervalo {
    // Punto que define la cota inferior del este Intervalo
    private double m_CotaInferior;
    // Punto que define la cota superior de este Intervalo
    private double m_CotaSuperior;

    /*
     * Retorna cierto si ambos intervalos son disjuntos
     */
    private static boolean sonDisjuntos(Intervalo a, Intervalo b) {
        return a.getCotaSuperior() < b.getCotaInferior() ||
            b.getCotaSuperior() < a.getCotaInferior();
    }
    
    /**
     * Inicializa este Intervallo entre los valores pasados
     * como parámetro, ambos inclusos. Si "minimo" es inferior
     * a "maximo" se lanza una excepción de error de Intervalo
     * @param minimo Cota inferior para este Intervalo
     * @param maximo Cota superior para este Intervalo
     * @throws InvalidRangeException
     */
    public Intervalo(double minimo, double maximo) {
        if (minimo > maximo)
            throw new InvalidRangeException("Intervalo inválido, cota inferior supera cota superior");

        m_CotaInferior = minimo;
        m_CotaSuperior = maximo;
    }

    /**
     * Inicializa este Intervalo al intervalo [0, 0]
     */
    public Intervalo() {
        m_CotaInferior = .0;
        m_CotaSuperior = .0;
    }

    /**
     * Inicializa este Intervalo a [0, maximo].
     * Si la cota superior es negativa, se lanza una excepción
     * por rango inválido
     * @param maximo Cota superior para este Intervalo
     * @throws InvalidRangeException
     */
    public Intervalo(double maximo) {
        if (maximo < .0)
            throw new InvalidRangeException("Intervalo no puede ser negativo para este constructor");

        m_CotaInferior = .0;
        m_CotaSuperior = maximo;
    }

    /**
     * Inicializa este Intervalo como copia del que
     * se pasa como parámetro
     * @param other Intervalo del cual este se copia
     */
    public Intervalo(Intervalo other) {
        this(other.getCotaInferior(), other.getCotaSuperior());
    }

    /**
     * Retorna la cota inferior de este Intervalo
     * @return La cota inferior
     */
    public double getCotaInferior() {
        return m_CotaInferior;
    }

    /**
     * Cambia la cota inferior de este Intervalo por la
     * que se pasa como parámetro, si el valor supera
     * la cota superior se lanza excepción por Intervalo inválido
     * @param minimo Nueva cota inferior para este Intervalo
     * @throws InvalidRangeException
     */
    public void setCotaInferior(double minimo) {
        if (minimo > m_CotaSuperior)
            throw new InvalidRangeException("El valor excede la cota superior");
        else {
            m_CotaInferior = minimo;
        }
    }

    /**
     * Retorna la cota superior de este Intervalo
     * @return La cota superior
     */
    public double getCotaSuperior() {
        return m_CotaSuperior;
    }

    /**
     * Cambia la cota superior de este Intervalo por la
     * que se pasa como parámetro, si el valor es inferior a
     * la cota inferior se lanza excepción por Intervalo inválido
     * @param maximo Nueva cota inferior para este Intervalo
     * @throws InvalidRangeException
     */
    public void setCotaSuperior(double maximo) {
        if (maximo < m_CotaInferior)
            throw new InvalidRangeException("El valor está por debajo de la cota inferior");
        else {
            m_CotaSuperior = maximo;
        }
    }

    /**
     * Retorna cierto si este Intervalo es válido, falso en caso contrario
     * @return Cierto si este Intervalo es válido, falso en cualquier otro caso
     * @deprecated Se garantiza que los intervalos son simepre válidos
     */
    public boolean valido() {
        // siempre retorna cierto
        return m_CotaInferior <= m_CotaSuperior;
    }

    /**
     * Retorna la distanca entre la cota inferior y la superior
     * @return Longitud de este Intervalo
     */
    public double longitud() {
        return Math.abs(m_CotaSuperior) - Math.abs(m_CotaInferior);
    }

    /**
     * Retorna el punto medio de este Intervalo
     * @return Punto en la mitad de este Intervalo
     */
    public double puntoMedio() {
        return (m_CotaSuperior + m_CotaInferior) / 2.0;
    }

    /**
     * Desplaza este Intervalo tantas unidades como indique 
     * el parámetro
     * @param offset Indica cuántas unidades se desplaza este Intervalo
     */
    public void desplazar(double offset) {
        m_CotaInferior += offset;
        m_CotaSuperior += offset;
    }

    /**
     * Retorna una copia exacta del Intervalo que se pasa como parámetro
     * @param other Intervalo que se copia
     * @return Intervalo copia del parámetro
     */
    public static Intervalo copia(Intervalo other) {
        return new Intervalo(other);
    }

    /**
     * Retorna cierto si ambos Intervalos son iguales,
     * falso en caso contrario
     * @param other Intervalo con que se compara el parámetro implícito
     * @return Cierto si son el mismo, falso en cualquier otro caso
     */
    public boolean equals(Intervalo other) {
        return m_CotaInferior == other.getCotaInferior() && m_CotaSuperior == other.getCotaSuperior();
    }

    /**
     * Retorna cierto si ambos Intervalos son iguales,
     * falso en caso contrario
     * @param other Intervalo con que se compara el parámetro implícito
     * @return Cierto si son el mismo, falso en cualquier otro caso
     */
    public boolean iguales(Intervalo other) {
        return this.equals(other);
    }

    /**
     * Retorna cierto si este Intervalo contiene el punto
     * que se pasa como parámetro
     * @param punto Punto a consultar
     * @return Cierto si el punto está en este Intervalo, falso si no
     */
    public boolean incluye(double punto) {
        return punto >= m_CotaInferior && punto <= m_CotaSuperior; 
    }

    /**
     * Retorna cierto si este Intervalo incluye
     * el que se pasa como parámetro, falso en caso contrario
     * @param other Intervalo a consultar
     * @return Cierto si el intervalo forma parte del parámetro implícito y falso en caso contrario
     */
    public boolean incluye(Intervalo other) {
        return this.incluye(other.getCotaInferior()) && this.incluye(other.getCotaSuperior()); 
    }

    /**
     * Retorna un array de intervalos cada uno con la longitud resultante de 
     * dividir el parámetro implícito en tantas partes iguales como
     * indica el parámetro. Todos los intervalos son contiguos
     * @param porciones Número de intervalos a obtener
     * @return Tantos intervalos como indica el parámetro, todos con misma longitud
     */
    public Intervalo[] troceado(int porciones) {
        Intervalo[] resultado;
        double incremento;
        double offset;
        int index;
        if (porciones > 0) {
            resultado = new Intervalo[porciones];
            incremento = this.longitud() / porciones;
            offset = .0;
            index = 0;
    
            for ( ; index < porciones; ++index) {
                resultado[index] = new Intervalo(this.getCotaInferior() + offset, this.getCotaInferior() + offset + incremento);
                offset += incremento;
    
            }
        }
        else
            resultado = null;

        return resultado;
    }

    /**
     * Muestra este Intervalo por la salida de datos estándard
     */
    public void mostrar() {
        System.out.println(this.toString());
    }

    /**
     * Multiplica la longitud de este intervalo por el
     * valor que se pasa como parámetro, si "valor" es nulo,
     * esta función no tiene efectos
     * @param valor Escalar por el que se multiplica la longitud de este Intervalo
     */
    public void escalar(double valor) {
        if (valor != 0) {
            m_CotaInferior *= valor;
            m_CotaSuperior *= valor;
        }
    }

    /**
     * Retorna un nuevo Intervalo resultado de desplazar el 
     * del parámetro implícito tantas unidades como indica el parámetro
     * @param offset Unidades a desplazar este Intervalo
     * @return Nueva Intervalo desplazado
     */
    public Intervalo desplazado(double offset) {
        return new Intervalo(this.getCotaInferior() + offset, this.getCotaSuperior() + offset);
    }

    /**
     * Retorna un nuevo Intervalo resultado de la intersección este
     * y el que se pasa como parámetro, si los intervalos son sijuntos,
     * esta función no tiene efecto
     * @param other Intervalo a evaluar
     * @return La intersección de "other" y el parámetro implícito
     */
    public Intervalo interseccion(Intervalo other) {
        // se asume que ambos intervalos se intersectan en el menos un punto
        // (faltaría comparar ambos intervalos para ver si coinciden)
        Intervalo resultado = null;

        if (!sonDisjuntos(this, other)) {
            resultado = new Intervalo(
                    Math.max(this.getCotaInferior(), other.getCotaInferior()), 
                    Math.min(this.getCotaSuperior(), other.getCotaSuperior())
                );

        }

        return resultado;
    }

    /**
     * Retorna un Intervalo simétrico al parámetro implícito
     * @return Intervalo simétrico
     */
    public Intervalo simetrico() {
        return new Intervalo(this.getCotaInferior() - longitud(), this.getCotaInferior());
    }

    /**
     * Retorna un String representanto este Intervalo
     * @return String formateado representando este Intervalo
     */
    @Override
    public String toString() {
        return String.format("[%.3f, %.3f]", this.getCotaInferior(), this.getCotaSuperior());
    }
}
