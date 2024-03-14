package org.dam2.mongonoticias.repositorio;

import java.util.List;

import org.dam2.mongonoticias.modelo.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;

public class AgregacionRepositorioImpl implements AgregacionRepositorio {

	@Autowired MongoTemplate mongoTemplate;
	@Override
	public List<Noticia> query(String titulo) {
		// TODO Auto-generated method stub
		MatchOperation filterTitulo = Aggregation.match(new Criteria("titulo").is(titulo));
		
		Aggregation aggregation = Aggregation.newAggregation(filterTitulo);
		
		AggregationResults<Noticia> result = mongoTemplate.aggregate(aggregation, "noticia", Noticia.class);
		
		
		return result.getMappedResults();
	}

}
