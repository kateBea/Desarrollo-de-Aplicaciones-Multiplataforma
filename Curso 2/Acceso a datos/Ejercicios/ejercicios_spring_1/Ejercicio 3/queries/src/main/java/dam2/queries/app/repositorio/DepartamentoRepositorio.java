package dam2.queries.app.repositorio;

import org.springframework.stereotype.Repository;

import dam2.queries.app.modelo.Departamento;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface DepartamentoRepositorio extends CrudRepository<Departamento, Integer> {

}
