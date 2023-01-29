/* SQL: subconsultas con selección de grupos */
USE curso;
/* Mostrar los departamento en los que el salario medio sea mayor o igual que 
la media de todos los salarios de la empresa */

SELECT dep_no, avg(salario)
FROM empleados
GROUP BY dep_no
HAVING avg(salario)>= ( SELECT AVG(salario) FROM empleados);

/* Mostrar departamentos que tengan mayor media salarial total (salario+comision)
que la mitad de la media salarial total de la empresa */

SELECT dep_no, avg(salario+ifnull(comision,0))
from empleados
group by dep_no
having avg(salario+ifnull(comision,0)) > ( SELECT avg (salario+ ifnull(comision,0))/2
											FROM empleados);





