package dam2.instirest;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import dam2.instirest.model.Instituto;

public class ClienteRest {
	private static final String URLBASE_INSTI = "http://localhost:8080/instituto/institutos/";
	private static final String URLBASE_PROFE = "http://localhost:8080/instituto/profesores/";
	private static final String URLBASE_ESTUD = "http://localhost:8080/instituto/estudiantes/";
	private static final String URLBASE_EMAIL = "http://localhost:8080/instituto/emails/";
	
	private static final RestTemplate REST_TEMPLATE = new RestTemplate();
	
	public static void main(String[] args) {
		// Depuración
		// hacerConsultas();
		
		
	}

	private static void hacerConsultas() {
		// TODO Auto-generated method stub
		List<Instituto> institutos = List.of(
			REST_TEMPLATE.getForEntity(URLBASE_INSTI + "consultar", Instituto[].class).getBody());
		
		for (Instituto instituto : institutos) {
			System.out.println(instituto);
		}
		
	}
}
