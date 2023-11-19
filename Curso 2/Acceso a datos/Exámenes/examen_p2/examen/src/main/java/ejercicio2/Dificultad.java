package ejercicio2;

public enum Dificultad {
    FACIL { @Override public String toString() { return "Fácil"; } },
    MEDIA { @Override public String toString() { return "Media"; } },
    DIFICIL { @Override public String toString() { return "Difícil"; } },
    DESCONOCIDA { @Override public String toString() { return "Desconocida"; } };
	
	public static Dificultad from(String value) {
		switch (value) {
			case "Fácil": return FACIL;
			case "Media": return MEDIA;
			case "Difícil": return DIFICIL;
			default: return DESCONOCIDA;
		}
	}
}
