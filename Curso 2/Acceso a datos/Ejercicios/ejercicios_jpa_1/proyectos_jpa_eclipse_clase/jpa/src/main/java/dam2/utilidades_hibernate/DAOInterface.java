package dam2.utilidades_hibernate;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface DAOInterface <T,K> {
	
	public Optional<T> findById(K key);
	
	public  List<T> findAll();
	
	public Optional<T> delete(T ov);
	
	public Optional<T> save(T ov);
	
	public Optional<T> update(T ov);
	
	public Stream executeQuery (String query, Object... params);
	
	public Optional executeQuerySingleResult (String query, Object... params);
	
	public Stream executeQueryNamed (String nameQuery, Object... params);
	
	public Optional executeQueryNamedSingleResult (String nameQuery, Object... params);
}

