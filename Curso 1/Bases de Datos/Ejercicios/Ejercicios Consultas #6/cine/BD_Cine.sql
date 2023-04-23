-- 1. Crear la Base de datos
DROP DATABASE IF EXISTS cine;

CREATE DATABASE cine CHARACTER SET utf8mb4;

USE cine;

DROP TABLE IF EXISTS peliculas;
CREATE TABLE peliculas (
  id_pelicula INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  edad_minima INT,
  PRIMARY KEY (id_pelicula)
);
DROP TABLE IF EXISTS salas;
CREATE TABLE salas (
  id_sala INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  id_pelicula INT,
  PRIMARY KEY (id_sala),
  FOREIGN KEY (id_pelicula) REFERENCES peliculas (id_pelicula)
);
  
-- 2.  Insertar los siguientes datos en la base de datos:

INSERT INTO peliculas (id_pelicula, nombre, edad_minima) VALUES (1, 'Película 1', 0);
INSERT INTO peliculas (id_pelicula, nombre, edad_minima) VALUES (2, 'Película 2', 7);
INSERT INTO peliculas (id_pelicula, nombre, edad_minima) VALUES (3, 'Película 3', 12);
INSERT INTO peliculas (id_pelicula, nombre, edad_minima) VALUES (4, 'Película 4', 12);
INSERT INTO peliculas (id_pelicula, nombre, edad_minima) VALUES (5, 'Película 5', 16);
INSERT INTO peliculas (id_pelicula, nombre, edad_minima) VALUES (6, 'Película 6', null);

INSERT INTO salas (id_sala, nombre, id_pelicula) VALUES (1, 'Sala 1a', 1);
INSERT INTO salas (id_sala, nombre, id_pelicula) VALUES (2, 'Sala 2a', null);
INSERT INTO salas (id_sala, nombre, id_pelicula) VALUES (3, 'Sala 11a', 1);
INSERT INTO salas (id_sala, nombre, id_pelicula) VALUES (4, 'Sala 12a', 4);
INSERT INTO salas (id_sala, nombre, id_pelicula) VALUES (5, 'Sala 1b', 5);
INSERT INTO salas (id_sala, nombre, id_pelicula) VALUES (6, 'Sala 2b', 6);

-- 3.  Mostrar las distintas calificaciones de edad que existen.
SELECT DISTINCT edad_minima AS 'Calificaciones de edad' 
FROM Peliculas;


-- 4.  Mostrar todas las películas que no han sido calificadas.
SELECT * 
FROM Peliculas 
WHERE edad_minima IS NULL;

-- 5.  Mostrar la información de todas las películas 
-- cuya calificación de edad es menor que 13.
SELECT * 
FROM Peliculas 
WHERE edad_minima < 13;


-- 6.  Mostrar la información de todas las películas
-- cuya calificación de edad esté comprendida entre 7 y 13, ambos inclusive.

/* con AND */
SELECT * 
FROM Peliculas 
WHERE edad_minima >= 7 AND edad_minima <= 13;

/* con BETWEEN */
SELECT * 
FROM Peliculas 
WHERE edad_minima BETWEEN 7 AND 13;

-- 7.  Mostrar la calificación de edad más alta de todas las películas.
SELECT MAX(edad_minima) AS 'Calificación máxima'
FROM Peliculas;


-- 8.  Mostrar la media de calificación de edad de todas las películas.
SELECT AVG(edad_minima) AS 'Media calificación'
FROM Peliculas;


-- 9.  Mostrar la información de todas las salas y, 
-- si se proyecta alguna película en la sala, 
-- mostrar también la información de la película.
SELECT * 
FROM salas LEFT JOIN Peliculas ON salas.id_pelicula = Peliculas.id_pelicula;


-- 10.  Mostrar la información de todas las películas y, 
-- si se proyecta en alguna sala, mostrar también la información de la sala.
SELECT * 
FROM salas RIGHT JOIN Peliculas ON salas.id_pelicula = Peliculas.id_pelicula;


-- 11.  Mostrar los nombres de las películas que no se proyectan en ninguna sala. 

/* Con JOIN */
SELECT peliculas.nombre 
FROM Peliculas LEFT JOIN Salas ON salas.id_pelicula = Peliculas.id_pelicula
WHERE id_sala IS NULL;

/* Con Subconsulta */
SELECT peliculas.nombre 
FROM Peliculas
WHERE id_pelicula NOT IN (SELECT id_pelicula FROM salas WHERE id_pelicula IS NOT NULL);

-- 12.  Mostrar la información de todas las películas, 
-- incluyendo el número de salas en las que se proyecta.
SELECT peliculas.*, COUNT(salas.id_pelicula) AS 'Número de salas' 
FROM salas INNER JOIN (SELECT salas.id_pelicula, COUNT(*) FROM Salas WHERE salas.id_pelicula IS NOT NULL GROUP BY salas.id_pelicula) AS Valor
GROUP BY salas.id_pelicula;
-- 13.  Mostrar la información de las salas que proyecten películas 
-- ordenando el listado por la calificación de edad de mayor a menor.



-- 14.  Mostrar la información de las salas cuyo nombre
-- termine por un espacio, luego un carácter y luego la letra ‘a’.



-- 15.  Mostrar el número de películas de cada una
-- de las distintas calificaciones de edad que existen.



-- 16.  Mostrar el número de de salas en las que se proyectan
-- cada una de las películas que existen (sólo hace falta mostrar el id de la película).



-- 17. Actualizar todas las películas que no han sido calificadas
-- como no recomendables para menores de 13 años'.



-- 18.  Eliminar todas las salas que proyectan películas
-- recomendadas para todos los públicos.



-- 19.  Vaciar los datos de las salas.



-- 20.  Eliminar la tabla de las salas.