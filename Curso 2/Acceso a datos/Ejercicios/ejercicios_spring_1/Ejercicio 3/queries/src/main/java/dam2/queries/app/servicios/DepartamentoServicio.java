package dam2.queries.app.servicios;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dam2.queries.app.modelo.Departamento;
import dam2.queries.app.repositorio.EmpleadoRepositorio;

@Service
public interface DepartamentoServicio extends EmpleadoRepositorio{
	Optional<Departamento> buscarPorClave(Integer id);
}