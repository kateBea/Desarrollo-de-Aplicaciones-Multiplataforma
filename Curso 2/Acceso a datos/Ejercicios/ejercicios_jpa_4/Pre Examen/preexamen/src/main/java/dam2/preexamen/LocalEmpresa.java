package dam2.preexamen;

public enum LocalEmpresa {
	PROPIO,
	ALQUILADO;
	
	public static LocalEmpresa fromStr(String str) {
		return switch (str.toUpperCase()) {
			case "P", "PROPIO" -> PROPIO;
			default -> ALQUILADO;
		};
	}
}
