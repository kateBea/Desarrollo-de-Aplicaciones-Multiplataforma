# 4:
SELECT Materias.Nombre, Cursos.Nombre, Profesor
FROM Materias INNER JOIN Cursos ON CodigoCurso = Cursos.Codigo;

# 5:
SELECT COUNT(Materias.Nombre) AS 'Materias del Profe', Cursos.Nombre, Profesor
FROM Materias INNER JOIN Cursos ON Codigocurso = Cursos.Codigo
GROUP BY Profesor;

# 6:
SELECT Documento, Anio AS 'Año', Cuota, Materias.Nombre AS 'Nombre de Materia', Cursos.Nombre AS 'Nombre de Curso'
FROM Inscrito INNER JOIN Materias INNER JOIN Cursos ON Inscrito.CodigoCurso = Cursos.Codigo AND Inscrito.CodigoMateria = Materias.Codigo
ORDER BY Cursos.Nombre, Materias.Nombre;

# 7:
SELECT COUNT(DISTINCT Inscrito.documento) AS 'Alumnos por Profesor', Profesor
FROM Inscrito INNER JOIN Materias INNER JOIN Cursos ON Inscrito.CodigoCurso = Cursos.Codigo AND Inscrito.CodigoMateria = Materias.Codigo
GROUP BY Profesor;

# 8:
SELECT COUNT(DISTINCT Inscrito.documento) AS 'Alumnos por Materia', Materias.Nombre
FROM Inscrito INNER JOIN Materias INNER JOIN Cursos ON Inscrito.CodigoCurso = Cursos.Codigo AND Inscrito.CodigoMateria = Materias.Codigo
GROUP BY Materias.Nombre;

# 9:
SELECT Inscrito.documento AS 'Documento de Alumno', Cursos.Nombre, COUNT(DISTINCT Inscrito.CodigoMateria) AS 'Materias por Curso'
FROM Inscrito INNER JOIN Materias INNER JOIN Cursos ON Inscrito.CodigoCurso = Cursos.Codigo AND Inscrito.CodigoMateria = Materias.Codigo
GROUP BY Inscrito.documento, Cursos.Nombre;

# 10:
SELECT COUNT(DISTINCT Inscrito.documento) AS 'Total Alumnos distintos'
FROM Inscrito INNER JOIN Materias INNER JOIN Cursos ON Inscrito.CodigoCurso = Cursos.Codigo AND Inscrito.CodigoMateria = Materias.Codigo;

# 11:
SELECT COUNT(DISTINCT Documento), Materias.Nombre, Cursos.Nombre
FROM Inscrito INNER JOIN Materias INNER JOIN Cursos ON Inscrito.CodigoCurso = Cursos.Codigo AND Inscrito.CodigoMateria = Materias.Codigo
WHERE Cuota = 'n'
GROUP BY Inscrito.CodigoCurso, Inscrito.CodigoMateria;