package h2.test;

import java.util.List;
import java.util.Optional;

public interface DAOInterface <T,K> {
	
	public Optional<T> findById(K key);
	
	public  Iterable<T> findAll();
	
	public int delete(T ov);
	
	public int save(T ov);

	public int update(T ov);
}

