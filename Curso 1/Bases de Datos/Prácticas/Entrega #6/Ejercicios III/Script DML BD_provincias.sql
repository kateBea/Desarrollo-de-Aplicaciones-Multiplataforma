# 1:
SELECT Count(Nombre) AS 'Provincias sin Clientes' 
FROM Provincias 
WHERE Nombre NOT IN (SELECT DISTINCT p1.Nombre FROM Clientes INNER JOIN Provincias p1 ON Clientes.CodigoProvincia = p1.Codigo);

# 2:
SELECT DISTINCT p1.Nombre 
FROM Clientes INNER JOIN Provincias p1 ON Clientes.CodigoProvincia = p1.Codigo;

# 3:
SELECT DISTINCT p1.Nombre, COUNT(Clientes.CodigoProvincia) AS 'Clientes por provincia'
FROM Clientes INNER JOIN Provincias p1 ON Clientes.CodigoProvincia = p1.Codigo
GROUP BY p1.Nombre;

# 4:
SELECT DISTINCT p1.Nombre, COUNT(Clientes.CodigoProvincia) AS 'Clientes por provincia'
FROM Clientes LEFT JOIN Provincias p1 ON Clientes.CodigoProvincia = p1.Codigo
GROUP BY p1.Nombre;

# El resultado es el mismo que en el apartado anterior porque no se LEFT JOIN
# muestra los registros de la intersección junto con los de la tabla de la izquierda
# de la intersección. Así que la provincias en las que no haya clientes, es decir, 
# Clientes.CodigoProvincia = p1.Codigo es falso, no salen en el conjunto de registros final.