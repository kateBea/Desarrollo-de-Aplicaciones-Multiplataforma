package ejercicios_json_1.ejercicio2;

public enum TipoFormacion {
    PRESENCIAL {
        @Override
        public String toString() {
            return "Presencial";
        }
    },

    NO_PRESENCIAL {
        @Override
        public String toString() {
            return "No Presencial";
        }
    }
}
