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

#mostrar los empleados ordenando alfabeticamente por el apellido
select emp_no, apellido, oficio, salario
from empleados
order by apellido; #si no concreta es asc

select emp_no, apellido, oficio, salario
from empleados
order by apellido desc;

# mostrar los empleados ordenados alfabeticamente por departamentos
select dep_no, apellido, emp_no, oficio, salario
from empleados
order by dep_no, apellido;

select dep_no, apellido, emp_no, oficio, salario
from empleados
order by dep_no, apellido desc;

#mostrar todos los empleados clasificados por oficios y en orden descendente de salarios
SELECT dep_no, apellido, oficio, salario
from empleados
ORDER BY oficio, salario desc;

SELECT dep_no, apellido, oficio, salario
from empleados
ORDER BY 3, 4 desc; #Se puede usar el num posicion de ese campo

# Obtener los apellidos de los empleados, junto a su
# salario anual (salario + comision * 14 pagas) ordenado de mayor a menor por
# este salario total

SELECT apellido, (salario + ifnull (comision,0))*14 as "Salario_anual"
FROM empleados
ORDER BY (salario + ifnull (comision,0))*14 DESC;

SELECT apellido, (salario + ifnull (comision,0))*14 as "Salario_anual"
FROM empleados
ORDER BY Salario_anual DESC;

SELECT apellido, (salario + ifnull (comision,0))*14 as "Salario_anual"
FROM empleados
ORDER BY 2 DESC;

#mostrar el num empleado, apellido, salario y
# dpto de los cinco empleados con menos salario

SELECT emp_no, apellido, salario, dep_no
FROM empleados
ORDER BY salario
LIMIT 5;

#mostrar el num empleado, apellido, salario y
# dpto de los 3 empleados con MAS salario


SELECT emp_no, apellido, salario, dep_no
FROM empleados
ORDER BY salario desc
LIMIT 3;

# mostrar num empleado, apellido, salario, dpto
# clasificados alfabeicamente segun apellido
# mostrar desde el 5º empleado hasta el 7º

select emp_no, apellido, salario, dep_no
from empleados
order by apellido
LIMIT 4, 3; #empieza en fil 0

# mostrar total de todos los salarios mensuales de todos los empleados
SELECT SUM(salario) as "salario_total"
from empleados;

SELECT SUM(salario)
from empleados;

#mostrar el salario max, min y diferencia de todos los salarios
SELECT MAX(salario) as "Salario_alto", 
		MIN(salario) as "Salario_bajo", 
		MAX(salario)-MIN(salario) as "Diferencia"
FROM empleados;

#mostrar el empleado más reciente
SELECT max(fecha_alta) "Fecha alta"
FROM empleados;

# mostrar el salario medio de todos los empleados
SELECT AVG(salario) "salario medio"
from empleados;

# valor medio de las comisiones
# ojo con este ejemplo porque podemos hacerlo de
# diferentes formas y el resultado varía

# COUNT (COLUMNA) cuenta el numero de valoRes de datos que hay en una
#        en una columna sin incluir los valores NULL
# COUNT (*) cuenta todas las filas sin considerar que en algunas existan 
#            valores Null
# AVG si tiene en cuenta las filas con valores NULL

# EJEMPLO USANDO AVG
SELECT AVG(comision)
FROM empleados;


SELECT sum(comision) / count(*)
FROM empleados;

SELECT sum(comision) / count(comision)
FROM empleados;

# calcular el salario medio de todos los empleados ANALISTAS
select avg(salario) as "Salario medio"
from empleados
where oficio='ANALISTA';

#obtener los salarios medios por dpto
select dep_no as "Num Dpto", avg(salario) as "Salario medio"
from empleados
group by dep_no;

#mostrar el oficio y al lado cuántos empleados hay para ese oficiio
SELECT oficio, count(oficio) "num empleados"
from empleados
group by oficio
order by oficio;

SELECT oficio, count(*) "num empleados"
from empleados
group by oficio
order by oficio;

#seleccionar oficios que tengan dos o más empleados
SELECT oficio, count(*) "total"
from empleados
group by oficio
HAVING count(*)>=2;

# seleccionar oficios que tengan dos o más empleados, cuyo salario supere
# los 1400 euros.
SELECT oficio, count(*) "num"
FROM empleados
WHERE salario > 1400
group by oficio
having count(*)>=2;

# mostrar el dpto con menor salario medio
SELECT dep_no, AVG(salario)
FROM empleados
GROUP BY dep_no
ORDER BY 2
LIMIT 1;

#seleccionar los datos del departamento cn mayor nº de empleados

SELECT dep_no, COUNT(*)
FROM empleados
group by dep_no
order by 2 desc
limit 1;
 describe empleados;

# SELECT [DISTINCT] Expresion/Columna [AliasExpresion/Columna],
#					[Expresion/Columna [AliasExpresion/Columna],
#                    ....
# FROM NombreTabla [AliasTabla]
# [GROUP BY ExpresionColumna_o_posicion [, ExpresionColumna_o_posicion...]
#     [HAVING CondicionSeleccionGrupos]
# [ORDER BY ExpresionColumna_o_posicion ASC|desc
#			[,ExpresionColumna_o_posicion ASC|desc ...]
# [LIMIT x, y];














select * from empleados;









































































                         
                         


        
       
       
       
       
       
       
























