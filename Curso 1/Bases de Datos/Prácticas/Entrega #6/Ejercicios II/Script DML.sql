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
SELECT DISTINCT Cliente.Nombre, Programa.Nombre
FROM Cliente, Registra, Programa
WHERE Cliente.Dni = Registra.Dni AND Medio = 'INTERNET' AND Registra.Codigo = Programa.Codigo;

# 38:
SELECT DISTINCT Cliente.Nombre, Programa.Nombre, Medio, Comercio.Nombre
FROM Cliente, Registra, Programa, Comercio
WHERE Cliente.Dni = Registra.Dni AND Registra.Codigo = Programa.Codigo AND Registra.Cif = Comercio.Cif;

# 39:
SELECT Comercio.Ciudad
FROM Comercio
WHERE Cif IN (SELECT Cif
			FROM Registra
			WHERE Codigo IN (SELECT Codigo
							FROM Programa
							WHERE Codigo IN (SELECT Codigo
											 FROM Fabricante, Desarrolla
											 WHERE Fabricante.Id_Fab = Desarrolla.Id_Fab AND Fabricante.Nombre = 'Oracle')));
                                             
# 40:
SELECT *
FROM Cliente
WHERE Dni IN (SELECT Dni 
			  FROM Registra
              WHERE Codigo IN (SELECT Codigo FROM Programa WHERE Nombre = 'Access' AND Version = 'XP'));
              
# 41:
SELECT Nombre 
FROM Fabricante
WHERE Pais = (SELECT Pais
			  FROM Fabricante
			  WHERE Nombre = 'ORACLE');
              
# 42:
SELECT Nombre
FROM Cliente
WHERE Edad = (SELECT Edad FROM Cliente WHERE Nombre = 'Pepe Pérez');

# 43:
SELECT *
FROM Comercio
WHERE Ciudad = (SELECT Ciudad FROM Comercio WHERE Nombre = 'FNAC');

# 44:
SELECT *
FROM Cliente a, Registra b
# Primera parte del condicional para excluir a Pepito perez de la consulta final
# Como antes solo hay resultados para 'Pepito Pérez'
WHERE a.Nombre <> 'Pepito Pérez' AND a.Dni = b.Dni AND b.Medio IN (SELECT DISTINCT Medio
																   FROM Cliente c, Registra d
																   WHERE c.Dni = d.Dni AND c.Nombre = 'Pepito Pérez' AND b.Medio = b.Medio);
                                                                   
# 45:
SELECT DISTINCT COUNT(*)
FROM Programa
WHERE EXISTS (SELECT DISTINCT Nombre, Version FROM Programa);

# 46:
SELECT COUNT(*)
FROM Cliente
WHERE Edad > 40;

# 47:
SELECT SUM(Cantidad)
FROM Distribuye
WHERE Cif = 1;

# 48:
SELECT AVG(Cantidad) AS 'Media Programa Código 7'
FROM Distribuye
WHERE Codigo = 7;

# 49:
SELECT MIN(Cantidad) AS 'Mínima cantidad Programa Código 7'
FROM Distribuye
WHERE Codigo = 7;

# 50:
SELECT MAX(Cantidad) AS 'Máxima cantidad Programa Código 7'
FROM Distribuye
WHERE Codigo = 7;

# 51:
SELECT *
FROM Comercio
WHERE EXISTS (SELECT * FROM Distribuye WHERE Codigo = 7 AND Distribuye.Cif = Comercio.Cif);

# 52:
SELECT COUNT(*)
FROM Registra
WHERE Medio = 'INTERNET';

# 53:
SELECT SUM(Cantidad) AS 'Copias vendidas en Sevilla'
FROM Distribuye
WHERE EXISTS (SELECT * 
			  FROM Comercio 
              WHERE Ciudad = 'Sevilla' AND Distribuye.Cif = Comercio.Cif);
              
# 54:
SELECT COUNT(*)
FROM Desarrolla
WHERE EXISTS (SELECT *
			  FROM Fabricante 
              WHERE Pais = 'Estados Unidos' AND Desarrolla.Id_Fab = Fabricante.Id_Fab);
              
# 55:
SELECT UPPER(Nombre) AS 'Nombre Cliente', LENGTH(Nombre) AS 'Longitud Nombre'
FROM Cliente;

# 56:
SELECT CONCAT(Nombre, ' ', IFNULL(Version, '')) AS 'Programa'
FROM Programa;





              

