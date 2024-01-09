package org.instituto;


public enum TipoEstudio {
	ESO,
	BACHILLERATO,
	
	FP_GRADO_MEDIO,
	FP_GRADO_SUPERIOR;
	
	
	/**
	 * Tipo de estudios. ESO ("ESO"), BACHILLERATO ("BACH"),
	 * FP_GRADO_MEDIO ("FPM"), FP_GRADO_SUPERIOR ("FPS").
	 * */
	public static TipoEstudio fromStr(String str) {
		return switch (str) {
			case "ESO" -> ESO;
			case "BACH" -> BACHILLERATO;
			case "FPS" -> FP_GRADO_SUPERIOR;
			case "FPM" -> FP_GRADO_MEDIO;
			default -> ESO;
		};
	}
}
