/*
 UT 9: EJEMPLOS VISTAS
*/
use curso;
-- Consultar qué views tiene la bd
show full tables where table_type='VIEW';

-- Cración de una vista (emple_30) con los datos
-- de todos los empleados del dpto con código 30

CREATE VIEW emple_30 AS
SELECT * FROM EMPLEADOS WHERE dep_no=30;

-- actualizar el navegador izqda

-- cómo uso la vista
select apellido from emple_30;

-- Creación de la vista datos_empleados
-- que contiene información de todos los empleados
-- num_empleado, apellido, oficio, director, fecha_alta, dep_no

CREATE VIEW datos_empleados AS
SELECT emp_no, apellido, oficio, director, fecha_alta, dep_no
FROM empleados;

Select * from datos_empleados;

-- Ejemplo seleccionar solo los campos apellido, director
Select apellido, director from datos_empleados;

-- Seleccionar solo los vendedores 
Select apellido, director from datos_empleados
where oficio='VENDEDOR';

-- Creación de una vista a partir de otra vista que ya existe
-- Crear la vista datos_emple_10 a partir de la vista datos_emple
CREATE VIEW datos_emple_10 AS
SELECT * FROM datos_empleados WHERE dep_no=10;

Select * from datos_emple_10;

-- Creación vista con agrupaciones
-- Mostrar num_empleados, suma salario y comisión p dpto
CREATE VIEW resumen_dep
(dep_no, num_empleados, suma_salario, suma_comision) AS
SELECT dep_no, count(emp_no), sum(salario), sum(ifnull(comision, 0))
FROM empleados
GROUP BY dep_no;

-- Recuerda: especificar el nombre de las columnas cuando crees la vista y uses 
-- funciones columna como AVERAGE, SUM, MAX, MIN... 


-- Guarda en una vista los datos de los dptos que tengan más de dos empleados
CREATE VIEW resumen_emp_dep (departento, numero_empleado, suma_salario) AS
	SELECT dnombre, count(emp_no), sum(salario)
    FROM empleados, departamentos
	where empleados.dep_no=departamentos.dep_no
	group by empleados.dep_no, dnombre
	having count(*)>2;

Select * from resumen_emp_dep;

-- Renombrar una vista con un nuevo nombre
-- Cambiar el nombre de la vista resumen_emp_dep por resumen_masDosEmpleados
Rename table resumen_emp_dep to resumen_masDosEmpleados;
Select * from resumen_emp_dep; -- da error pq ya no existe este objeto
Select * from resumen_masDosEmpleados;

-- Eliminar la vista resumen_masDosEmpleados
Drop view if exists resumen_masDosEmpleados;
Select * from resumen_masDosEmpleados; -- da error pq no existe el objto




