# 1:
SELECT Apellido1 AS 'Primer apellido'
FROM Empleado;

# 2:
SELECT DISTINCT Apellido1 AS 'Primer apellido'
FROM Empleado;

# 3:
SELECT *
FROM Empleado;

# 4:
SELECT Nombre, Apellido1 AS 'Primer apellido', IFNULL(Apellido2, '') AS 'Segundo Apellido'
FROM Empleado;

# 5:
SELECT codigo_departamento
FROM Empleado;

# 6:
SELECT DISTINCT codigo_departamento
FROM Empleado;

# 7:
SELECT CONCAT(Nombre, ' ', Apellido1, ' ', IFNULL(Apellido2, '')) AS 'Nombre completo'
FROM Empleado;

# 8:
SELECT UPPER(CONCAT(Nombre, ' ', Apellido1, ' ', IFNULL(Apellido2, ''))) AS 'Nombre completo'
FROM Empleado;

# 9:
SELECT LOWER(CONCAT(Nombre, ' ', Apellido1, ' ', IFNULL(Apellido2, ''))) AS 'Nombre completo'
FROM Empleado;

# 10:
SELECT Nombre, SUBSTR(Nif, 1, 8) AS 'Dígitos NIF', SUBSTR(Nif, 9, 1) AS 'Letra NIF'
FROM Empleado;

# 11:

# 12:

# 13:

# 14:

# 15:

# 16:

# 17:

# 18:

# 19:

# 20:

# 21:

# 22:

# 23:

# 24:

# 25:

# 26:

# 27:

# 28:

# 29:

# 30:

# 31:

# 32:

# 33:

# 34:

# 35:

# 36:


