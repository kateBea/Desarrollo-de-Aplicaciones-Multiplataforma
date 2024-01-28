package dam2.repoqueries.app.repositorio;

import org.springframework.stereotype.Repository;

import dam2.repoqueries.app.modelo.Departamento;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface DepartamentoRepositorio extends CrudRepository<Departamento, Integer> {

}
