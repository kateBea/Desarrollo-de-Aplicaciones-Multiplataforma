/* Ejercicio 01 */
CREATE DATABASE IF NOT EXISTS Tienda_Informatica 
CHARACTER SET utf8 
COLLATE utf8_general_ci;

USE Tienda_Informatica;

/* Fabricante tabla declarada antes a propósito */
/* Si no, no se puede referenciar en Producto ya que no existe*/
CREATE TABLE IF NOT EXISTS Fabricante (
	  codigo INT PRIMARY KEY,
      nombre VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Producto (
	codigo INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DOUBLE NOT NULL,
    codigo_fabricante INT NOT NULL,
    CONSTRAINT Fk_Codigo_Fab FOREIGN KEY (codigo_fabricante) REFERENCES Fabricante (codigo)
);

SELECT * 
FROM Producto;

SELECT * 
FROM Fabricante;

/* Inserts en Producto */
INSERT INTO Producto VALUES();

/* Inserts en Fabricante */
INSERT INTO Fabricante VALUES(1, 'Asus');
INSERT INTO Fabricante VALUES(2, 'Lenovo');
INSERT INTO Fabricante VALUES(3, 'HP');
INSERT INTO Fabricante VALUES(4, 'Seagate');
INSERT INTO Fabricante VALUES(5, 'Crucial');
INSERT INTO Fabricante VALUES(6, 'GigaByte');

DROP TABLE Producto CASCADE;
DROP TABLE Fabricante CASCADE;
DROP DATABASE Tienda_Informatica;
