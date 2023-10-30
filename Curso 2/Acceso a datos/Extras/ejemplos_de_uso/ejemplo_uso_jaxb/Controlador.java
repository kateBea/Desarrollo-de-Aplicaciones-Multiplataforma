package ejemplos_de_uso.ejemplo_uso_jaxb;

public interface Controlador <T> {
	
	public default void leerDatos (T pojo)
	{
		leerClave (pojo);
		leerOtrosDatos(pojo);
	}
	
	public void leerClave (T pojo);
	public void leerOtrosDatos (T pojo);

}
