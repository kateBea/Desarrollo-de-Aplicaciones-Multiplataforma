package figuras;

/**
 * Esta clase representa una figura geométrica que se puede mover
 * por el plano euclídeo. A parte de ello describe también el
 * color de la figura.
 * 
 * @author Hugo Pelayo
 * @version 1.0
 */
public abstract class Figura {
    /**
     * Representa un color
     */
    enum ColorType {
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
    }

    // Nombre de la figura
    private String m_Nombre;
    // Corrdenada X de la figura
    private double m_CoordX;
    // Corrdenada Y de la figura
    private double m_CoordY;
    // Color de la figura
    ColorType m_Color;

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
        };
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
    public String toString() {
        return String.format("Nombre: %s\n" +
                            "Coordenadas: [%.3f, %.3f]\n" +
                            "Color: %s\n" +
                            "---------------------------",
        m_Nombre, m_CoordX, m_CoordY, getColorStr(m_Color));
    }
}
