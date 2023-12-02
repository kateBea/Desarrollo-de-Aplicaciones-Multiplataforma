package dam2.ejercicio1;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import dam2.utilidades_hibernate.GenericJPADAO;

/**
 * Ejercicio 1
 * 
 * a) Insertar tres clientes a la base de datos
 * b) Dar un premio de 5% el saldo al cliente con más saldo (usar streams)
 * c) Borrar a todos los clientes sin aval
 * 
 * */
public class App {
	public static void main(String... args) {
		final Function <Cliente ,String> TOSTRING = Cliente::toString;
		final Consumer<Cliente> MOSTRAR = System.out::println;
		final Runnable ERROR = () -> System.out.println("Error");
		
		// creamos conexión a la BD
		final GenericJPADAO <Cliente, String> DAO_CLIENTE =
				new GenericJPADAO<>(Cliente.class, "dam2.ejercicio1");
		
		// Ejercicio 1 - a
		List<Cliente> clientes = List.of(
				Cliente.builder().dni("12345678Y").nombre("Carlos").fechaNacimiento(LocalDate.now().minusYears(30)).saldo(12434.44f).aval(true).build(),
				Cliente.builder().dni("28657481P").nombre("Ana").fechaNacimiento(LocalDate.now().minusYears(27)).saldo(22234.44f).aval(true).build(),
				Cliente.builder().dni("73654672T").nombre("Pedro").fechaNacimiento(LocalDate.now().minusYears(25)).saldo(34434.44f).aval(false).build());
		
		
		for (Cliente cliente : clientes) {
			DAO_CLIENTE.save(cliente).ifPresentOrElse(MOSTRAR, ERROR);
		}
		
		// Ejercicio 1 - b
		final float INCREMENTO = 1.05f;
		Optional<Cliente> clientMasSaldo = DAO_CLIENTE
				.findAll()
				.stream()
				.max(Comparator.comparing(Cliente::getSaldo));
		
		if (clientMasSaldo.isPresent()) {
			clientMasSaldo.get().setSaldo(clientMasSaldo.get().getSaldo() * INCREMENTO);
			DAO_CLIENTE.update(clientMasSaldo.get()).ifPresentOrElse(MOSTRAR, ERROR);;
		}
		
		// Ejercicio 3 - c
		final Predicate<Cliente> NO_TIENE_AVAL =
			cliente -> !cliente.isAval();
			
		List<Cliente> aBorrar = DAO_CLIENTE
				.findAll()
				.stream()
				.filter(NO_TIENE_AVAL).
				toList();
		
		for (Cliente cliente : aBorrar) {
			DAO_CLIENTE.delete(cliente).ifPresentOrElse(MOSTRAR, ERROR);
		}
	}
}
