package org.dam2.utilidadeshibernate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQueries;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class GenericJPADAO <T,K> implements DAOInterface <T,K>{
	
	private  final static String PERSITENCEUNITNAME = "hibernate";
	
	private final Class <T> entityClass;
	private final String persitenceUnitName;
	

	public GenericJPADAO(Class<T> entityClass) {
		this.entityClass = entityClass;
		persitenceUnitName = PERSITENCEUNITNAME;
	}
	
	public GenericJPADAO(Class<T> entityClass, String persitenceUnitName) {
		this.entityClass = entityClass;
		this.persitenceUnitName = persitenceUnitName;
	}

	@Override
	public Optional<T> findById(K key) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emFactory = EntityManagerFactorySingleton.getInstance(persitenceUnitName).getEmf();
		
		EntityManager em = emFactory.createEntityManager();
		
		Optional<T> result = Optional.ofNullable(em.find(entityClass, key));
		
		em.close();
		
		return result;
	}

	@Override
	public Iterable<T> findAll() {
		// TODO Auto-generated method stub
		List<T> result;
		String jpaQuery;
		
		EntityManagerFactory emFactory = EntityManagerFactorySingleton.getInstance(persitenceUnitName).getEmf();
		
		EntityManager em = emFactory.createEntityManager();

		jpaQuery = "SELECT o FROM " + entityClass.getSimpleName() + " o";
		Query query= em.createQuery(jpaQuery);
		
				
		result = query.getResultList();

		em.close();
		
		return result;
	}

	@Override
	public T delete(T ov) {
		// TODO Auto-generated method stub
		EntityManagerFactory emFactory = EntityManagerFactorySingleton.getInstance(persitenceUnitName).getEmf();
		
		EntityManager em = emFactory.createEntityManager();	
		

		Object key = getKey (ov);
		
		if (key != null)
		{
			try {
				em.getTransaction().begin();
				ov = em.find(entityClass, key);
				
				if (ov != null)
					em.remove(ov);
				else
					ov = null;
				em.getTransaction().commit();
			
			}
			catch (Exception e)
			{
				System.out.println(e.toString());
				ov = null;
			}
			
			finally {
				em.close();
			}
		}
		else
			ov = null;
		
		return ov;

	}

	@Override
	public T save(T ov) {
		// TODO Auto-generated method stub
		EntityManagerFactory emFactory = EntityManagerFactorySingleton.getInstance(persitenceUnitName).getEmf();
		
		EntityManager em = emFactory.createEntityManager();	
		
		Object key = getKey (ov);
		
		if (isGeneratedValue(ov) ||key != null)
		{
			try {
				em.getTransaction().begin();
				
				
				if (isGeneratedValue(ov) ||em.find(entityClass, key) == null)
				{

					ov = em.merge(ov);

					
				}
				else
					throw new EntityExistsException ();
				
				em.getTransaction().commit();
			
			}
			catch (Exception e)
			{
				e.printStackTrace();
				ov = null;
			}
			
			finally {
				em.close();
			}
		}
		else
			ov = null;
		
		return ov;
	
	}

	@Override
	public T update(T ov) {
		// TODO Auto-generated method stub
		EntityManagerFactory emFactory = EntityManagerFactorySingleton.getInstance(persitenceUnitName).getEmf();
		
		EntityManager em = emFactory.createEntityManager();	
		
		try {
			em.getTransaction().begin();
		
			ov = em.merge(ov);
			
			em.getTransaction().commit();
		
		}
		catch (Exception e)
		{
			ov = null;
		}
		
		finally {
			em.close();
		}
		
		return ov;
	}
	
	private boolean isGeneratedValue (Object object)
	{
		// Comprobar si el atributo tiene una anotación Id
		Predicate<Field> isGenerated = f -> Arrays.stream(f.getAnnotations()).
												anyMatch(a ->a.annotationType().getSimpleName().contains("GeneratedValue"));
		
		// Obtener atributo clave
		Optional<Field> field = Arrays.stream(entityClass.getDeclaredFields()).filter(isGenerated).findFirst();
		
		return !field.isEmpty();
	}
	private Object getKey (Object object)  
	{
		
		String nameGet;
		Object valor = null;
		boolean key;
		
		
		// Comprobar si el atributo tiene una anotación Id
		Predicate<Field> isKey = f -> Arrays.stream(f.getAnnotations()).
										anyMatch(a ->a.annotationType().getSimpleName().contains("Id"));
		
		// Obtener atributo clave
		Optional<Field> field = Arrays.stream(entityClass.getDeclaredFields()).filter(isKey).findFirst();
		
		if (field.isPresent())
		{
			// Crear método get de la clave
			Field f = field.get();
			
			nameGet = "get" + f.getName().substring(0, 1).toUpperCase()+ f.getName().substring(1);

			
			// Obtener el valor de la clave
			try {
				valor = entityClass.getDeclaredMethod(nameGet, null).invoke(object, null);

			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				
				valor = null;
			}
		}		

		return valor;
	}
	
	
	public Stream executeQuery (String query, Object... params)
	{

		Stream result;
		EntityManagerFactory emFactory = EntityManagerFactorySingleton.getInstance(persitenceUnitName).getEmf();
		
		EntityManager em = emFactory.createEntityManager();
		
		Query q = em.createQuery(query);
		for (int i = 0; i < params.length; i++)
			q.setParameter(i+1, params[i]);
	
		if (isUpdateQuery(query))
		{
			try {
				em.getTransaction().begin();
			
				result = Stream.of(q.executeUpdate());
				
				em.getTransaction().commit();
			
			}
			catch (Exception e)
			{
				result = Stream.empty();
			}
			
		}
		else
			//result = q.getResultStream();
			result = q.getResultList().stream();
		
		return result;
	}

	private boolean isUpdateQuery(String q) {
		// TODO Auto-generated method stub
		
		
		return !q.split(" ")[0].equalsIgnoreCase("select");
	}

	@Override
	public Stream executeQueryNamed(String nameQuery, Object... params) {
		// TODO Auto-generated method stub
		EntityManagerFactory emFactory = EntityManagerFactorySingleton.getInstance(persitenceUnitName).getEmf();
		
		EntityManager em = emFactory.createEntityManager();
						
		
		Query q = em.createNamedQuery(nameQuery);
		
		for (int i = 0; i < params.length; i++)
			q.setParameter(i+1, params[i]);
		
		
		//return q.getResultStream();
		return q.getResultList().stream();
	}

	@Override
	public Optional executeQuerySingleResult(String query, Object... params) {
		// TODO Auto-generated method stub
		return executeQuery(query,params).findFirst();
	}

	@Override
	public Optional executeQueryNamedSingleResult(String nameQuery, Object... params) {
		// TODO Auto-generated method stub
		EntityManagerFactory emFactory = EntityManagerFactorySingleton.getInstance(persitenceUnitName).getEmf();
		EntityManager em = emFactory.createEntityManager();
						
		
		Query q = em.createNamedQuery(nameQuery);
		
		for (int i = 0; i < params.length; i++)
			q.setParameter(i+1, params[i]);
		
		

		return Optional.ofNullable(q.getSingleResult());
	}
	
}
