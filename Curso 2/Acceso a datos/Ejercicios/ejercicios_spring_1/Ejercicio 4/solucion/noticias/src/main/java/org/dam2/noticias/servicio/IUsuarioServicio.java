package org.dam2.noticias.servicio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.dam2.noticias.modelo.Noticia;
import org.dam2.noticias.modelo.Usuario;

public interface IUsuarioServicio {
	public boolean insertar (Usuario usuario);
	public Optional<Usuario> findByNickName (String nickName);
	public List<Usuario> findAll ();
	public boolean update (Usuario usuario);
	public boolean delete (String nickName);
	
}
