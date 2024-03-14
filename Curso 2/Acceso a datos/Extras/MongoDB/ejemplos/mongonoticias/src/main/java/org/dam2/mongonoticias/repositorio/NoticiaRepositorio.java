package org.dam2.mongonoticias.repositorio;

import org.dam2.mongonoticias.modelo.Noticia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepositorio extends 
											MongoRepository<Noticia, Long>, 
											AgregacionRepositorio{
	

}
