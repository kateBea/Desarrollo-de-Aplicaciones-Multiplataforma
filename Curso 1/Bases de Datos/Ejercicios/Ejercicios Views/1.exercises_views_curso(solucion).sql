-- Ejercicios vistas sobre BD curso
USE curso;

/*
Crea la vista datos_vendedores que muestra  las columnas
num_vendor,apellido, director, fecha_alta, dep_no, de aquellos empleados cuyo oficio es VENDEDOR
*/
CREATE VIEW datos_vendedores
(num_vendedor, apellido, director, fecha_alta, dep_no) AS
SELECT emp_no, apellido, director, fecha_alta, dep_no
FROM Empleados
WHERE oficio='VENDEDOR';




/* Muestra el contenido de la vista anterior */

Select * from datos_vendedores;
/* 
Crea la vista resumen_dep2 la cual muestra el código dpto, el num empleados, la suma de todos los salarios y la suma de todas las comisiones.
*/
CREATE VIEW resumen_dep2 (dep_no, num_empleados, suma_salario, suma_comision) AS
	select dep_no, count(emp_no), sum(salario), sum(ifnull(comision,0)) FROM empleados
    group by dep_no;
/* Mostrar contenido de la vista anterior */
Select * from resumen_dep2;
/*
Crear la vista resumen_dep3 con el código dpto, numero empleados y suma salarios
*/
CREATE VIEW resumen_Dep3 AS
	SELECT dep_no, count(emp_no) "num_empleados", sum(salario) "suma_salario"
    FROM empleados GROUP BY dep_no;

Select * from resumen_dep3;

/* Mostrar el salario máximo de la vista anterior */
Select max(suma_salario) from resumen_dep3;
   

/* Obtener usando la vista resumen_dep3 a qué deparamento pertenece el salario máximo obtenido */

Select dep_no, dnombre from Departamentos
Where dep_no = ( Select dep_no From resumen_dep3
				 Where suma_salario = (Select Max(Suma_Salario) From resumen_dep3));
                 
    