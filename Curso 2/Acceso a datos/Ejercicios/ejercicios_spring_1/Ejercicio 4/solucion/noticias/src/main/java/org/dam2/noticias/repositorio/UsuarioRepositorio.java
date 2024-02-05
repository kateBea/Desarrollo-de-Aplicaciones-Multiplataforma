package org.dam2.noticias.repositorio;

import org.dam2.noticias.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, String> {

}
