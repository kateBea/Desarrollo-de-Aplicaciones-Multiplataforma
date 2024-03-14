package org.dam2.mongonoticias.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.mongonoticias.modelo.Usuario;



public interface IUsuarioServicio {
	public boolean insertar (Usuario usuario);
	public Optional<Usuario> findByNickName (String nickName);
	public List<Usuario> findAll ();
	public boolean update (Usuario usuario);
	public boolean delete (String nickName);
}
