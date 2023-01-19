USE curso;

# optener el promedio de comisiones
SELECT sum(comision) / count(comision)
FROM empleados;

#seleccionar los salarios medios por dpto
SELECT dep_no AS "Número departamento", avg(salario) AS "Promedio salario"
FROM empleados
GROUP BY dep_no;

# Mostrar el oficio y al lado cuántos empleados hay para ese oficio
SELECT oficio AS "Nombre oficio", count(oficio) AS "Número empleados"
FROM empleados
GROUP BY oficio
ORDER BY oficio;

# oficios con más de dos empleados
SELECT oficio AS "Nombre oficio", count(oficio) AS "Número empleados"
FROM empleados
GROUP BY oficio
HAVING count(oficio) > 1;

SELECT * FROM empleados;

# seleccionar oficios que tengan dos o más empleados, cuyo salario supere los 1400 euros
SELECT Oficio, count(*) AS "Total empleados"
FROM empleados 
where salario > 1400
GROUP BY oficio
HAVING count(*) > 1;

#departamento con menor salario medio
SELECT dep_no AS "Número departamento", avg(salario) AS "Slario Medio"
FROM empleados
GROUP BY dep_no
ORDER BY avg(salario)
LIMIT 1;

# seleccionar los datos del departamento con mayor número de empleados
SELECT dep_no "Número departamento", count(*) AS "Número empleados"
FROM empleados
GROUP BY dep_no
ORDER BY count(*) desc
LIMIT 1;

SELECT * FROM empleados;

# SELECT [DISTINCT] Expresion/Columna [AliASExpresion/Columna],
# 					[Expresion/Columna [AliASExpresion/Columna],
#					....
# FROM NombreTabla [AliASTabla]alter
# [GROUP BY ExpresionColumna_o_posicion [, ExpresionColumna_o_posicion...]
#			[, ExpresionColumna_o_posicion ASC | desc ...]
# [LIMIT x, y];