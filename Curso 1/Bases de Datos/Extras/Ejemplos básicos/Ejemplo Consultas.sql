# Fecha: 13/01/23
# Empezando con SQL

show databases;
use world;
show tables;

use curso;
show tables; #para conocer las tablas que tiene la bd

#para conocer la estructura de las tablas
describe clientes;
describe departamentos;
describe empleados;
describe pedidos;
describe productos;

# Mostrar todos los datos de los empleados
SELECT *
FROM empleados;

SELECT * FROM empleados;

# Mostrar el código empleado, apellido, numero dpto
SELECT emp_no, apellido, dep_no
FROM empleados;

# Mostrar departamentos diferentes que hay en empleados
SELECT DISTINCT dep_no
FROM empleados;

# Mostrar los diferentes oficios en cada departamento de los empleados
SELECT DISTINCT oficio, dep_no
FROM empleados;

# MOSTRAR apellidos y fecha de alta de todos los empleados usando un alias
# para el nombre de la tabla
SELECT apellido, fecha_alta
FROM empleados emp;

# MOSTRAR el salaro total anual (14 pagas) de los empleados
#mostrando el mensaje 'Salario Total'

SELECT salario*14 AS Salario_Total
FROM empleados;

SELECT salario*14 
FROM empleados;

SELECT salario*14 AS "Salario Total"
FROM empleados;

SELECT salario*14 AS 'Salario Total'
FROM empleados;

# Mostrar el nº empleado, apellido y departamento
#utilizando unos alias más significativos para el usuario

SELECT emp_no "Nº empleado", apellido "Apellido", dep_no "Departamento"
FROM empleados; #no se ha incluido el AS

#Mostrar los empleados cuyo apellido empieza por M y tenga un salario ENTRE 1000 y 2000
SELECT emp_no, apellido, dep_no, salario
FROM empleados
WHERE apellido LIKE 'M%' AND salario BETWEEN 1000 AND 2000;

# Seleccionar los empleados cuyo apellido incluya una 'A' en el segundo carácter
SELECT emp_no "Nº Empleado", apellido "Apellido", dep_no "Departamento"
FROM empleados
WHERE apellido LIKE '_A%';

#Seleccionar empleados que trabajen en los dptos 10, 30
SELECT emp_no "Nº Empleado", apellido "Apellido", dep_no "Departamento"
FROM empleados
WHERE dep_no=10 OR dep_no=30;

SELECT emp_no "Nº Empleado", apellido "Apellido", dep_no "Departamento"
FROM empleados
WHERE dep_no IN (10,30);

#Mostrar el codigo y apellidos de los empleados que sean ANALISTA
SELECT emp_no, apellido
FROM empleados
WHERE oficio = 'ANALISTA';

SELECT emp_no, apellido
FROM empleados
WHERE oficio = 'analista'; #mysql no distingue may y min

# mostrar empleados con su salario
SELECT emp_no, apellido, salario
FROM empleados;

#Mostrar la consulta anterior redondeado sin decimales
SELECT emp_no, apellido, ROUND(salario, 0) "SALARIO SIN DECIMALES"
FROM empleados;
#ahora con un decimal
SELECT emp_no, apellido, ROUND(salario, 1) "SALARIO SIN DECIMALES"
FROM empleados;

# mostrar los empleados en los que la comisión sea multiplo de 100 y no sea 0
SELECT *
FROM empleados
WHERE MOD(comision, 100)=0 AND comision!=0;

# mostrar el codigo empleado, apellido y un nuevo campo que se llamará
#usuario que será las tres primeras inciales del apellido seguido de punto
select * from empleados;

SELECT emp_no, apellido, concat(substr(apellido, 1, 3), '.') "usuario"
FROM empleados;

select * from departamentos;

#Mostrar los departamentos cuyo nombre tenga mas de 6 caracteres
SELECT dnombre
FROM departamentos
WHERE LENGTH (dnombre)>6;

# lo mismo que antes pero reemplazar las A por *
SELECT REPLACE (dnombre, 'A', '*')
FROM departamentos
WHERE LENGTH (dnombre)>6;

#mostrar la fecha actual
SELECT curdate() "FECHA ACTUAL";
# mostrar la fecha dentro de una semana
SELECT curdate() "FECHA ACTUAL", 
	   adddate(curdate(), 7) "FECHA DENTRO DE UNA SEMANA";
# Mostrar apellido, fecha de alta de empleados
SELECT apellido, fecha_alta
FROM empleados;

# consulta anterior pero mostrando la fecha 
# con el <dia de la semana> - <dia> de <mes> de <año>
SELECT apellido, CONCAT (DAYNAME(fecha_alta), ' - ', 
						 DAYOFMONTH (fecha_alta), ' de ', 
                         MONTH(fecha_alta), ' de ', 
                         YEAR (fecha_alta)) "Fecha alta"
FROM empleados;

#visualizar la fecha 13/01/2023 con el formato
# <dia de la semana>, <numero de dia> de <nombre de mes> de <año>

SELECT DATE_FORMAT('2023-01-13', '%W, %e de %M de %Y') as fecha;
# consultar https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_date-format

#mostrar los empleados que la suma de su salario + comisión menor 2mil
select * from empleados;
SELECT apellido, salario, comision
FROM empleados
WHERE salario+comision<2000;

SELECT apellido, salario, comision
FROM empleados
WHERE salario+ifnull(comision, 0)<2000;