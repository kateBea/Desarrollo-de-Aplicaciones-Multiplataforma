-- Crear la Base de datos
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
  
-- Insertar los siguientes datos en la base de datos:

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