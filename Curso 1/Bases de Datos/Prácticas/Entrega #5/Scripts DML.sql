/****************************************************
Este Script contiene consultas sobre una base de datos MySQL.

Autor: Hugo Pelayo
Fecha: 29 de enero de 2023
Fichero: Script DML.sql
****************************************************/
# 1:
# Se usa el distinct porque el campo nombre nombre
# está etiquetado como unique (varios fabricantes pueden proveer el mismo producto por ejemplo) 
SELECT DISTINCT Nombre
FROM Producto;

# 2:
SELECT Nombre, Precio
FROM Producto;

# 3:
DESCRIBE Producto;

# 4:
# 1 euro = 1.09 USD
SELECT Nombre, Precio AS 'Precio EUR', TRUNCATE(Precio * 1.09, 3) AS 'Precio USD'
FROM Producto;

# 5:
# 1 euro = 1.09 USD
SELECT Nombre AS ' nombre  de producto', Precio AS 'euros', TRUNCATE(Precio * 1.09, 3) AS 'dólares'
FROM Producto;

# 6:
SELECT UPPER(Nombre) AS 'Nombre de Producto', Precio
FROM Producto;

# 7:
SELECT LOWER(Nombre) AS 'Nombre de Producto', Precio
FROM Producto;

# 8:
SELECT Nombre, SUBSTR(Nombre, 1, 2) AS 'Iniciales'
FROM Fabricante;

# 9:
SELECT Nombre, ROUND(Precio) AS 'Precio EUR'
FROM Producto;

# 10:
SELECT Nombre, TRUNCATE(Precio, 0) AS 'Precio EUR'
FROM Producto;

# 11:
SELECT Codigo AS 'Código de Fabricante'
FROM Fabricante
WHERE Codigo IN (SELECT DISTINCT codigo_fabricante
              FROM Producto);

# 12:
SELECT Codigo AS 'Código de Fabricante'
FROM Fabricante
WHERE Codigo IN (SELECT DISTINCT codigo_fabricante
              FROM Producto);

# 13:
SELECT Nombre
FROM Fabricante
ORDER BY Nombre;

# 14:
SELECT Nombre
FROM Fabricante
ORDER BY Nombre DESC;

# 15:
SELECT Nombre
FROM Producto
ORDER BY Nombre ASC, Precio DESC;

# 16:
SELECT *
FROM Fabricante
LIMIT 5;

# 17:
SELECT *
FROM Fabricante
LIMIT 3, 2;

# 18:
SELECT Nombre, Precio
FROM Producto
ORDER BY Precio
LIMIT 1;

# 19:
SELECT Nombre, Precio
FROM Producto
ORDER BY Precio DESC
LIMIT 1;

# 20:
SELECT Nombre
FROM Producto
WHERE codigo_fabricante = 2;

# 21:
SELECT Nombre
FROM Producto
WHERE Precio <= 120;

# 22:
SELECT Nombre
FROM Producto
WHERE Precio > 400;

# 23:
SELECT Nombre
FROM Producto
WHERE Precio < 400;

# 24:
SELECT *
FROM Producto
WHERE Precio >= 80 AND Precio <= 300;

# 25:
SELECT *
FROM Producto
WHERE Precio BETWEEN 60 AND 200;

# 26:
SELECT *
FROM Producto
WHERE Precio > 600 AND Codigo_Fabricante = 6;

# 27:
SELECT *
FROM Producto
WHERE Codigo_Fabricante = 1 OR Codigo_Fabricante = 3 OR Codigo_Fabricante = 5;

# 28:
SELECT *
FROM Producto
WHERE Codigo_Fabricante IN (1, 3, 5);

# 29:
SELECT Nombre, Precio * 100 AS 'Precio en céntimos'
FROM Producto;

# 30:
SELECT Nombre
FROM Fabricante
WHERE Nombre LIKE 'S%';

# 31:
SELECT Nombre
FROM Fabricante
WHERE Nombre LIKE '%E';

# 32:
SELECT Nombre
FROM Fabricante
WHERE Nombre LIKE '%W%';

# 33:
SELECT Nombre
FROM Fabricante
WHERE LENGTH(Nombre) = 4;

# 34:
SELECT Nombre
FROM Producto
WHERE Nombre LIKE '%Portátil%';

# 35:
SELECT Nombre
FROM Producto
WHERE Nombre LIKE '%Monitor%' AND Precio < 215;

# 36:
SELECT Nombre, Precio
FROM Producto
WHERE Precio >= 180
ORDER BY Precio DESC, Nombre ASC;


/*          CONSULTAS AUXILIARES          */
SELECT *
FROM Fabricante;

SELECT *
FROM Producto;