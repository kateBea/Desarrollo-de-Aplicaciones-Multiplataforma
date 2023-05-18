-- 1
SELECT Nombre
FROM Equipos;

-- 2
SELECT Nombre
FROM Jugadores
WHERE Procedencia LIKE 'France';

-- 3
SELECT MIN(Altura) AS 'Altura más baja'
FROM Jugadores;

-- 4
SELECT Nombre
FROM Jugadores
WHERE Nombre_Equipo LIKE '%Lakers%';

-- 5
SELECT Conferencia, COUNT(Nombre) AS 'Número Equipos'
FROM Equipos
GROUP BY Conferencia;

-- 6
SELECT MAX(Peso)
FROM Jugadores;

-- 7
SELECT MIN(Altura) AS 'Altura más baja', Nombre_Equipo AS 'Nombre Equipo'
FROM Jugadores
GROUP BY Nombre_Equipo; 

-- 8
SELECT AVG(Peso) AS 'Peso medio'
FROM Jugadores
WHERE Nombre_Equipo LIKE '%Celtics%';

-- 9
SELECT AVG(Altura) AS 'Altura media', Nombre_Equipo AS 'Nombre Equipo'
FROM Jugadores
WHERE Procedencia LIKE '%Germany%' OR Procedencia LIKE '%Spain%'
GROUP BY Nombre_Equipo; 

-- 10
SELECT Nombre, Procedencia
FROM Jugadores
WHERE Procedencia LIKE '%pa%';

-- 11
SELECT Nombre, Procedencia
FROM Jugadores
WHERE Procedencia LIKE '%pa%';

-- 12
SELECT AVG(Puntos_Visitante) 'Media Puntos Visitante'
FROM Partidos
WHERE Temporada LIKE '%02/03%';

-- 13
SELECT AVG(Puntos_Visitante) AS 'Media Puntos Lakers Como locales'
FROM Partidos
WHERE Temporada = '00/01' AND Equipo_Local = 'Lakers';

-- 14
SELECT MAX(Asistencias_por_partido)
FROM Estadisticas;

-- 15
SELECT Jugador, Temporada, Asistencias_por_partido
FROM Estadisticas
WHERE Asistencias_por_partido = (SELECT MAX(Asistencias_por_partido)
					FROM Estadisticas);
                    
-- 16
SELECT Equipo_Local AS 'Equipo', AVG(Puntos_Local) AS 'Media puntos', Puntos_Visitante AS 'Puntos en Contra'
FROM Partidos
WHERE Temporada = '01/02'
GROUP BY Equipo_Local
ORDER BY Puntos_Visitante DESC;

-- 17
SELECT Equipo_Visitante AS 'Equipo', AVG(Puntos_Visitante) AS 'Media puntos', Puntos_Visitante AS 'Puntos anotados a favor'
FROM Partidos
WHERE Temporada = '01/02'
GROUP BY Equipo_Visitante
ORDER BY Puntos_Visitante DESC;

-- 18
SELECT MAX(Altura) AS 'Altura', Nombre_Equipo AS 'Nombre_Equipo'
FROM Jugadores
WHERE Posicion = 'G'
GROUP BY Nombre_Equipo;

-- 19
SELECT SUM(Puntos_por_partido) AS 'Total de puntos por temporada', Temporada
FROM Estadisticas
GROUP BY Jugador
ORDER BY SUM(Puntos_por_partido) DESC
LIMIT 1;

-- 20
SELECT MIN(Altura), Nombre, Procedencia
FROM Jugadores
GROUP BY Procedencia;
