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
SELECT CONCAT(IFNULL(Apellido2, ''), ' ', Apellido1, ', ', Nombre) AS 'Nombre y Apellidos'
FROM Empleado
ORDER BY Apellido2, Apellido1, Nombre;

-- 16
SELECT Nombre, Presupuesto
FROM Departamento
ORDER BY Presupuesto DESC
LIMIT 3;

-- 17
SELECT Nombre, Presupuesto
FROM Departamento
ORDER BY Presupuesto
LIMIT 3;

-- 18
SELECT Nombre, Gastos
FROM Departamento
ORDER BY Gastos DESC
LIMIT 2;

-- 19
SELECT Nombre, Gastos
FROM Departamento
ORDER BY Gastos
LIMIT 2;

-- 20
SELECT * 
FROM Empleado
LIMIT 2, 5;

-- 21
SELECT Nombre, Presupuesto
FROM Departamento
WHERE Presupuesto >= 150000;

-- 22
SELECT Nombre, Gastos
FROM Departamento
WHERE Gastos < 5000;

-- 23
SELECT *
FROM Departamento
WHERE Presupuesto <= 200000 and Presupuesto >= 100000;

-- 24
SELECT *
FROM Departamento
WHERE NOT (Presupuesto <= 200000 and Presupuesto >= 100000);

-- 25
SELECT *
FROM Departamento
WHERE Presupuesto BETWEEN 100000 and 200000;

-- 26
SELECT *
FROM Departamento
WHERE Presupuesto NOT BETWEEN 100000 and 200000;

-- 27
SELECT Nombre, Gastos, Presupuesto
FROM Departamento
WHERE Gastos > Presupuesto;

-- 28
SELECT Nombre, Gastos, Presupuesto
FROM Departamento
WHERE Gastos < Presupuesto;

-- 29
SELECT Nombre, Gastos, Presupuesto
FROM Departamento
WHERE Gastos = Presupuesto;

-- 30
SELECT * 
FROM Empleado
WHERE Apellido2 IS NULL;

-- 31
SELECT * 
FROM Empleado
WHERE Apellido2 IS NOT NULL;

-- 32
SELECT * 
FROM Empleado
WHERE Apellido2 LIKE 'López';

-- 33
SELECT * 
FROM Empleado
WHERE Apellido2 LIKE 'Díaz' OR Apellido2 LIKE 'Moreno';

-- 34
SELECT * 
FROM Empleado
WHERE Apellido2 IN ('Díaz', 'Moreno');

-- 35
SELECT Nombre, CONCAT(Apellido1, ' ', IFNULL(Apellido2, '')) AS Apellidos, NIF
FROM Empleado
WHERE Codigo_Departamento = 3;

-- 36
SELECT Nombre, CONCAT(Apellido1, ' ', IFNULL(Apellido2, '')) AS Apellidos, NIF
FROM Empleado
WHERE Codigo_Departamento IN (2, 4, 5);






























































