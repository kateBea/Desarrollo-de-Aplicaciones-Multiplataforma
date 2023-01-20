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
DESCRIBE Country;

# Seleccionamos toda la información de la tabla City
SELECT * 
FROM City;

/**********************************************
			     PARA PRACTICAR
**********************************************/

# 1. Nombre y la población de las ciudades de Brasil
SELECT Name, Info->'$.Population' AS 'Población'
FROM City
WHERE CountryCode = 'BRA';

# 2. Nombre de todas las ciudades que empiezan por "B"
SELECT Name AS 'Nombre Ciudad'
FROM City
WHERE Name LIKE 'B%';

# 3. Todos los nombres de las ciudades brasileñas que empiezan por 'S'
SELECT Name AS 'Nombre Ciudad'
FROM City
WHERE Name LIKE 'S%' AND CountryCode = 'BRA';

# 4. Ciudades belgas y polacas con más de 400000 habitantes
SELECT Name AS 'Nombre Ciudad', Info->'$.Population' AS 'Población'
FROM City
WHERE (CountryCode = 'BEL' OR CountryCode = 'POL') AND Info->'$.Population' > 400000;

# 5. Listado de ciudades españolas ordenado por nombre 
# (ordenación por defecto ya que no se especifica)
SELECT Name AS 'Nombre Ciudad', District AS 'Provincia'
FROM City
WHERE CountryCode = 'ESP'
ORDER BY Name;

# 6. Listado de ciudades españolas ordenado ascendentemente por población
SELECT Name AS 'Nombre Ciudad', Info->'$.Population' AS 'Población', District AS 'Provincia'
FROM City
WHERE CountryCode = 'ESP'
ORDER BY Info->'$.Population';

# 7. Listado de ciudades españolas ordenado descendentemente por población
SELECT Name AS 'Nombre Ciudad', Info->'$.Population' AS 'Población', District AS 'Provincia'
FROM City
WHERE CountryCode = 'ESP'
ORDER BY Info->'$.Population' DESC;

# 8. Ciudades estadounidenses y alemanas con más de 1000000 habitantes
SELECT Name AS 'Nombre Ciudad', Info->'$.Population' AS 'Población'
FROM City
WHERE (CountryCode = 'USA' OR CountryCode = 'DEU') AND Info->'$.Population' > 1000000;

# 9. Obtener listado sin repeticiones de los países de la tabla de ciudades sin repeticiones
# Sólo podemos obtener el código de país, ya que es lo que guarda esta tabla
# Para consultar el nombre, nos debemos ir a la tabla de Países (Country)
# Si queremos que aparezcan en la misma consulta usaríamos operaciones JOIN
SELECT DISTINCT CountryCode AS 'Código de País'
FROM City;

# 10. Obtener listado de los países cuyo código empieze por 'E' de la tabla City
SELECT DISTINCT CountryCode AS 'Código de País'
FROM City
WHERE CountryCode LIKE 'E%';

# Con JOIN
SELECT DISTINCT CountryCode AS 'Código de País', Country.Name AS 'Nombre País'
FROM City, Country
WHERE CountryCode LIKE 'E%' AND CountryCode = Code;

# 11. Obtener listado de los países cuyo código contenga una 'S' de la tabla City
SELECT DISTINCT CountryCode AS 'Código de País'
FROM City
WHERE CountryCode LIKE '%S%';

# Con JOIN
SELECT DISTINCT CountryCode AS 'Código de País', Country.Name AS 'Nombre País'
FROM City, Country
WHERE CountryCode LIKE '%S%' AND CountryCode = Code;

# 12. Obtener listado de los países cuyo código acabe por una 'A' de la tabla City
SELECT DISTINCT CountryCode AS 'Código de País'
FROM City
WHERE CountryCode LIKE '%A';

# Con JOIN
SELECT DISTINCT CountryCode AS 'Código de País', Country.Name AS 'Nombre País'
FROM City, Country
WHERE CountryCode LIKE '%A' AND CountryCode = Code;

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