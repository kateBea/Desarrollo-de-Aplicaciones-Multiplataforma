package dam2.blog.app.servicio;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.blog.app.modelo.Noticia;


@Service
public interface NoticiaServicio {
	Optional<Noticia> buscarPorClave(String titulo);
	Optional<Noticia> insertar(Noticia noticia);
	Optional<Noticia> actualizar(Noticia noticia);
	
	Set<Noticia> buscarTodas();
	
	boolean existePorClave(String titulo);
	boolean borrarPorClave(String titulo);
}
