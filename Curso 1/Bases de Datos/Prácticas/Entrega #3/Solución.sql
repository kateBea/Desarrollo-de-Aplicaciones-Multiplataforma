/*********************************************
Script de consultas del listado de ejercicios
descritos en el documendto  Solución.pdf. Lista una serie
de consultas sobre la base de datos world. En caso de no tener
esta base de datos de ejemplo, se provee el fichero de creación
de la base de datos y posterior adición de los mismo en el fichero SQL 
'./Bases de datos de la práctica/world-db/world_x-db/world.sql', directorio relativo
a este script SQL.

Autor: Hugo Pelayo
Fecha: 20 de enero de 2023
Fichero: Solución.sql
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

# 1. Obtener el nombre y la población de las ciudades de Brasil
SELECT Name, Info->'$.Population' AS 'Población'
FROM City
WHERE CountryCode = 'BRA';

# 2. Obtener el nombre de todas las ciudades que empiecen por 'B'
SELECT Name AS 'Nombre Ciudad'
FROM City
WHERE Name LIKE 'B%';

# 3. Obtener el nombre y la población de las ciudades de Brasil que empiezan por 'S'
SELECT Name AS 'Nombre Ciudad'
FROM City
WHERE Name LIKE 'S%' AND CountryCode = 'BRA';

# 4. Obtener el nombre y distrito de las ciudades belgas y polacas entre 400000 y 2 millones de habitantes
SELECT Name AS 'Nombre Ciudad', Info->'$.Population' AS 'Población'
FROM City
WHERE (CountryCode = 'BEL' OR CountryCode = 'POL') AND Info->'$.Population' BETWEEN 400000 AND 2000000;

# 5. Obtener el nombre y distrito de las ciudades españolas ordenadas por nombre
SELECT Name AS 'Nombre Ciudad', District AS 'Provincia'
FROM City
WHERE CountryCode = 'ESP'
ORDER BY Name;

# 6. Obtener el nombre y distrito de las ciudades españolas ordenadas ascendentemente por población
SELECT Name AS 'Nombre Ciudad', Info->'$.Population' AS 'Población', District AS 'Provincia'
FROM City
WHERE CountryCode = 'ESP'
ORDER BY Info->'$.Population';

# 7. Obtener el nombre y distrito de las ciudades españolas ordenadas descendentemente por población
SELECT Name AS 'Nombre Ciudad', Info->'$.Population' AS 'Población', District AS 'Provincia'
FROM City
WHERE CountryCode = 'ESP'
ORDER BY Info->'$.Population' DESC;

# 8. Ciudades estadounidenses y alemanas con más de 1000000 habitantes
SELECT Name AS 'Nombre Ciudad', Info->'$.Population' AS 'Población'
FROM City
WHERE (CountryCode = 'USA' OR CountryCode = 'DEU') AND Info->'$.Population' > 1000000;

# 9. Obtener el listado sin repeticiones de los países de la tabla ciudades
SELECT DISTINCT CountryCode AS 'Código de País'
FROM City;

# 10. Obtener listado de los países cuyo código empieze por 'E' de la tabla City 
SELECT DISTINCT CountryCode AS 'Código de País'
FROM City
WHERE CountryCode LIKE 'E%';

# 11. Obtener listado de los países cuyo código contenga una 'S' de la tabla City
SELECT DISTINCT CountryCode AS 'Código de País'
FROM City
WHERE CountryCode LIKE '%S%';

# 12. Obtener listado de los países cuyo código acabe por una 'A' de la tabla City
SELECT DISTINCT CountryCode AS 'Código de País'
FROM City
WHERE CountryCode LIKE '%A';

# 13. Obtener el nombre de las ciudades que se llaman igual que el distrito
SELECT Name
FROM City
WHERE Name = District;

# 14. Obtener listado de los ciudades cuyos nombres contengan la cadena 'MA'
SELECT Name, District AS 'Provincia'
FROM City
WHERE Name LIKE '%MA%';

# 15. Obtener listado de los ciudades cuyos nombres no contengan la cadena 'MA'
SELECT Name, District AS 'Provincia'
FROM City
WHERE Name NOT LIKE '%MA%';

# 16. Hallar las ciudades de seis letras cuyo nombre tiene una 'A' en la segunda posición
# y acaba en 'D'
SELECT Name, District AS 'Provincia'
FROM City
WHERE Name LIKE '_A%D';

# 17. Obtener las ciudades más pobladas de España (se entiende por más pobladas las que superan la media de población)
SELECT Name AS 'Nombre', District AS 'Distrito', Info->'$.Population' AS 'Población'
FROM City
WHERE CountryCode = 'ESP' AND Info->'$.Population' >= (SELECT AVG(Info->'$.Population') # Esta subquery devuelve el valor promedio de población por ciudad
														FROM City
														WHERE CountryCode = 'ESP');
                                                        
# Seleccionar media población por ciudad de DE TODOS LOS PAÍSES
SELECT CountryCode, ROUND(AVG(Info->'$.Population')) AS 'Media Población por Ciudad'
FROM City
GROUP BY CountryCode
ORDER BY CountryCode;

# 18. Obtener el nombre y distrito de las cinco ciudades más pobladas de Estados Unidos y Reino Unido
# Esta query selecciona las cinco ciudades más pobladas de Estados Unidos
(SELECT Name AS 'Nombre', District AS 'Distrito', Info->'$.Population' AS 'Población', CountryCode
FROM City
WHERE (CountryCode = 'USA') AND Info->'$.Population' >= (SELECT AVG(Info->'$.Population') # Esta subquery devuelve el valor promedio de población por ciudad
														FROM City
														WHERE CountryCode = 'ESP')
ORDER BY Info->'$.Population' DESC
LIMIT 5)

UNION
# Esta query selecciona las cinco ciudades más pobladas de Reino Unido
(SELECT Name AS 'Nombre', District AS 'Distrito', Info->'$.Population' AS 'Población', CountryCode
FROM City
WHERE CountryCode = 'GBR' AND Info->'$.Population' >= (SELECT AVG(Info->'$.Population') # Esta subquery devuelve el valor promedio de población por ciudad
														FROM City
														WHERE CountryCode = 'ESP')
                                                        
ORDER BY Info->'$.Population' DESC
LIMIT 5);

# 19. Obtener las ciudades de España ordenadas alfabéticamente
SELECT Name AS 'Nombre', District AS 'Distrito'
FROM City
WHERE CountryCode = 'ESP'
ORDER BY Name;

# 20. Obtener las ciduades de Italia con orden alfabéticamente inverso
SELECT Name AS 'Nombre', District AS 'Distrito'
FROM City
WHERE CountryCode = 'ITA'
ORDER BY Name DESC;

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

# Códigos de países para cada país
SELECT Name AS 'País', Code AS "Código de País"
FROM Country
ORDER BY Name;