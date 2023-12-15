package org.repositorio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.utilidades_hibernate.GenericJPADAO;

public class Queries implements Runnable {
	private GenericJPADAO<Empleado, Integer> daoEmpleados;
	private GenericJPADAO<Departamento, Integer> daoDepartamentos;
	
	private boolean wantWriteToFile;
	private FileOutputStream fileOutputStream;
    private PrintStream printStream;
    
	final private String FILE_OUTPUT = "output.txt";
    
	final private Consumer<Object> PRINTER = System.out::println;
	
	final private Consumer<Object[]> LIST_PRINTER = array -> 
			System.out.println(Stream.of(array).reduce((v1, v2) -> v1.toString() + " | " + v2.toString()).orElse("No hay datos"));
			
			

	public Queries(GenericJPADAO<Empleado, Integer> dao1, GenericJPADAO<Departamento, Integer> dao2, boolean wantWriteToFile) {
		this.daoEmpleados = dao1;
		this.daoDepartamentos = dao2;
		this.wantWriteToFile = wantWriteToFile;
		
		if (wantWriteToFile) {
			try {
				// redirigir entrada si se prefiere (la consola tiene buffer limitado)
				fileOutputStream = new FileOutputStream(FILE_OUTPUT);
		        printStream = new PrintStream(fileOutputStream);
		        System.setOut(printStream);
		        System.setErr(printStream);
				
			} catch (FileNotFoundException e) {
	            System.err.println(e.getMessage());
	        }
		}
		
	}
	
	@Override
	public void run() {
		// 1. Obtener los datos completos de los empleados.
		System.out.println("Query 1");
		daoEmpleados.executeQuery("SELECT e FROM Empleado e").forEach(PRINTER);
		
		
		// 2. Obtener los datos completos de los departamentos
		System.out.println("Query 2");
		daoDepartamentos.executeQuery("SELECT d FROM Departamento d").forEach(PRINTER);
		
		
		// 3. Obtener los datos de los empleados con cargo 'Secretaria'.
		System.out.println("Query 3");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.cargo LIKE ?1", "Secretaria").forEach(PRINTER);
		
		
		// 4. Obtener el nombre y salario de los empleados.
		System.out.println("Query 4");
		daoEmpleados.executeQuery("SELECT e.nombre, e.salario\n"
				+ "FROM Empleado e").forEach(LIST_PRINTER);
		
		
		// 5. Obtener los datos de los empleados vendedores, ordenado por nombre.
		System.out.println("Query 5");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.departamento.nombre LIKE ?1\n"
				+ "ORDER BY e.nombre ASC", "VENTAS").forEach(PRINTER);
		
		
		// 6. Listar el nombre de los departamentos
		System.out.println("Query 6");
		daoEmpleados.executeQuery("SELECT DISTINCT d.nombre\n"
				+ "FROM Departamento d").forEach(PRINTER);
		
		
		// 7. Listar el nombre de los departamentos, ordenado por nombre
		System.out.println("Query 7");
		daoDepartamentos.executeQuery("SELECT DISTINCT d.nombre\n"
				+ "FROM Departamento d\n"
				+ "ORDER BY d.nombre").forEach(PRINTER);
		
		
		// 8. Listar el nombre de los departamentos, ordenado por ciudad
		System.out.println("Query 8");
		daoDepartamentos.executeQuery("SELECT d.nombre, d.ciudad\n"
				+ "FROM Departamento d\n"
				+ "ORDER BY d.ciudad").forEach(LIST_PRINTER);
		

		// 9. Listar el nombre de los departamentos, ordenado por ciudad, en orden inverso
		System.out.println("Query 9");
		daoDepartamentos.executeQuery("SELECT d.nombre, d.ciudad\n"
				+ "FROM Departamento d\n"
				+ "ORDER BY d.ciudad DESC").forEach(LIST_PRINTER);
		

		// 10. Obtener el nombre y cargo de todos los empleados, ordenado por salario
		System.out.println("Query 10");
		daoEmpleados.executeQuery("SELECT e.nombre, e.cargo\n"
				+ "FROM Empleado e\n"
				+ "ORDER BY e.salario DESC").forEach(LIST_PRINTER);
		

		// 11. Obtener el nombre y cargo de todos los empleados, ordenado por cargo y por salario
		System.out.println("Query 11");
		daoEmpleados.executeQuery("SELECT e.nombre, e.cargo, e.salario\n"
				+ "FROM Empleado e\n"
				+ "ORDER BY e.cargo, e.salario").forEach(LIST_PRINTER);
		

		// 12. Obtener el nombre y cargo de todos los empleados, en orden inverso por cargo
		System.out.println("Query 12");
		daoEmpleados.executeQuery("SELECT e.nombre, e.cargo\n"
				+ "FROM Empleado e\n"
				+ "ORDER BY e.cargo DESC").forEach(LIST_PRINTER);
		

		// 13. Listar los salarios y comisiones de los empleados del departamento 2000
		System.out.println("Query 13");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.departamento.codigo = ?1", 2000).forEach(PRINTER);
		

		// 14. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comisión
		System.out.println("Query 14");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.departamento.codigo = ?1"
				+ "ORDER BY e.comision", 2000).forEach(PRINTER);
		

		// 15. Listar todas las comisiones
		System.out.println("Query 15");
		daoEmpleados.executeQuery("SELECT e.comision\n"
				+ "FROM Empleado e").forEach(PRINTER);
		

		// 16. Listar las comisiones que sean diferentes, ordenada por valor
		System.out.println("Query 16");
		daoEmpleados.executeQuery("SELECT DISTINCT e.comision\n"
				+ "FROM Empleado e\n"
				+ "ORDER BY e.comision").forEach(PRINTER);
		

		// 17. Listar los diferentes salarios
		System.out.println("Query 17");
		daoEmpleados.executeQuery("SELECT DISTINCT e.salario\n"
				+ "FROM Empleado e").forEach(PRINTER);
		

		// 18. Obtener el valor total a pagar que resulta de sumar a los empleados del departamento 3000 una bonificación de $500.000, en orden alfabético del empleado
		System.out.println("Query 18");
		
		

		// 19. Obtener la lista de los empleados que ganan una comisión superior a su sueldo
		System.out.println("Query 19");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.comision > e.salario").forEach(PRINTER);
		

		// 20. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo
		System.out.println("Query 20");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.comision <= 0.3 * e.salario").forEach(PRINTER);
		

		// 21. Elaborar un listado donde para cada fila, figure ‘Nombre’ y ‘Cargo’ antes del valor respectivo para cada empleado
		System.out.println("Query 21");
		daoEmpleados.executeQuery("SELECT e.nombre, e.cargo\n"
				+ "FROM Empleado e").forEach(LIST_PRINTER);
		

		// 22. Hallar el salario y la comisión de aquellos empleados cuyo número de documento de identidad es superior al '19.709.802'
		System.out.println("Query 22");
		daoEmpleados.executeQuery("SELECT e.comision, e.salario\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.id > ?1", 19709802).forEach(LIST_PRINTER);
		

		// 23. Listar los empleados cuyo salario es menor o igual que el 40% de su comisión
		System.out.println("Query 23");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.salario <= 0.40 * e.comision").forEach(PRINTER);
		

		// 24. Divida los empleados, generando un grupo cuyo nombre inicie por la letra J y termine en la letra Z. Liste estos empleados y su cargo por orden alfabético.
		System.out.println("Query 24");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.nombre LIKE 'J%Z'").forEach(PRINTER);
		

		// 25. Listar el salario, la comisión, el salario total (salario + comisión), documento de identidad del empleado y nombre, de aquellos empleados que tienen comisión superior a $1.000.000, ordenar el informe por el número del documento de identidad
		System.out.println("Query 25");
		daoEmpleados.executeQuery("SELECT e.salario, e.comision, (e.salario + e.comision), e.id, e.nombre\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.comision > ?1\n"
				+ "ORDER BY e.id", 1000000.0f).forEach(LIST_PRINTER);
		

		// 26. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión
		System.out.println("Query 26");
		daoDepartamentos.executeQuery("SELECT e.salario, e.comision, (e.salario + e.comision), e.id, e.nombre\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.comision IS NULL\n"
				+ "ORDER BY e.id").forEach(LIST_PRINTER);
		

		// 27. Hallar el nombre de los empleados que tienen un salario superior a $1.000.000, y tienen como jefe al empleado con documento de identidad '31.840.269'
		System.out.println("Query 27");
		daoEmpleados.executeQuery("SELECT e.nombre\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.salario > ?1 AND e.jefe.id = ?2", 1000000.0f, 31840269).forEach(PRINTER);
		

		// 28. Hallar el conjunto complementario del resultado del ejercicio anterior.
		System.out.println("Query 28");
		daoEmpleados.executeQuery("SELECT e.nombre\n"
				+ "FROM Empleado e\n"
				+ "WHERE NOT (e.salario > ?1 AND e.jefe.id = ?2)", 1000000.0f, 31840269).forEach(PRINTER);
		

		// 29. Hallar los empleados cuyo nombre no contiene la cadena “MA”
		System.out.println("Query 29");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.nombre NOT LIKE '%MA%'").forEach(PRINTER);;
		

		// 30. Obtener los nombres de los departamentos que no sean “Ventas” ni “Investigación” ni ‘MANTENIMIENTO’, ordenados por ciudad.
		System.out.println("Query 30");
		daoDepartamentos.executeQuery("SELECT d.nombre\n"
				+ "FROM Departamento d\n"
				+ "WHERE d.nombre NOT IN (?1, ?2, ?3)", 
				"VENTAS", "INVESTIGACIÓN", "MANTENIMIENTO").forEach(PRINTER);;
		

		// 31. Obtener el nombre y el departamento de los empleados con cargo 'Secretaria' o 'Vendedor', que no trabajan en el departamento de “PRODUCCION”, cuyo salario es superior a $1.000.000, ordenados por fecha de incorporación.
		System.out.println("Query 31");
		daoDepartamentos.executeQuery("SELECT e.nombre, e.departamento\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.cargo NOT IN (?1, ?2) AND e.departamento IS NOT NULL AND e.departamento.nombre <> ?3 AND e.salario > ?4\n"
				+ "ORDER BY e.fechaIncorporacion", "Secretaria", "Vendedor", "PRODUCCION", 1000000.0f).forEach(LIST_PRINTER);
		

		// 32. Obtener información de los empleados cuyo nombre tiene exactamente 11 caracteres
		System.out.println("Query 32");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE LENGTH(e.nombre) = ?1", 11).forEach(PRINTER);
		

		// 33. Obtener información de los empleados cuyo nombre tiene al menos 11 caracteres
		System.out.println("Query 33");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE LENGTH(e.nombre) >= ?1", 11).forEach(PRINTER);
		

		// 34. Listar los datos de los empleados cuyo nombre inicia por la letra 'M', su salario es mayor a $800.000 o reciben comisión y trabajan para el departamento de 'VENTAS'
		System.out.println("Query 34");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.nombre LIKE 'M%' AND (e.salario > ?1 OR (e.comision IS NOT NULL AND e.departamento.nombre LIKE ?2))",
				800000.0f, "VENTAS").forEach(PRINTER);
		

		// 35. Obtener los nombres, salarios y comisiones de los empleados que reciben un salario situado entre la mitad de la comisión y la propia comisión
		System.out.println("Query 35");
		daoEmpleados.executeQuery("SELECT e.nombre, e.salario, e.comision\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.salario BETWEEN e.comision / 2 AND e.comision").forEach(LIST_PRINTER);
		

		// 36. Suponga que la empresa va a aplicar un reajuste salarial del 7%. Listar los nombres de los empleados, su salario actual y su nuevo salario, indicando para cada uno de ellos si tiene o no comisión
		System.out.println("Query 36");
		daoEmpleados.executeQuery("SELECT e.salario, e.salario * 1.07, e.comision\n"
				+ "FROM Empleado e").forEach(LIST_PRINTER);
		

		// 37. Obtener la información disponible del empleado cuyo número de documento de identidad sea: '31.178.144', '16.759.060', '1.751.219', '768.782', '737.689', '19.709.802', '31.174.099', '1.130.782'
		System.out.println("Query 37");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.id IN (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)\n"
				+ "ORDER BY e.departamento, e.departamento.nombre", 
				31178144, 16759060, 1751219, 768782, 737689, 19709802, 31174099, 1130782).forEach(PRINTER);
		

		// 38. Entregar un listado de todos los empleados ordenado por su departamento, y alfabético dentro del departamento.
		System.out.println("Query 38");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "ORDER BY e.departamento, e.departamento.nombre").forEach(PRINTER);

		// 39. Entregar el salario más alto de la empresa.
		System.out.println("Query 39");
		daoEmpleados.executeQuery("SELECT MAX(e.salario)\n"
				+ "FROM Empleado e").forEach(PRINTER);
		

		// 40. Entregar el total a pagar por comisiones, y el número de empleados que las reciben.
		System.out.println("Query 40");
		daoEmpleados.executeQuery("SELECT SUM(e.comision), COUNT(e.nombre)\n"
				+ "FROM Empleado e\n").forEach(LIST_PRINTER);
		

		// 41. Entregar el nombre del último empleado de la lista por orden alfabético.
		System.out.println("Query 41");
		daoEmpleados.executeQuery("SELECT MAX(e.nombre)\n"
				+ "FROM Empleado e").forEach(PRINTER);
		

		// 42. Hallar el salario más alto, el más bajo y la diferencia entre ellos.
		System.out.println("Query 42");
		daoEmpleados.executeQuery("SELECT MAX(e.salario), MIN(e.salario), MAX(e.salario) - MIN(e.salario)\n"
				+ "FROM Empleado e").forEach(LIST_PRINTER);
		

		// 43. Conocido el resultado anterior, entregar el nombre de los empleados que reciben el salario más alto y más bajo. Cuánto suman estos salarios?
		System.out.println("Query 43");
		


		// 44. Entregar el número de empleados de sexo femenino y de sexo masculino, por departamento.
		System.out.println("Query 44");
		daoEmpleados.executeQuery("SELECT e.sexo, COUNT(e.sexo), e.departamento.nombre\n"
				+ "FROM Empleado e\n"
				+ "GROUP BY e.departamento, e.sexo").forEach(LIST_PRINTER);

		
		// 45. Hallar el salario promedio por departamento.
		System.out.println("Query 45");
		daoDepartamentos.executeQuery("SELECT AVG(e.salario)\n"
				+ "FROM Empleado e INNER JOIN Departamento d ON e.departamento.codigo = d.codigo\n"
				+ "GROUP BY d.nombre").forEach(PRINTER);
		

		// 46. Hallar el salario promedio por departamento, considerando aquellos empleados cuyo salario supera $900.000, y aquellos con salarios inferiores a $575.000. Entregar el código y el nombre del departamento.
		System.out.println("Query 46");
		daoEmpleados.executeQuery("SELECT d.codigo, d.nombre, AVG(e.salario)\n"
				+ "FROM Empleado e INNER JOIN Departamento d ON e.departamento.codigo = d.codigo\n"
				+ "WHERE e.salario NOT BETWEEN ?1 AND ?2\n"
				+ "GROUP BY d.codigo", 575000.0f, 900000.0f).forEach(LIST_PRINTER);
		

		// 47. Entregar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa. Ordenarlo por departamento.
		System.out.println("Query 47");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.salario >= (SELECT AVG(e1.salario) FROM Empleado e1)").forEach(PRINTER);
		

		// 48. Hallar los departamentos que tienen más de tres (3) empleados. Entregar el número de empleados de esos departamentos.
		System.out.println("Query 48");
		daoEmpleados.executeQuery("SELECT COUNT(e.id), d.nombre\n"
				+ "FROM Empleado e INNER JOIN Departamento d ON e.departamento.codigo = d.codigo\n"
				+ "GROUP BY d.nombre\n"
				+ "HAVING COUNT(e.id) > 3").forEach(LIST_PRINTER);

		// 49. Obtener la lista de empleados jefes, que tienen al menos un empleado a su cargo. Ordene el informe inversamente por el nombre.
		System.out.println("Query 49");
		daoEmpleados.executeQuery("SELECT e\n"
				+ "FROM Empleado e\n"
				+ "WHERE e.id IN (SELECT e2.jefe.id FROM Empleado e2)\n"
				+ "AND (SELECT COUNT(e3) FROM Empleado e3 WHERE e3.jefe IS NOT NULL AND e3.jefe.id = e.id) > 1").forEach(PRINTER);

		// 50. Hallar los departamentos que no tienen empleados
		System.out.println("Query 50");
		daoDepartamentos.executeQuery("SELECT d.nombre\n"
				+ "FROM Departamento d\n"
				+ "WHERE d.codigo NOT IN (SELECT e.departamento.codigo FROM Empleado e WHERE e.departamento IS NOT NULL)").forEach(PRINTER);

		// 51. Entregar un reporte con el número de cargos en cada departamento y cual es el promedio de salario de cada uno. Indique el nombre del departamento en el resultado.
		System.out.println("Query 51");
		daoDepartamentos.executeQuery("SELECT COUNT(DISTINCT e.cargo), AVG(e.salario), d.nombre\n"
				+ "FROM Empleado e INNER JOIN Departamento d ON e.departamento.codigo = d.codigo\n"
				+ "GROUP BY d.nombre").forEach(LIST_PRINTER);

		// 52. Entregar el nombre del departamento cuya suma de salarios sea la más alta, indicando el valor de la suma.
		System.out.println("Query 52");
		
		

		// 53. Entregar un reporte con el código y nombre de cada jefe, junto al número de empleados que dirige. Puede haber empleados que no tengan supervisores, para esto se indicará solamente el numero de ellos dejando los valores restantes en NULL.
		System.out.println("Query 53");
		

		
		// cerramos los ficheros si se han usado
		if (wantWriteToFile) {
	        try {
	        	printStream.close();
				fileOutputStream.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}	
		
	}

}
