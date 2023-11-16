package pruebas.pruebas_de_nivel;

public enum Categoria {
    ZONA_METROPOLITANA {
        public String toString() {
            return "Zona Metropolitana";
        }
    },

    DESCONOCIDO {
        public String toString() {
            return "Desconocido";
        }
    };

    public static Categoria fromString(String value) {
        return switch (value) {
            case "Zona Metropolitana" -> ZONA_METROPOLITANA;
            default -> DESCONOCIDO;
        };
    }
}
