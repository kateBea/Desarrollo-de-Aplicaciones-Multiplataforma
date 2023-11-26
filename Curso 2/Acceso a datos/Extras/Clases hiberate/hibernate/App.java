package org.dam2.hibernate;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.dam2.utilidadeshibernate.EntityManagerFactorySingleton;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	// Crear la conexión entre la BBDD y el ORM
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
    	EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance("hibernate").getEmf();
        EntityManager em = factory.createEntityManager();
        

        // guardar alumno
        
        Alumno alumno = Alumno.builder().
        				firstName("ana").
        				fecha(LocalDate.now()).
        				build();
        
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();

        
        // buscar alumno por clave
        Alumno  a1 = (Alumno)em.find(Alumno.class, 1);
        System.out.println(a1);
        
        // Con parámetros busca uno
        // Query en lenguaje JPQL
        Query query1 = em.createQuery("Select a From Alumno a  where a.firstName = :name");
        query1.setParameter("name", "ana");
        
        Alumno ana = (Alumno) query1.getSingleResult();
        
        System.out.println("búsqueda con parámetros");
        System.out.println(ana);

        
        // Buscar todos los alumunos
        // Query en lenguaje JPQL
        Query query = em.createQuery("Select a From Alumno a", Alumno.class);
        List<Alumno> resultList = query.getResultList();
      
        System.out.println("todos los alumnos");
        resultList.forEach(System.out::println);
        
        
        // Actualizar alumno
        em.getTransaction().begin();
        
        a1 = Alumno.builder().
        				id(1).
        				firstName("miguel").
        				fecha(LocalDate.now()).
        				build();
        
        em.merge(a1);
        
        em.getTransaction().commit();
        
        
        // Mostrar alumno actualizado
        a1 = (Alumno)em.find(Alumno.class, 1);
        System.out.println(a1);
        
        // Borrar alumno
        em .getTransaction().begin();
        a1 = (Alumno)em.find(Alumno.class, 1);
        if (a1 != null)
        	em.remove(a1);
        em.getTransaction().commit();
       
        // Mostrar alumno borrado
        a1 = (Alumno)em.find(Alumno.class, 1);
        if (a1 ==  null)
        	System.out.println("alumno no encontrado");
        
        em.close();
    }
}
