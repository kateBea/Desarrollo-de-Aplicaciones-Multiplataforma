package dam2.repoqueries.app.servicio;

import java.util.Optional;
import java.util.Set;

import dam2.repoqueries.app.modelo.Departamento;

public interface DepartamentoServicio {
	Set<Departamento>		findAll();
	Optional<Departamento>	buscarPorClave(Integer id);
	Optional<Departamento>	insertar(Departamento departamento);
	Optional<Departamento>	actualizar(Departamento departamento);
	boolean					borrarPorClave(Integer id);
	boolean 				existePorClave(Integer id);
}