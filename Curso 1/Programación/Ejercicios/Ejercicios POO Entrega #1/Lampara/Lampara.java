package Lampara;
/*
 * Crear una clase Lámpara como representación de un sistema 
 * de iluminación. Nuestra lámpara es capaz de dar distintos 
 * niveles de iluminación. Para eso crearemos la clase con 
 * dos atributos y sus correspondientes métodos get y set:
 * 
 * Podemos cambiar la intensidad de la luz mediante el método 
 * setIntensidad, indicando la cantidad de luz que queremos recibir. 
 * También nos gustaría poder encender la luz indicando el voltaje. 
 * El voltaje será un número de tipo double con valores entre 1.5 y 12.5. 
 * Para eso crearemos el método: setIntensidad(double voltaje). 
 * Si el parámetro voltaje es inferior a 1.5, la intensidad está al 0 %. 
 * Si el valor es mayor que 12.5, la intensidad está al 100%. Los otros 
 * valores del parámetro dependen del voltaje y se pueden calcular mediante
 * una regla de tres. Por último queremos conocer el estado actual de nuestra 
 * luz. Para realizar esto, sobrescribiremos el método toString() para que 
 * devuelva un mensaje con el formato: Luz: ON, Intensidad: 45%
 * 
 * Detalles:
 * - encendida: buleano que indicará si la luz está encendida o no. 
 * - intensidad: entero que indicara el nivel de luz (de 0 a 100 %).
 * - voltaje: decimal que indica el voltaje
 * 
 * CONSTRAINTS:
 * voltaje en el rango [1.5, 12.5] (ambos valores inclusos)
 */


public class Lampara {
    // constantes de clase
    private static final double VOLTAJE_MINIMO = 1.5;
    private static final double VOLTAJE_MAXIMO = 12.5;

    private static final int INTENSIDAD_MAXIMA = 100;
    private static final int INTENSIDAD_MINIMA = 0;

    // atributos de la clase 
    private boolean m_Encendida;
    private int m_Intensidad;
    private double m_Voltaje;

    public Lampara() {
        m_Encendida = false;
        m_Intensidad = 0;
        m_Voltaje = 0.0;
    }

    /*       MÉTODOS AUXILIARES        */
    /*******************************************************
     *  Estos métodos sólo se utilizan dentro de la clase, 
     * no está permitido su uso fuera de la clase ya que sirven 
     * como herramientas auxiliares para implementar ciertos métodos 
     * de la misma por tanto se declaran todos como privado 
     * ******************************************************/

    // este método nos devolverá una cantidad determinada de
    // voltaje dependiendo de la intensidad que le pasamos
    // intensidad está entre 0 y 100%
    private static double obtenerVoltajeDeIntensidad(int intensidad) {
        if (intensidad == 0)
            return VOLTAJE_MINIMO;

        if (intensidad == 100)
            return VOLTAJE_MAXIMO;

        // resultado es un valor dentro del intervalo [VOLTAJE_MINIMO, VOLTAJE_MAXIMO]
        return (intensidad / 100.0) * (VOLTAJE_MAXIMO - VOLTAJE_MINIMO);

    }

    // este método nos devolverá una cantidad determinada de
    // intensidad dependiendo del voltaje que le pasamos
    private static int obtenerIntensidadDeVoltaje(double voltaje) {
        // aisgnar intensidad acorde al voltaje
        // dentro del rango [VOLTAJE_MINIMO, VOLTAJE_MAXIMO]
        double rango = VOLTAJE_MAXIMO - VOLTAJE_MINIMO;
        return (int)((voltaje / rango) * 100.0);
    }

    /*       GETTERS       */
    /*
     * Métodos para la consulta de datos
     */

    public boolean estaEncedida() {
        return m_Encendida;
    }

    public int getIntensidad() {
        return m_Intensidad;
    }

    public double getVoltaje() {
        return m_Voltaje;
    }

    /*       SETTERS       */
    /*
     * Métodos para la modificación de atributos
     */

    public void setIntensidad(int intensidad) {
        if (!(intensidad >= INTENSIDAD_MINIMA && intensidad <= INTENSIDAD_MAXIMA)) {
            System.out.printf("Intensidad [ %d ] no válida...\n", intensidad);
            return;
        }

        m_Intensidad = intensidad;
        m_Voltaje = obtenerVoltajeDeIntensidad(intensidad);
        
        // encender la luz si la intensidad no es nula
        if (intensidad > INTENSIDAD_MINIMA)
            m_Encendida = true;
    }

    public void setIntensidad(double voltaje) {
        if (voltaje < VOLTAJE_MINIMO) {
            m_Intensidad = 0;
            apagar();
        }
        else if (voltaje > VOLTAJE_MAXIMO) {
            m_Intensidad = 100;
            encender();
        }
        else {
            m_Intensidad = obtenerIntensidadDeVoltaje(m_Voltaje);
        }
    }

    public void setVoltaje(double voltaje) {
        if (voltaje < 0.0) {
            System.out.printf("Valor de voltaje no válido[ %f ]\n", voltaje);
            return;
        }

        m_Voltaje = voltaje;

        // ajustar intensidad acorde al voltaje actual
        setIntensidad(m_Voltaje);
    }

    public void encender() {
        if (!m_Encendida && obtenerIntensidadDeVoltaje(m_Voltaje) == INTENSIDAD_MINIMA) 
            // en el caso de tener voltaje no suficiente 
            // para una intensidad no nula, no podremos enceder la lámpara
            System.out.println("No hay suficiente voltaje.");
        else if (!m_Encendida && obtenerIntensidadDeVoltaje(m_Voltaje) > INTENSIDAD_MINIMA) {
            // si tenemos voltaje suficiente para una intensidad no nula entonces 
            // podremos poner la lámpara en encendida
            System.out.println("Se ha encendido la lámpara.");
            m_Intensidad = obtenerIntensidadDeVoltaje(m_Voltaje);
            m_Encendida = true;
        }
        else {
            System.out.println("Se ha encendido la lámpara.");
            m_Intensidad = obtenerIntensidadDeVoltaje(m_Voltaje);
            m_Encendida = false;
        }
    }

    public void apagar() {
        if (!m_Encendida) 
            System.out.println("La lámpara está apagada.");
        else {
            System.out.println("Se ha apagado la lámpara.");
            m_Intensidad = 0;
            m_Encendida = false;
        }
    }

    public String toString() {
        return String.format("Luz: %s, Intensidad: %d%s", (m_Encendida ? "ON" : "OFF"), m_Intensidad, "%");
    }

    public void mostrar() {
        System.out.println(this.toString());
    }
}
