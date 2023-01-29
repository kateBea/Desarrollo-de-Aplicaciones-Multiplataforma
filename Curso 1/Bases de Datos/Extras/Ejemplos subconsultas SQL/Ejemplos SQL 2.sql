/* Ejemplos SQL*/
/* Fecha 26-01-23 */
USE curso;

/* Ejemplo subconsulta devuelve una empresión
 Mostrar empleados cuyo salario supere el salario medio */
select dep_no, apellido, salario
from empleados
where salario > (select avg(salario) 
				from empleados);

/* Mostrar el NOMBRE departametno donde trabaja GARRIDO*/

SELECT dnombre
FROM departamentos
WHERE dep_no = ( SELECT dep_no
				FROM empleados
				WHERE apellido ='GARRIDO');

/* Ejemplo subconsulta devuelve dos expresiones
 Obtener empleados que tengan el mismo oficio y departamento
que ALONSO*/
SELECT emp_no, apellido, oficio, dep_no
FROM empleados
WHERE (dep_no, oficio) = ( SELECT dep_no, oficio
							FROM empleados
							WHERE apellido='ALONSO');


/* Ejemplos de subconsultas más sencillas con una expresión
 Operadores comparación*/
 
 
 /* Obtener todos los empleados que tengan el mismo 
    oficio que GARRIDO */

SELECT emp_no, apellido, oficio
FROM empleados
WHERE oficio = ( SELECT oficio
					FROM empleados
					WHERE apellido='GARRIDO');
			
 /* Empleados que ganan más que cualquier empleado del dpto 30 */
 
 SELECT emp_no, apellido, salario, oficio, dep_no
 FROM empleados
 WHERE salario > ( SELECT max(salario)
					FROM empleados
					WHERE dep_no=30);
 
 
 /* Visualizar el nº de vendeores del dpto ventas */
 
 SELECT Count(*) "Total"
 FROM empleados
 WHERE  oficio ='VENDEDOR' 
		AND dep_no =  (SELECT dep_no
						from departamentos
						WHERE dnombre='VENTAS');

 /* Mostrar la suma de los salarios para cada oficio de los empleados
   del dpto VENTAS */
   
 SELECT oficio, sum(salario) "Suma_Salarios"
 FROM empleados
 WHERE dep_no= ( SELECT dep_no
					from departamentos
					WHERE dnombre = 'VENTAS')
 GROUP BY  oficio;
 
 /* Ejemplos de operadores lógicos IN, ANY ALL EXISTS*/
 
 /* Operador IN: comprueba si lo valores de la fila actual de la consulta ppal
 coindice con alguno delos valores devueltos por la subconsulta.Si el resultado
 es afirmativo la comparación TRUE
   Formato ExpresionColumna [NOT] IN (Subconsulta ) */
   
 /* Listar en orden alfabetivo empleados que no trabajen ni
    en Madrid ni en Barcelona */
 SELECT emp_no, apellido, dep_no
 FROM empleados
 WHERE dep_no IN ( SELECT dep_no
					FROM departamentos
					WHERE localidad NOT LIKE 'MADRID'
					AND localidad NOT LIKE 'BARCELONA');

 SELECT emp_no, apellido, dep_no
 FROM empleados
 WHERE dep_no NOT IN ( SELECT dep_no
					FROM departamentos
					WHERE localidad LIKE 'MADRID'
					AND localidad  LIKE 'BARCELONA');
 
 /* listar los nombres de los departamentos que tengan algun empleado 
 con fecha de alta anterior a 1982*/
 SELECT dnombre, dep_no
 FROM departamentos
 WHERE dep_no IN ( SELECT DISTINCT(dep_no)
					FROM empleados
					WHERE fecha_alta < '1982-01-01');
 /*Mostrar los departamentos y los nombres si hay mas de dos empleados
  trabajando en dichos dptos */
SELECT dep_no "NumDpto", dnombre "Departamento"
FROM departamentos
WHERE dep_no IN (  SELECT dep_no
					from empleados
					group by DEP_NO
						having count(*)>2);

/* Ejemplos con operador ANY/ALL
  Su uso a menos se sustituye por operador IN
  Formato==> ExpresionColumna OperadorComparacion {ANY|ALL} (Subconsulta)
  OperadorComparacion =, <=, >=, <, >, <>
  
  Any_ si alguna comparación produce TRUE devuelve TRUE
  All_ si TODOS los resultados de las comparaciones son TRUE devuelve TRUE
    */
  
  /* Visualizar nombres de los departamentos que tengan 
   trabajadores en ellos */
  
  SELECT dep_no "NumDpto", dnombre "NombreDpto"
  FROM departamentos
  WHERE dep_no = any (SELECT dep_no FROM empleados);

  /* muchas veces se usa in */
  SELECT dep_no "NumDpto", dnombre "NombreDpto"
  FROM departamentos
  WHERE dep_no IN (SELECT dep_no FROM empleados);
  
  /* Seleccionar dptos en los que al menos exista un empleado con comisión nula*/
  
  SELECT dep_no, dnombre
  from departamentos
  where  dep_no = any ( SELECT dep_no
						FROM empleados
						WHERE comision IS NULL);
  
  
  /* Ejemplo operador ALL */
  /* Listar empleados con mayor salario que TODOS los del departamento 20 */
  
  select dep_no, apellido, salario
  from empleados
  where salario > ALL ( select salario
						from empleados
						where dep_no=20);
  /* Listar los NOMBRES de los departamentos que no tienen empleados */
  
  SELECT dep_no, dnombre
  from departamentos
  where dep_no <> ALL ( SELECT dep_no
						FROM empleados);
		/* podríamos hacer un NOT IN pq es equivalente a <> ALL */
  
  /* Ejemplo con EXISTS */
  
  /*Visualizar los nombres de los deptos donde hay mas de un trabajador */
  
  SELECT dep_no, dnombre
  from departamentos d
  where EXISTS (
	SELECT *
	FROM EMPLEADOS e
    WHERE e.dep_no = d.dep_no
	GROUP by dep_no
	having count(*)>1);
  
 /*Listar localidades donde existan departamentos con empleados cuya comisión
  supere el 10% del salario*/
  
  SELECT localidad
  FROM departamentos d
  WHERE EXISTS ( SELECT * 
					FROM EMPLEADOS e
					WHERE comision>10*salario/100
					AND e.dep_no = d.dep_no);
  
  
  
  
  
  
  
  
  
  
  
 
 
 
 
 
 
 
 
 
 
 
 select * from empleados;
 
 
 
 
 
 
 
 
 
 
 
