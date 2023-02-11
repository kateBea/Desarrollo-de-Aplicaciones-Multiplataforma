# 1:
SELECT * 
FROM Empleados a
WHERE EXISTS (SELECT Dept_No
				FROM Empleados b
                WHERE a.Dept_No = b.Dept_No AND b.Apellido = 'GIL');
                
SELECT * 
FROM Empleados
WHERE Dept_No = (SELECT Dept_No
				FROM Empleados b
                WHERE b.Apellido = 'GIL');

# 2:
SELECT * 
FROM Empleados a
WHERE EXISTS (SELECT Dept_No
				FROM Empleados b
                WHERE a.Oficio = b.Oficio AND b.Apellido = 'CEREZO')
ORDER BY Apellido;

# 3:
SELECT Apellido, Oficio, Salario, Fecha_Alt
FROM Empleados 
WHERE Oficio IN (SELECT Oficio FROM Empleados WHERE Apellido = 'JIMÉNEZ')
  OR Salario >= (SELECT Salario FROM Empleados WHERE Apellido LIKE 'FERNÁNDEZ'); 

# 4:
SELECT Apellido, Oficio, Salario, Fecha_Alt
FROM Empleados a
WHERE EXISTS (SELECT Dept_No, Salario
			  FROM Empleados b
              WHERE a.Dept_No = b.Dept_No AND a.Salario = b.Salario AND Apellido LIKE 'FERNÁNDEZ');

# 5:
SELECT *
FROM Empleados
WHERE Dept_No = 10 AND Salario > (SELECT DISTINCT Salario
								  FROM Empleados
                                  WHERE Apellido LIKE 'GIL');

# 6:
SELECT Apellido, Oficio, Loc
FROM Empleados, Departamentos
WHERE Empleados.Dept_No = Departamentos.Dept_No;

# 7:
SELECT Apellido, Oficio, Loc
FROM Empleados, Departamentos
WHERE Empleados.Dept_No = Departamentos.Dept_No AND Oficio = 'ANALISTA';

# 8:
SELECT Apellido, Oficio, Loc
FROM Empleados, Departamentos
WHERE Empleados.Dept_No = Departamentos.Dept_No AND Loc = 'MADRID';

# 9:
SELECT Apellido, Oficio, Loc
FROM Empleados, Departamentos
WHERE Empleados.Dept_No = Departamentos.Dept_No AND Salario BETWEEN 200000 AND 300000;

# 10:
SELECT Apellido, Salario, Dnombre
FROM Empleados a, Departamentos d
WHERE a.Dept_No = d.Dept_No AND EXISTS (SELECT Dept_No
										FROM Empleados b
										WHERE a.Oficio = b.Oficio AND b.Apellido = 'GIL');

# 11:
SELECT Apellido, Salario, Dnombre
FROM Empleados a, Departamentos d
WHERE a.Dept_No = d.Dept_No AND EXISTS (SELECT Dept_No
										FROM Empleados b
										WHERE a.Oficio = b.Oficio AND b.Apellido = 'GIL')
							AND Comision IS NOT NULL AND Comision = 0;

# 12:
SELECT *
FROM Empleados, Departamentos
WHERE Empleados.Dept_No = Departamentos.Dept_No AND Dnombre = 'CONTABILIDAD'
ORDER BY Apellido;

# 13:
SELECT Apellido
FROM Empleados, Departamentos
WHERE Empleados.Dept_No = Departamentos.Dept_No AND Loc = 'SEVILLA' 
												AND Oficio IN ('ANALISTA', 'EMPLEADO');

# 14:
SELECT AVG(Salario) AS 'Salrio medio'
FROM Empleados;

# 15:
SELECT MAX(Salario)
FROM Empleados
GROUP BY Dept_No
HAVING Dept_No = 10;

# 16:
SELECT Empleados.Dept_No, MIN(Salario)
FROM Empleados, Departamentos
WHERE Empleados.Dept_No = Departamentos.Dept_No AND Dnombre = 'VENTAS'
GROUP BY Empleados.Dept_No;

# 17:
SELECT Empleados.Dept_No, AVG(Salario)
FROM Empleados, Departamentos
WHERE Empleados.Dept_No = Departamentos.Dept_No AND Dnombre = 'CONTABILIDAD'
GROUP BY Empleados.Dept_No;

# 18:
SELECT *
FROM Empleados 
WHERE Salario > (SELECT AVG(Salario) FROM Empleados);

# 19:
SELECT COUNT(*) AS 'Empleados departamento 10'
FROM Empleados
WHERE Dept_No = 10;

# 20:
SELECT COUNT(Empleados.Dept_No)
FROM Empleados, Departamentos
WHERE Empleados.Dept_No = Departamentos.Dept_No AND Dnombre = 'VENTAS'
GROUP BY Empleados.Dept_No;

# 21:
SELECT COUNT(*) AS 'Empleados sin comisión'
FROM Empleados
WHERE Comision IS NOT NULL AND Comision = 0;

# 22:
SELECT Apellido
FROM Empleados
WHERE Salario = (SELECT MAX(Salario) FROM Empleados);

# 23:
SELECT Apellido
FROM Empleados
WHERE Salario = (SELECT MIN(Salario) FROM Empleados);

# 24:
SELECT MAX(Salario)
FROM Empleados, Departamentos
WHERE Empleados.Dept_No = Departamentos.Dept_No AND Dnombre = 'VENTAS';

# 25:
SELECT COUNT(*)
FROM Empleados
WHERE Apellido LIKE 'A%';

# 26:
SELECT AVG(Salario) AS 'Salario Medio', COUNT(Comision) AS 'Comision no nula',
		MAX(Salario) AS 'Sueldo máximo', MIN(Salario) AS 'Sueldo mínimo'
FROM Empleados
GROUP BY Dept_No
HAVING Dept_No = 30;