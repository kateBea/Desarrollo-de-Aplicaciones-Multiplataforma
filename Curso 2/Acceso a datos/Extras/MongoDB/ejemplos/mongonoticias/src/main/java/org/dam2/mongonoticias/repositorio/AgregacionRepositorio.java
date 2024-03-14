package org.dam2.mongonoticias.repositorio;

import java.util.List;

import org.dam2.mongonoticias.modelo.Noticia;

public interface AgregacionRepositorio {
	List<Noticia> query (String titulo);

}
