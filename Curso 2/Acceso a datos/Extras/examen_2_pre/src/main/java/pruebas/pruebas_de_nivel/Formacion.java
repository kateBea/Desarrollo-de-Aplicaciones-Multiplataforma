package pruebas.pruebas_de_nivel;

public enum Formacion {
    PRESENCIAL {
        @Override
        public String toString() {
            return "Presencial";
        }
    },

    NO_PRESENCIAL {
        public String toString() {
            return "No Presencial";
        }
    };

    public static Formacion fromString(String value) {
        return switch (value) {
            case "Presencial" -> PRESENCIAL;
            default -> NO_PRESENCIAL;
        };
    }
}
