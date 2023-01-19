/*********************************************
Script de consultas del listado de ejercicios
descritos en el documendto Consultas BD_1.pdf

Autor: Hugo Pelayo
Fecha: 19 de enero de 2023
Fichero: Consultas BD_1.sql
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

# Selecciona solo la columna Name de la tabla City
SELECT Name
FROM City;

# Selecciona solo las columnas Name y CountryCode de la tabla City
SELECT Name, CountryCode
FROM City;

# Sleccionar las ciudades de Holanda
SELECT 	Name
FROM City
WHERE CountryCode = 'NLD';

/**********************************************
			     PARA PRACTICAR
**********************************************/

# 1. Los nombres y el Distrito de las ciudades españolas de la tabla City
SELECT Name AS "Nombre de Ciudad", District as "Provincia"
FROM City
WHERE CountryCode = 'ESP';

# 2. Todos los datos de las ciudades españolas de la tabla City
SELECT *
FROM City
WHERE CountryCode = 'ESP';

# 3. Los nombres de las ciudades de Madrid de la tabla City
SELECT Name AS "Nombre Ciudad"
FROM City
WHERE CountryCode = 'ESP' AND District = 'Madrid';

# 4. Los nombres de las ciudades de Galicia de la tabla City
SELECT Name AS 'Nombre Ciudad'
FROM City
WHERE CountryCode = 'ESP' AND District = 'Galicia';

# 5. Las ciudades con más de 5000000 habitantes
# NOTA: Importante a la hora de hacer el query el hecho de que
# la tabla City gaurda ciudades, es decir, por cada ciudad tenemos su
# ID, Nombre, Provincia y población. Simplemente debemos saber
# cuál tiene mayor valor de población. Más información sobre la sintaxis del objeto JSON abajo
SELECT Name as 'Nombre Ciudad', MAX(Info->'$.Population') AS 'Población por Ciudad'
FROM City
WHERE Info->'$.Population' > 5000000;

# 6. Las ciudades de España con más de 1000000 habitantes
SELECT Name as 'Nombre Ciudad', Info->'$.Population' AS 'Población por Ciudad'
FROM City
WHERE CountryCode = 'ESP' AND Info->'$.Population' > 1000000;

# 7. Las ciudades de España o de Argentina con más de 1000000 habitantes
SELECT Name as 'Nombre Ciudad', Info->'$.Population' AS 'Población por Ciudad'
FROM City
WHERE (CountryCode = 'ESP' OR CountryCode = 'ARG') AND Info->'$.Population' > 1000000;

# 8. Las tres primeras ciudades españolas en orden descendente
SELECT Name as 'Nombre Ciudad'
FROM City
WHERE CountryCode = 'ESP'
ORDER BY Name
LIMIT 3;

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