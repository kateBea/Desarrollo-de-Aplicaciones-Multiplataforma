/* Ejercicio 01 */
CREATE DATABASE IF NOT EXISTS Tienda_Informatica 
CHARACTER SET utf8 
COLLATE utf8_general_ci;

USE Tienda_Informatica;

CREATE TABLE IF NOT EXISTS Producto (
	codigo INT(10) PRIMARY KEY,
    nombre VARCHAR(100),
    precio DOUBLE,
    codigo_fabricante INT(10)
);

CREATE TABLE IF NOT EXISTS Fabricante (
	  codigo INT(10) PRIMARY KEY,
      nombre VARCHAR(100)
);

SELECT * 
FROM Producto;

SELECT * 
FROM Fabricante;

/* Inserts en Producto */
INSERT INTO Producto VALUES();

/* Inserts en Fabricante */
INSERT INTO Fabricante VALUES();

DROP TABLE Producto CASCADE;
DROP TABLE Fabricante CASCADE;
DROP DATABASE Tienda_Informatica;
