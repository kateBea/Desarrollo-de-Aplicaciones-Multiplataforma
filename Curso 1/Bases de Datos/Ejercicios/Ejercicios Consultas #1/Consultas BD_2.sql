/*********************************************
Script de consultas del listado de ejercicios
descritos en el documendto Consultas BD_2.pdf

Autor: Hugo Pelayo
Fecha: 19 de enero de 2023
Fichero: Consultas BD_2.sql
**********************************************/

# Mostrar todas las bases de datos
SHOW DATABASES;

# Seleccionar la base de datos
USE World;

# Tablas de la base de datos en uso
SHOW TABLES;

# Mostrar campos de una tabla
DESCRIBE City;

# Seleccionamos toda la información de la tabla City
SELECT * 
FROM City;

/**********************************************
			     PARA PRACTICAR
**********************************************/

# ----------------

/**********************************************
			CONSULTAS AUXILIARES
**********************************************/

# Seleccionar todos los códigos de país diferentes
SELECT DISTINCT CountryCode 
FROM City
ORDER BY CountryCode ASC;

# Seleccionar todos los distritos
SELECT District 
FROM City
ORDER BY District ASC;

# Seleccionar población de España por distritos
# La intaxis utilizada abajo es para acceder a miembros de un objeto JSON (tipo de dato de MySQL)
# consultar Docs para más información: 
# MySQL JSON: https://dev.mysql.com/doc/refman/8.0/en/json-search-functions.html
SELECT District as Provincia, SUM(Info->'$.Population') AS 'Población'
FROM City
WHERE CountryCode = 'ESP'
GROUP BY District;