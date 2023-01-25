/****************************************************
Este Script contiene la definición de una tabla sencilla
perteneciente a una basa de datos MySQL. Importante e imprescindible 
ejecutar el Script en el orden en que están las sentencias.

Autor: Hugo Pelayo
Fecha: 24 de enero de 2023
Fichero: Script DML.sql
****************************************************/

# Departamentos table data
# Autoincrementa el primer campo
INSERT INTO Departamentos VALUES (NULL, 'CONTABILIDAD', 'SEVILLA');
INSERT INTO Departamentos VALUES (NULL, 'INVESTIGACIÓN', 'MADRID');
INSERT INTO Departamentos VALUES (NULL, 'VENTAS', 'BARCELONA');
INSERT INTO Departamentos VALUES (NULL, 'PRODUCCIÓN', 'BILBAO');

# Dirs table data
INSERT INTO Dirs VALUES ('7902', 'FERNÁNDEZ');
INSERT INTO Dirs VALUES ('7698', 'NEGRO');
INSERT INTO Dirs VALUES ('7839', 'REY');
INSERT INTO Dirs VALUES ('7566', 'JIMÉNEZ');
INSERT INTO Dirs VALUES ('7788', 'GIL');
INSERT INTO Dirs VALUES ('7782', '');

# Empleados table data
/* NOTA: El formato correcto de fecha usado es YYYY-MM-DD donde YYYY representa el año,
MM representa el mes y DD representa el día */
INSERT INTO Empleados values('7369', 'SÁNCHEZ', 'EMPLEADO', '7902', '1980-12-17', 104000, NULL, 20);
INSERT INTO Empleados values('7499', 'ARROYO', 'VENDEDOR', '7698', '1980-02-20', 208000, 39000, 30);
INSERT INTO Empleados values('7521', 'SALA', 'VENDEDOR', '7698', '1981-02-22', 162500, 162500, 30);
INSERT INTO Empleados values('7566', 'JIMÉNEZ', 'DIRECTOR', '7839', '1981-04-02', 386750, NULL, 20);
INSERT INTO Empleados values('7654', 'MARTÍN', 'VENDEDOR', '7698', '1981-09-29', 162500, 182000, 30);
INSERT INTO Empleados values('7698', 'NEGRO', 'DIRECTOR', '7839', '1981-05-01', 370500, NULL, 30);
INSERT INTO Empleados values('7788', 'GIL', 'ANALISTA', '7566', '1981-11-09', 390000, NULL, 20);
INSERT INTO Empleados values('7839', 'REY', 'PRESIDENTE', NULL, '1981-11-17', 650000, NULL, 10);
INSERT INTO Empleados values('7844', 'TOVAR', 'VENDEDOR', '7698', '1981-09-08', 195000, 0, 30);
INSERT INTO Empleados values('7876', 'ALONSO', 'EMPLEADO', '7788', '1981-09-23', 143000, NULL, 20);
INSERT INTO Empleados values('7900', 'JIMENO', 'EMPLEADO', '7698', '1981-12-03', 1235000, NULL, 30);
INSERT INTO Empleados values('7902', 'FERNÁNDEZ', 'ANALISTA', '7566', '1981-12-03', 390000, NULL, 20);
INSERT INTO Empleados values('7934', 'MUÑOZ', 'EMPLEADO', '7782', '1982-01-23', 169000, NULL, 10);




SELECT *
FROM Departamentos;

SELECT *
FROM Empleados;

SELECT *
FROM Dirs;


# Consultas ejercicios ----------------------------------------------------------------------

# 1)
SELECT Apellido, Oficio, Dept_No AS 'Número de Departamento'
FROM Empleados;

# 2)
SELECT Dept_No AS 'Número de Departamento', Dnombre AS 'Nombre de Departamento', Loc AS 'Localización'
FROM Departamentos;

# 3)
SELECT *
FROM Empleados;

# 4)
SELECT *
FROM Empleados
WHERE Salario > 2000000;

# 5)
SELECT *
FROM Empleados
WHERE Oficio = 'ANALISTA';

# 6)
SELECT Apellido, Oficio
FROM Empleados
WHERE Dept_No = 20;

# 7)
SELECT *
FROM Empleados
WHERE Dept_No = 20 OR Salario > 200000;

# 8)
SELECT *
FROM Empleados
WHERE Apellido LIKE 'A%';

# 9)
SELECT *
FROM Empleados
WHERE Apellido LIKE '%Z';

# 10)
SELECT *
FROM Empleados
WHERE Apellido LIKE 'A%' AND Oficio LIKE '%E%';

# 11)
SELECT *
FROM Empleados
WHERE Salario BETWEEN 100000 AND 200000;

# 12)
SELECT *
FROM Empleados
WHERE Oficio = 'VENDEDOR' AND Comision IS NOT NULL AND Comision > 100000;

# 13)
SELECT Emp_No AS 'Número de Empleado', Apellido
FROM Empleados
WHERE Apellido LIKE '%Z' AND Salario > 300000;

# 14)
SELECT *
FROM Departamentos
WHERE Loc LIKE 'B%';

# 15)
SELECT *
FROM Empleados
WHERE Salario > 100000 AND Oficio = 'EMPLEADO' AND Dept_No = 10;

# 16)
SELECT Apellido
FROM Empleados
WHERE Comision IS NOT NULL AND Comision = 0;

# 17)
SELECT Apellido
FROM Empleados
WHERE Comision IS NOT NULL AND Comision = 0 AND Apellido LIKE 'J%';

# 18)
SELECT Apellido
FROM Empleados
WHERE Oficio IN ('VENDEDOR', 'ANALISTA', 'EMPLEADO');

# 19)
SELECT Apellido
FROM Empleados
WHERE Oficio NOT IN ('ANALISTA', 'EMPLEADO') AND Salario > 200000;

# 20)
SELECT *
FROM Empleados
WHERE Salario BETWEEN 2000000 AND 3000000; 

# 21)
SELECT Apellido, Salario, Dept_No AS 'Número de Departamento'
FROM Empleados
WHERE Dept_No IN(10, 30) AND Salario > 200000;

# 22)
SELECT Apellido, Emp_No AS 'Número de Empleado'
FROM Empleados
WHERE Salario NOT BETWEEN 100000 AND 200000;

# 23)
SELECT LOWER(Apellido) AS 'Apellido'
FROM Empleados;

# 24)
SELECT CONCAT(Apellido, ' es ', Oficio) AS 'Apellido y Oficio'
FROM Empleados;

# 25)
SELECT Apellido, LENGTH(Apellido) AS 'Longitud de Apellido'
FROM Empleados
ORDER BY LENGTH(Apellido) DESC;

# 26)
SELECT YEAR(Fecha_Alt) AS 'Año de Contratación'
FROM Empleados;

# 27)
SELECT  *
FROM Empleados
WHERE YEAR(Fecha_Alt) = 1992;

# 28)
SELECT  *
FROM Empleados
WHERE MONTH(Fecha_Alt) = 2;

# 29)
SELECT *
FROM Empleados
WHERE Apellido LIKE 'A%' AND YEAR(Fecha_Alt) = 1990;

# 30)
SELECT *
FROM Empleados
WHERE Dept_No = 10 AND Comision IS NOT NULL AND Comision = 0;

# 31)
SELECT *
FROM Empleados
ORDER BY Dept_No DESC;

# 32)
SELECT *
FROM Empleados
ORDER BY Apellido;

# 33)
SELECT *
FROM Empleados
ORDER BY Dept_No DESC, Apellido ASC;

# 34)
SELECT *
FROM Empleados
ORDER BY Apellido;

# 35)
SELECT *
FROM Empleados
WHERE Oficio = 'VENDEDOR'
ORDER BY Apellido;

# 36)
SELECT *
FROM Empleados
WHERE Dept_No = 10 AND Oficio = 'ANALISTA'
ORDER BY Apellido;

# 37)
SELECT *
FROM Empleados
ORDER BY Oficio , Apellido;

# 38)
SELECT *
FROM Empleados
ORDER BY Dept_No, Apellido;

# 39)
SELECT  *
FROM Empleados
WHERE Apellido LIKE 'A%' AND YEAR(Fecha_Alt) = 1990;

# 40)
SELECT *
FROM Empleados
WHERE Dept_No = 10 AND Comision IS NOT NULL AND Comision = 0;