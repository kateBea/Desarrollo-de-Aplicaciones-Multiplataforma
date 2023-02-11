# 1:
SELECT Dni
FROM Cliente;

# 2:
SELECT *
FROM Programa;

# 3:
SELECT Nombre
FROM Programa;

# 4:
SELECT *
FROM Comercio;

# 5:
SELECT DISTINCT Ciudad
FROM Comercio;

# 6:
SELECT DISTINCT Nombre
FROM Programa;

# 7:
SELECT Dni + 4
FROM Cliente;

# 8:
SELECT Codigo * 7
FROM Programa;

# 9:
SELECT *
FROM Programa
WHERE Codigo <= 10;

# 10:
SELECT *
FROM Programa
WHERE Codigo = 10;

# 11:
SELECT *
FROM Fabricante
WHERE Pais LIKE '%Estados Unidos%';

# 12:
SELECT *
FROM Fabricante
WHERE Pais NOT IN ('ESPAÑA');

# 13:
SELECT Codigo
FROM Programa
WHERE Nombre = 'Windows';

# 14:
SELECT Ciudad
FROM Comercio
WHERE Nombre LIKE '%Corte Inglés%';

# 15:
SELECT Nombre
FROM Comercio
WHERE Nombre NOT IN ('El Corte Inglés');

# 16:
SELECT Codigo
FROM Programa
WHERE Nombre IN ('Windows', 'Access');

# 17:
SELECT *
FROM Cliente
WHERE Edad > 50 OR Edad BETWEEN 10 AND 25;

# 18:
SELECT DISTINCT Nombre
FROM Comercio
WHERE Ciudad IN ('Sevilla', 'Madrid');

# 19:
SELECT *
FROM Cliente
WHERE Nombre LIKE '%o';

# 20:
SELECT *
FROM Cliente
WHERE Nombre LIKE '%o' AND Edad > 30;

# 21:
SELECT *
FROM Programa
WHERE Version LIKE '%i' OR SUBSTR(Nombre, 1, 1) IN ('A', 'W');

# 22:
SELECT *
FROM Programa
WHERE Version LIKE '%i' OR Nombre LIKE 'A%S';

# 23:
SELECT *
FROM Programa
WHERE Version LIKE '%i' AND SUBSTR(Nombre, 1, 1) <> ('A');

# 24:
SELECT *
FROM Fabricante
ORDER BY Nombre;

# 25:
SELECT *
FROM Fabricante
ORDER BY Nombre DESC;

# 26:
SELECT *
FROM Programa
ORDER BY Version;

# 27:
SELECT *
FROM Programa
WHERE Codigo IN (SELECT Codigo
				 FROM Fabricante, Desarrolla
				 WHERE Fabricante.Id_Fab = Desarrolla.Id_Fab AND Fabricante.Nombre = 'Oracle');
                 
# 28:
SELECT *
FROM Comercio
WHERE Cif IN (SELECT Cif
			  FROM Distribuye
			  WHERE Codigo IN (SELECT Codigo
							   FROM Programa
							   WHERE Nombre LIKE 'Windows'));
                               
# 29:
SELECT Programa.Nombre, Distribuye.Cantidad
FROM Programa, Distribuye
WHERE Programa.Codigo = Distribuye.Codigo AND Distribuye.Cif IN (SELECT Cif
																 FROM Comercio
																 WHERE Nombre = 'El Corte Inglés' AND Ciudad = 'Madrid'); 
                                                                 
# 30:
SELECT *
FROM Fabricante
WHERE Id_Fab IN (SELECT Id_Fab
			  FROM Desarrolla
              WHERE Codigo IN (SELECT Codigo
							   FROM Programa
                               WHERE Nombre = 'Freddy Hardest'));
                               
# 31:
SELECT DISTINCT Programa.Nombre
FROM Programa, Registra
WHERE Programa.Codigo = Registra.Codigo AND Medio = 'INTERNET';

# 32:
SELECT DISTINCT Cliente.Nombre
FROM Cliente, Registra
WHERE Cliente.Dni = Registra.Dni AND Medio = 'INTERNET';

# 33:
SELECT DISTINCT Medio
FROM Cliente, Registra
WHERE Cliente.Dni = Registra.Dni AND Cliente.Nombre = 'Pepe Pérez';
# Sin entradas para el enunciado, con entradas para Cliente.Nombre = 'Pepito Pérez'

# 34:
# Ejercicio 32 reformulado
SELECT DISTINCT Cliente.Nombre
FROM Cliente, Registra
WHERE Cliente.Dni = Registra.Dni AND Medio = 'INTERNET';

# 35:
SELECT DISTINCT Programa.Nombre
FROM Programa, Registra
WHERE Programa.Codigo = Registra.Codigo AND Medio = 'TARJETA POSTAL';

# 36:
SELECT Ciudad
FROM Comercio
WHERE Cif IN (SELECT  Cif
			  FROM Programa, Registra
			  WHERE Programa.Codigo = Registra.Codigo AND Medio = 'INTERNET');
              
# 37:
