/* SQL: ejemplos subconsultas devuelven más de una expre */

use curso;
/* Obtener los empleados que pertenecen al mismo 
  departametno y entraron el mismo dia que GARRIDO */

  SELECT emp_no, apellido, oficio
  FROM empleados
  WHERE (dep_no, fecha_alta)= ( SELECT dep_no, fecha_alta
								FROM empleados
								WHERE apellido='GARRIDO');
                                
   /*Listar empleado con mayor salario de cada dpto */
   
   SELECT dep_no, emp_no, apellido, oficio
   FROM empleados
   WHERE (dep_no, salario) IN ( SELECT dep_no, max(salario)
								FROM empleados
								GROUP by dep_no);
   /* Empleado que trabaja en mismo dpto que JIMENEZ y tiene maximo salario */
   
 SELECT emp_no, apellido
 FROM empleados
 WHERE (dep_no, salario)= (SELECT dep_no, max(salario)
							FROM empleados
							WHERE dep_no = (SELECT dep_no
											FROM empleados
											where apellido='JIMENEZ')
							GROUP by dep_no);
   
   /*Visualizar los empleados que tienen el mismo jefe y departamento que 
     ALONSO (excluir al propio ALONSO)*/
     
     SELECT emp_no, apellido, director, dep_no
     FROM empleados
     WHERE (director, dep_no)= ( SELECT director, dep_no
									FROM empleados
									WHERE apellido ='ALONSO')
	 AND apellido!='ALONSO';
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
   
   
   
   
   
   
   
   
   
   SELECT * FROM EMPLEADOS;
   
   
   