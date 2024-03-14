package org.dam2.mongonoticias.repositorio;

import org.dam2.mongonoticias.modelo.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {
	
	@Query("{nickName:'?0'}")
    Usuario findItemByName(String nickName);
	
	
	public long count();

}

