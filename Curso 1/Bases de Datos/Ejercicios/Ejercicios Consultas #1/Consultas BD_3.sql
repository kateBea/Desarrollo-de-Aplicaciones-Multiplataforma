/*********************************************
Script de consultas del listado de ejercicios
descritos en el documendto Consultas BD_3.pdf

Autor: Hugo Pelayo
Fecha: 19 de enero de 2023
Fichero: Consultas BD_3.sql
**********************************************/

# Mostrar todas las bases de datos
SHOW DATABASES;

# Seleccionar la base de datos
USE World;

# Tablas de la base de datos en uso
SHOW TABLES;

# Mostrar campos de una tabla
DESCRIBE City;
DESCRIBE Country;

# Seleccionamos toda la información de la tabla City
SELECT * 
FROM City;

/**********************************************
			     PARA PRACTICAR
**********************************************/

# Número de ciudades de la tabla City
SELECT COUNT(*) 
FROM City;

SELECT CountryCode, Name, MAX(Info->'$.Population')
FROM City
GROUP BY CountryCode;

SELECT DISTINCT a.CountryCode, b.Name, a.District
FROM City a, City b
WHERE a.Name = b.Name AND a.CountryCode <> b.CountryCode;
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
# La sintaxis utilizada abajo es para acceder a 
# miembros de un objeto JSON (tipo de dato de MySQL).
# Documentación para más información: 
# MySQL JSON: https://dev.mysql.com/doc/refman/8.0/en/json-search-functions.html

SELECT District as Provincia, SUM(Info->'$.Population') AS 'Población'
FROM City
WHERE CountryCode = 'ESP'
GROUP BY District;

# Códigos de países por país
SELECT Name AS 'País', Code AS "Código de País"
FROM Country
ORDER BY Name;

# Ciudades con mismo nombre que pertenecen a países diferentes
SELECT DISTINCT a.CountryCode, a.Name, a.District
FROM City a, City b
WHERE a.Name = b.Name AND a.CountryCode <> b.CountryCode
ORDER BY a.Name;