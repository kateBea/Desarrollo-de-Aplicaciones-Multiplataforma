package dam2.carreras.model;

/**
 * Representa el sexo de un corredor.
 * */
public enum Sexo {
	HOMBRE { @Override public String toString() { return "Hombre"; } },
	MUJER { @Override public String toString() { return "Mujer"; } },
	OTROS { @Override public String toString() { return "Otros"; } },
}
