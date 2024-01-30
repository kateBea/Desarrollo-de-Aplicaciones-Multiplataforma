package dam2.blog.app.servicio;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.blog.app.modelo.Comentario;
import dam2.blog.app.repositorio.ComentarioRepositorio;

@Service
public class ComentarioServicioImpl implements ComentarioServicio {

	@Autowired
	ComentarioRepositorio repositorio;
	
	
	@Override
	public Set<Comentario> buscarPorUsuario(String nick) {
		return repositorio.findUserCommentsById(nick);
	}

	@Override
	public Optional<Comentario> insertar(Comentario comentario) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(comentario));
	}

	@Override
	public Optional<Comentario> actualizar(Comentario comentario) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(comentario));
	}

	@Override
	public boolean existePorId(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.existsById(id);
	}

	@Override
	public boolean borrarPorId(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
		
		return existePorId(id);
	}

}
