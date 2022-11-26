/* Ejercicio 02 */
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
INSERT INTO Producto VALUES(1, 'Disco Duro', 86.99, 5);
INSERT INTO Producto VALUES(2, 'Memoria RAM', 120, 6);
INSERT INTO Producto VALUES(3, 'Disco SSD', 150.99, 4);
INSERT INTO Producto VALUES(4, 'GeForce', 185, 7);
INSERT INTO Producto VALUES(5, 'Monitor', 202, 1);
INSERT INTO Producto VALUES(6, 'Portátil', 505, 2);
INSERT INTO Producto VALUES(7, 'Impresora', 59.99, 3);

/* Inserts en Fabricante */
INSERT INTO Fabricante VALUES(1, 'Asus');
INSERT INTO Fabricante VALUES(2, 'Lenovo');
INSERT INTO Fabricante VALUES(3, 'HP');
INSERT INTO Fabricante VALUES(4, 'Samsung');
INSERT INTO Fabricante VALUES(5, 'Crucial');
INSERT INTO Fabricante VALUES(6, 'Seagate');
INSERT INTO Fabricante VALUES(7, 'GigaByte');

/* Ignorar esto. Usado para arreglar un error en datos alinsertar */
UPDATE Fabricante
SET nombre = 'Samsung'
WHERE Fabricante.codigo = 4;
UPDATE Fabricante
SET nombre = 'Seagate'
WHERE Fabricante.codigo = 6;

DROP TABLE Producto CASCADE;
DROP TABLE Fabricante CASCADE;
DROP DATABASE Tienda_Informatica;
