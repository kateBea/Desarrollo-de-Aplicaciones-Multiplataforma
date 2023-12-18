package dam2.preexamen;

import dam2.utilidades_hibernate.GenericJPADAO;

/**
 * Entidad Financiera.
 * 
 * Una entidad financiera desea realizar una aplicación para llevar el control de sus 
 * gestiones. Para ello desea guardar información sobre sus clientes, dicha información 
 * consiste en el nif, el nombre, el valor máximo de sus avales, así como sus teléfonos 
 * de contacto y la compañía a la que pertenecen (ejemplo 60534 34 56 – Movistar). Un 
 * cliente puede tener muchos teléfonos almacenados.
 * 
 * @author Hugo Pelayo
 * @version 1.0.0
 * */
public class App 
{
	private static GenericJPADAO<Cliente, String> clienteDao;
	private static GenericJPADAO<Telefono, String> telefonoDao;
	private static GenericJPADAO<CuentaEmpresa, String> cuentaEmpresaDao;
	private static GenericJPADAO<CuentaParticular, String> cuentaParticularDao;
	
	private static final int OPCION_SALIR = 5;
	
    public static void main( String[] args )
    {
    	// Inicialización
    	if (!init()) {
    		return;
    	}
    	
    	Integer opcion;
    	
    	System.out.println("\n=================================");
    	System.out.println("  APLICACIÓN ENTIDAD FINANCIERA  ");
    	System.out.println("=================================");
    	
    	do {
    		mostrarMenu();
    		opcion = Input.leerEntero("Introduce un índice: ");
    		
    		if (opcion == null) {
    			opcion = OPCION_SALIR;
    		} else {
    			procesarOpcion(opcion);
    		}
    		
    	} while (opcion != OPCION_SALIR);
    	
    	System.out.println("Saliendo del programa...");
    }
    
    public static void procesarOpcion(Integer opcion) {
		switch (opcion) {
			case 1 -> {
				
			}
			case 2 -> {
				
			}
		}
	}

	public static void mostrarMenu() {
    	System.out.println("1. Crear cuenta bancaria.");
    	System.out.println("2. Ingresar dinero.");
    	System.out.println("3. Retirar dinero.");
    	System.out.println("4. Realizar transferencia.");
    	System.out.printf("%d. Salir.\n", OPCION_SALIR);
    	
    	System.out.println();
    }
    
    public static boolean init() {
    	// Input usuario =========
    	Input.init();
    	 
    	// DAO ===================
    	try {
    		final String PERSISTENCE = "dam2.preexamen";
    		
			clienteDao = new GenericJPADAO<>(Cliente.class, PERSISTENCE);
			telefonoDao = new GenericJPADAO<>(Telefono.class, PERSISTENCE);
			cuentaEmpresaDao = new GenericJPADAO<>(CuentaEmpresa.class, PERSISTENCE);
			cuentaParticularDao = new GenericJPADAO<>(CuentaParticular.class, PERSISTENCE);
			
			// test
			clienteDao.findAll();
			telefonoDao.findAll();
			cuentaEmpresaDao.findAll();
			cuentaParticularDao.findAll();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
    	
    	return true;
    }
}
