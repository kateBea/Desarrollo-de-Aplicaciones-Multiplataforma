# 1:
SELECT Materias.Nombre, Cursos.Nombre, Profesor
FROM Materias INNER JOIN Cursos ON CodigoCurso = Cursos.Codigo;

# 2:
SELECT COUNT(Materias.Nombre) AS 'Materias del Profe', Cursos.Nombre, Profesor
FROM Materias INNER JOIN Cursos ON Codigocurso = Cursos.Codigo
GROUP BY Profesor;

# 3:
SELECT Documento, Anio AS 'Año', Cuota, Materias.Nombre AS 'Nombre de Materia', Cursos.Nombre AS 'Nombre de Curso'
FROM Inscrito INNER JOIN Materias INNER JOIN Cursos ON Inscrito.CodigoCurso = Cursos.Codigo AND Inscrito.CodigoMateria = Materias.Codigo
ORDER BY Cursos.Nombre, Materias.Nombre;

# 4:
SELECT Profesor
FROM Materias
# NOTA: Hacemos group by por que se asume que el conjunto de alumnos
# de un profesor son los que se registran con un documento, codigocurso y materias en concreto
# , no se tiene en cuenta el año ya que un alumno podría estar repitiendo un curso
WHERE EXISTS (SELECT Profesor
				   FROM Inscrito INNER JOIN Materias INNER JOIN Cursos ON Inscrito.CodigoCurso = Cursos.Codigo AND Inscrito.CodigoMateria = Materias.Codigo
				   GROUP BY Inscrito.documento,Inscrito.codigocurso,Inscrito.codigomateria)
GROUP BY Profesor;
