package dam2.biblioteca.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.biblioteca.modelo.Sancion;
import dam2.biblioteca.repositorio.ISancionRepo;

@Service
public class SancionServImpl implements ISancionServ {

	@Autowired
	ISancionRepo sancionRepo;
	
	@Override
	public Optional<Sancion> buscarPorId(String id) {
		// TODO Auto-generated method stub
		return sancionRepo.findById(id);
	}

	@Override
	public boolean existePorId(String id) {
		// TODO Auto-generated method stub
		return sancionRepo.existsById(id);
	}

	@Override
	public Optional<Sancion> insertar(Sancion sancion) {
		// TODO Auto-generated method stub
		return Optional.of(sancionRepo.save(sancion));
	}

	@Override
	public Optional<Sancion> modificar(Sancion sancion) {
		// TODO Auto-generated method stub
		return Optional.of(sancionRepo.save(sancion));
	}

	@Override
	public boolean borrarPorId(String id) {
		// TODO Auto-generated method stub
		sancionRepo.deleteById(id);
		
		return existePorId(id);
	}

}
