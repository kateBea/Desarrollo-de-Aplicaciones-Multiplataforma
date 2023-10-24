package ejemplos_de_uso.xmldomsax_23_10_2023;

public interface Controlador <T> {
	
	public default void leerDatos (T pojo)
	{
		leerClave (pojo);
		leerOtrosDatos(pojo);
	}
	
	public void leerClave (T pojo);
	public void leerOtrosDatos (T pojo);

}
