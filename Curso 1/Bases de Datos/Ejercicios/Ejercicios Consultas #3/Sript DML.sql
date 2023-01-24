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

# Consultas ejercicios
