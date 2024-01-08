package dam2.preexamen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

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
	private static GenericJPADAO<Cuenta, String> cuentaDao;
	private static GenericJPADAO<CuentaEmpresa, String> cuentaEmpresaDao;
	private static GenericJPADAO<CuentaParticular, String> cuentaParticularDao;
	
	private static final int OPCION_SALIR = 10;
	
    public static void main( String[] args )
    {
    	// Inicialización
    	if (!init()) {
    		return;
    	}
    	
    	Integer opcion;
    	
    	System.out.println("\n=================================");
    	System.out.println("  APLICACIÓN ENTIDAD FINANCIERA  ");
    	System.out.println("=================================\n");
    	
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
			case 1 -> opcion1();
			case 2 -> opcion2();
			case 3 -> opcion3();
			case 4 -> opcion4();
			case 5 -> opcion5();
			case 6 -> opcion6();
			case 7 -> opcion7();
			case 8 -> opcion8();
			case 9 -> opcion9();
		}
	}

    public static void opcion1() {
		// Leer clientes de la cuenta
    	List<Cliente> clientes = new ArrayList<>();
    	Integer limitClientes = Input.leerEntero("Introduce total de clientes: ");
    	
    	if (limitClientes != null) {
    		for (int count = 0; count < limitClientes; ++count) {
    			Cliente resultado = Cliente.leer();
    			clientes.add(resultado);
    		}
    	}
    	
    	// Leer la cuenta
    	Cuenta cuenta = Cuenta.leer(clientes);
    	
    	// Serializar datos
    	for (Cliente cliente : clientes) {
    		clienteDao.save(cliente);
    	}
    	
    	cuentaDao.save(cuenta);
	}
    
    public static void opcion2() {
		final String numeroCuenta = Input.leerCadena("Introduce el número de cuenta: ");
		final String nifCliente = Input.leerCadena("Introduce el NIF del cliente: ");
		
		Optional<Cuenta> cuenta = cuentaDao.findById(numeroCuenta);
		Optional<Cliente> cliente = clienteDao.findById(nifCliente);
		
		if (cuenta.isEmpty()) {
			System.err.println("La cuenta no existe");
			return;
		}
		
		if (cliente.isEmpty()) {
			System.err.println("El cliente no existe");
			return;
		}
		
		if (!cuenta.get().esPropietario(nifCliente)) {
			System.err.println("El cliente no es propietario de la cuenta.");
			return;
		}
		
		final Double ingreso = Input.leerReal("Introduzca la cantidad a ingresar: ");
		if (cuenta.get().ingresar(ingreso) == -1) {
			System.err.println("Error al hacer el ingreso.");
			return;
		}
		
		// serializar cambios sobre la cuenta
		// si se ha podido hacer el ingreso correctamente
		cuentaDao.save(cuenta.get());
	}
    
    public static void opcion3() {
    	final String numeroCuenta = Input.leerCadena("Introduce el número de cuenta: ");
		final String nifCliente = Input.leerCadena("Introduce el NIF del cliente: ");
		
		Optional<Cuenta> cuenta = cuentaDao.findById(numeroCuenta);
		Optional<Cliente> cliente = clienteDao.findById(nifCliente);
		
		if (cuenta.isEmpty()) {
			System.err.println("La cuenta no existe");
			return;
		}
		
		if (cliente.isEmpty()) {
			System.err.println("El cliente no existe");
			return;
		}
		
		if (!cuenta.get().esPropietario(nifCliente)) {
			System.err.println("El cliente no es propietario de la cuenta.");
			return;
		}
		
		final Double retirada = Input.leerReal("Introduzca la cantidad a retirar: ");
		if (cuenta.get().retirar(retirada) == -1) {
			System.err.println("Error al hacer la retirada.");
			return;
		}
		
		// serializar cambios sobre la cuenta
		// se se ha podido hacer la retirada
		cuentaDao.save(cuenta.get());
	}
    
    public static void opcion4() {
    	final String numeroCuentaOrigen = Input.leerCadena("Introduce el número de cuenta origen: ");
    	final String numeroCuentaDestino = Input.leerCadena("Introduce el número de cuenta destino: ");
		final String nifCliente = Input.leerCadena("Introduce el NIF del cliente que transfiere: ");
		
		Optional<Cuenta> cuentaOrigen = cuentaDao.findById(numeroCuentaOrigen);
		Optional<Cuenta> cuentaDestino = cuentaDao.findById(numeroCuentaDestino);
		Optional<Cliente> cliente = clienteDao.findById(nifCliente);
		
		if (cuentaOrigen.isEmpty()) {
			System.err.println("La cuenta origen no existe");
			return;
		}
		
		if (cuentaDestino.isEmpty()) {
			System.err.println("La cuenta destino no existe");
			return;
		}
		
		if (cliente.isEmpty()) {
			System.err.println("El cliente no existe");
			return;
		}
		
		if (!cuentaOrigen.get().esPropietario(nifCliente)) {
			System.err.println("El cliente no es propietario de la cuenta origen.");
			return;
		}
		
		final Double ingreso = Input.leerReal("Introduzca la cantidad a transferir: ");
		if (!cuentaOrigen.get().transferir(cuentaDestino.get(), ingreso)) {
			System.err.println("No se pudo realizar la transferencia.");
			return;
		}
		
		// serializar cambios sobre la cuenta
		// si se ha podido hacer la transferencia
		cuentaDao.save(cuentaOrigen.get());
		cuentaDao.save(cuentaDestino.get());
	}
    
	public static void opcion5() {
		
	}
	
	public static void opcion6() {
		
	}
	
	public static void opcion7() {
		
	}
	
	public static void opcion8() {
		
	}
	
	public static void opcion9() {
		final Predicate<Cuenta> SALDO_NEGATIVO =
			cuenta -> cuenta.getSaldo() < 0.0;
			
		cuentaDao.findAll().stream()
			.filter(SALDO_NEGATIVO)
			.sorted((lhs, rhs) -> Double.compare(lhs.getSaldo(), rhs.getSaldo()))
			.forEach(System.out::println);
	}

	public static void mostrarMenu() {
    	System.out.println("1. Crear cuenta bancaria.");
    	System.out.println("2. Ingresar dinero.");
    	System.out.println("3. Retirar dinero.");
    	System.out.println("4. Realizar transferencia.");
    	System.out.println("5. Consultar saldo de una cuenta.");
    	System.out.println("6. Consultar saldo de la entidad financiera.");
    	System.out.println("7. Consultar datos de cliente con saldo máximo.");
    	System.out.println("8. Consultar companía con más clientes.");
    	System.out.println("9. Consultar cuentas empresariales con saldo negativo (ordenadas de menor a mayor por saldo).");
    	System.out.printf("%d. Salir.\n", OPCION_SALIR);
    	
    	System.out.println();
    }
    
    public static boolean init() {
    	// Input usuario =========
    	Input.init();
    	 
    	// DAO ===================
    	try {
    		final String PERSISTENCE = "dam2.preexamen";
    		
    		cuentaDao = new GenericJPADAO<>(Cuenta.class, PERSISTENCE);
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
