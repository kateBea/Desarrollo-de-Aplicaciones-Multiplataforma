package dam2.blog.app.servicio;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.blog.app.modelo.Comentario;

@Service
public interface ComentarioServicio {
	Set<Comentario> buscarPorUsuario(String nick);
	Optional<Comentario> insertar(Comentario comentario);
	Optional<Comentario> actualizar(Comentario comentario);
}
