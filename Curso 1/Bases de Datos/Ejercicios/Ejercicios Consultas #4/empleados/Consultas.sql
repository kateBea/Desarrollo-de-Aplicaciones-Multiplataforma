-- 1
SELECT Apellido1 AS 'Apellido'
FROM Empleado;

-- 2
SELECT DISTINCT Apellido1 AS 'Apellido'
FROM Empleado;

-- 3
SELECT *
FROM Empleado;

-- 4
SELECT Nombre, Apellido1 AS 'Primer Apellido', Apellido2 AS 'Segundo Apellido'
FROM Empleado;

-- 5
SELECT Codigo_Departamento AS 'Código de departamento'
FROM Empleado;

-- 6
SELECT DISTINCT Codigo_Departamento AS 'Código de departamento'
FROM Empleado;

-- 7
SELECT CONCAT(Nombre, ' ', Apellido1 , ' ', IFNULL(Apellido2, '')) AS 'Nombre completo'
FROM Empleado;

-- 8
 SELECT UPPER(CONCAT(Nombre, ' ', Apellido1 , ' ', IFNULL(Apellido2, ''))) AS 'Nombre completo'
FROM Empleado;

-- 9
 SELECT lOWER(CONCAT(Nombre, ' ', Apellido1 , ' ', IFNULL(Apellido2, ''))) AS 'Nombre completo'
FROM Empleado;

-- 10
SELECT SUBSTR(Nif, 1, 8) AS 'Código', SUBSTR(Nif, 9, 2) AS Letras
FROM Empleado;

-- 11
SELECT Nombre AS 'Nombre', (Presupuesto - Gastos) AS 'Presupuesto'
FROM Departamento;

-- 12
SELECT Nombre, Presupuesto
FROM Departamento
ORDER BY Nombre, Presupuesto;

-- 13
SELECT Nombre
FROM Departamento
ORDER BY Nombre;

-- 14
SELECT Nombre
FROM Departamento
ORDER BY Nombre DESC;

-- 15





