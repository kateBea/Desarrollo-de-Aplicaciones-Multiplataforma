# 1:
SELECT Materias.Nombre, Cursos.Nombre, Profesor
FROM Materias INNER JOIN Cursos ON CodigoCurso = Cursos.Codigo;

# 2:
SELECT COUNT(Materias.Nombre) AS 'Materias del Profe', Cursos.Nombre, Profesor
FROM Materias INNER JOIN Cursos ON Codigocurso = Cursos.Codigo
GROUP BY Profesor;

# 3:
