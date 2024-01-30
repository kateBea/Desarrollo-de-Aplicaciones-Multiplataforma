package dam2.blog.app.servicio;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.blog.app.modelo.Noticia;

@Service
public class NoticiaServicioImpl implements NoticiaServicio {

	@Override
	public Optional<Noticia> buscarPorClave(String titulo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Noticia> insertar(Noticia noticia) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Noticia> actualizar(Noticia noticia) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Set<Noticia> buscarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existePorClave(String titulo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrarPorClave(String titulo) {
		// TODO Auto-generated method stub
		return false;
	}

}
