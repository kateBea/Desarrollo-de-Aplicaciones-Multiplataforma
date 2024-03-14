package org.dam2.mongonoticias.repositorio;

import java.util.List;

import org.dam2.mongonoticias.modelo.Lugar;
import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LugarRepositorio extends MongoRepository<Lugar, String> {
	
	List<Lugar> findByPosicionWithin (Polygon polygon);

}
