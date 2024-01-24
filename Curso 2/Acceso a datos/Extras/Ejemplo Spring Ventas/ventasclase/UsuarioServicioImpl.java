package com.dam2.ventas.servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dam2.ventas.modelo.Usuario;
import com.dam2.ventas.repositorio.NombreYSaldo;
import com.dam2.ventas.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
	
	@Autowired
	UsuarioRepositorio usuarioDAO;

	@Override
	public Optional<Usuario> insertar(Usuario usuario) {
		// TODO Auto-generated method stub
		Optional<Usuario> newUsuario = Optional.empty();
		
		if (!usuarioDAO.existsById(usuario.getNif()) &&
				usuario.getSaldo()> 500)
		{
			usuario = usuarioDAO.save(usuario);
			newUsuario = Optional.of(usuario);
		}
		
		return newUsuario;
	}

	@Override
	public boolean eliminar(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean borrado = false;
		if (usuarioDAO.existsById(usuario.getNif()))
		{
			usuarioDAO.delete(usuario);
			borrado = true;
		}
		return true;
	}

	@Override
	public Stream<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		List <Usuario> usuarios;
		
		usuarios = (List<Usuario>) usuarioDAO.findAll();
		
		return usuarios.stream();
	}

	@Override
	public List<Usuario> obtenerUsuariosPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Sort sort = Sort.by("nombre").and(Sort.by("saldo"));
		
		Pageable pageable = Pageable.ofSize(10).first();
		Page<Usuario> page = usuarioDAO.findByNombre(nombre,pageable);
		return page.toList();
	}

	@Override
	public List<NombreYSaldo> obtenerSaldos(String nombre, float saldo) {
		// TODO Auto-generated method stub
		return usuarioDAO.findByNombreAndSaldoLessThan(nombre, saldo);
	}

	@Override
	@Transactional
	public Integer actualizarSaldos() {
		// TODO Auto-generated method stub
		int n=0;
		usuarioDAO.actualizarSaldo();
		if (n == 0)
			throw new RuntimeException();
		return  0;
	}

}
