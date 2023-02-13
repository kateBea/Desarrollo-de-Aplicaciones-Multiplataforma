package figuras;

/**
 * <h2>Representa una Figura geométrica</h2>
 * 
 * Esta clase representa una figura geométrica que se puede mover
 * por el plano euclídeo. A parte de ello describe también el
 * color de la figura.
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */
public abstract class Figura {
    // Conjunto de colores
    private static String[] s_Colores = {
        "Rojo", "Cian", "Violeta", "Verde", "Magenta",
        "Amarillo", "Gris", "Rosa", "Granate", "Tomate", 
        "Lila", "Fúcsia", "Gualda", "Naranja", "Negro", 
        "Blanco", "Crema", "???"
    };

    /**
     * Representa un color
     */
    public static enum ColorType {
        AZUL,
        ROJO,
        CIAN,
        VIOLETA,
        VERDE,
        MAGENTA,
        AMARILLO,
        GRIS,
        ROSA,
        GRANATE,
        TOMATE,
        LILA,
        FUCSIA,
        GUALDA,
        NARANJA,
        NEGRO,
        BLANCO,
        CREMA,
        DESCONOCIDO,
    }

    // Nombre de la figura
    private String m_Nombre;
    // Corrdenada X de la figura
    private double m_CoordX;
    // Corrdenada Y de la figura
    private double m_CoordY;
    // Color de la figura
    private ColorType m_Color;

    public Figura(Figura other) {
        m_Nombre = other.m_Nombre;
        m_Color = other.m_Color;
        m_CoordX = other.m_CoordX;
        m_CoordY = other.m_CoordY;
    }

    /*
     * Retorna un String representando el color que se le pasa
     */
    private static String getColorStr(ColorType color) {
        return switch (color) {
            case AZUL -> "Azul";
            case ROJO -> "Rojo";
            case CIAN -> "Cian";
            case VIOLETA -> "Violeta";
            case VERDE -> "Verde";
            case MAGENTA -> "Magenta";
            case AMARILLO -> "Amarillo";
            case GRIS -> "Gris";
            case ROSA -> "Rosa";
            case GRANATE -> "Granate";
            case TOMATE -> "Tomate";
            case LILA -> "Lila";
            case FUCSIA -> "Fúcsia";
            case GUALDA -> "Gualda";
            case NARANJA -> "Naranja";
            case NEGRO -> "Negro";
            case BLANCO -> "Blanco";
            case CREMA -> "Crema";
            case DESCONOCIDO -> "???";
        };
    }

    /**
     * Devuelve el color acorde con el String que se pasa como
     * parámetro
     * 
     * @return El color de esta figura
     */
    public static ColorType getColorType(String color) {
        return ColorType.DESCONOCIDO;
    }
    
    /** 
     * Construye una Figura a partir de los valores que se pasan
     * como parámetro. La posicción por defecto es (0, 0)
     * 
     * @param nombre Nombre de la figura
     * @param color Color de la figura
     */
    public Figura(String nombre, ColorType color) {
        m_Nombre = nombre;
        m_Color = color;
        m_CoordX = 0.0;
        m_CoordY = 0.0;
    }

    /**
     * Construye una Figura a partir de los valores que se pasan
     * como parámetro.
     * 
     * @param nombre Nombre de la figura
     * @param color Color de la figura
     * @param coordx Coordenada X de la figura
     * @param coordy Coordenada Y de la figura
     */
    public Figura(String nombre, ColorType color, double coordx, double coordy) {
        m_Nombre = nombre;
        m_Color = color;
        m_CoordX = coordx;
        m_CoordY = coordy;
    }

    /**
     * Cambia el color de esta figura por el que se pasa como parámetro
     * 
     * @param color Nuevo color de esta figura
     */
    public void setColor(ColorType color) {
        m_Color = color;
    }

    /**
     * Retorna una cadena de carcateres representando el color de esta figura
     * 
     * @return Color de esta figura
     */
    public String getColor() {
        return getColorStr(m_Color);
    }

    /**
     * Cmabia el nombre de esta figura por le que se pasa 
     * como parámetro
     * 
     * @param nombre Nuevo nombre de esta figura
     */
    public void setNombre(String nombre) {
        m_Nombre = nombre;
    }
    
    /**
     * Retorna el nombre de esta figura
     * 
     * @return Nombre de esta figura
     */
    public String getNombre() {
        return m_Nombre;
    }

    /**
     * Operación igual que mover(double, double). En este caso simplemente
     * se recibe como parámetro un array de coordenadas que se valida. Si 
     * el array es inválido esta función no tiene efecto
     * 
     * @param coordenadas
     */
    public void setCoordenadas(float[] coordenadas) {
        if (coordenadas != null && coordenadas.length == 2) {
            m_CoordX = coordenadas[0];
            m_CoordY = coordenadas[1];
        }
        else 
            System.out.println("Coordenadas inválidas...");
    }

    /**
     * Retorna las coordenadas de esta figura como arra de decimales. La primera
     * posición representa la coordenada X y la segunda posición del array 
     * representa la coordenada Y
     * 
     * @return Posición en el plano euclídeo de esta figura
     */
    public double[] getCoordenadas() {
        return new double[]{ m_CoordX, m_CoordY };
    }
    /**
     * Mueve la figura a la posición que se le pasa como
     * parámetro. La posición de la figura pasa a ser la que se pasa como
     * parámetro
     * 
     * @param newX Nueva coordenada X de esta figura
     * @param newY Nueva coordenada Y de esta figura
     */
    public void mover(double newX, double newY) {
        m_CoordX = newX;
        m_CoordY = newY;
    }
    /**
     * Mueve la figura a una posición del espacio euclídeo. La posición
     * final se calcula desplazando el objeto desde su posición actual.
     * 
     * @param offsetX Desplazamiento por el eje X
     * @param offsetY Desplazamiento por el eje Y
     */
    public void desplazar(double offsetX, double offsetY) {
        m_CoordX += offsetX;
        m_CoordY += offsetY;
    }

    /**
     * Dibuja por la salida de datos la forma que tiene la figura
     */
    abstract void dibujar();

    /**
     * Devuelve el valor del área de esta figura
     * 
     * @return Área de esta figura
     */
    abstract double calcularArea();

    /**
     * Retorna un String representando las propiedades de esta figura
     * 
     * @return La representación de esta figura
     */
    @Override
    public String toString() {
        return String.format("Nombre: %s\n" +
                            "Coordenadas: [%.3f, %.3f]\n" +
                            "Color: %s\n" +
                            "---------------------------",
        m_Nombre, m_CoordX, m_CoordY, getColorStr(m_Color));
    }
}
