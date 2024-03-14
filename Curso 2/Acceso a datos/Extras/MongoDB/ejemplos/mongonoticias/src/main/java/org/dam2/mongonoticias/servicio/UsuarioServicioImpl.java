package org.dam2.mongonoticias.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.mongonoticias.modelo.Usuario;
import org.dam2.mongonoticias.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio {
	
	@Autowired private UsuarioRepositorio usuarioDAO;

	@Override
	public boolean insertar(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (usuarioDAO.findItemByName(usuario.getNickName())== null)
		{
			usuarioDAO.insert(usuario);
			exito = true;
		}
		return exito;
	}

	@Override
	public Optional<Usuario> findByNickName(String nickName) {
		// TODO Auto-generated method stub
		
		
		return Optional.ofNullable(usuarioDAO.findItemByName(nickName));
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		
		return usuarioDAO.findAll();
	}

	@Override
	public boolean update(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (usuarioDAO.findItemByName(usuario.getNickName())!= null)
		{
			usuarioDAO.save(usuario);
			exito = true;
		}
		return exito;
	}

	@Override
	public boolean delete(String nickName) {
		// TODO Auto-generated method stub
		boolean exito = false;
		Usuario usuario = usuarioDAO.findItemByName(nickName);
		if (usuario != null)
		{
			usuarioDAO.delete(usuario);
			exito = true;
		}
		
		return exito;
		
	}

}
