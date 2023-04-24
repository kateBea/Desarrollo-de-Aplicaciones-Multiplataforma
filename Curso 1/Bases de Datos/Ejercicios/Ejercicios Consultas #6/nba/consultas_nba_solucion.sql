-- Hay que poner en uso la bd
USE nba;
-- 1.	Obtener el nombre de los equipos de la NBA.
Select Nombre From Equipos;
-- 2.	Obtener el nombre de los jugadores franceses que juegan en la NBA.
Select Nombre From Jugadores
Where Procedencia='France';
-- 3.	Obtener la altura del jugador más bajo de la NBA.
Select min(altura)
from jugadores;

select altura from jugadores order by altura asc limit 1;



-- 4.	Obtener el nombre de los jugadores de los Lakers.
Select nombre from jugadores where nombre_equipo='Lakers';


-- 5.	Obtener cuántos equipos tiene cada conferencia de la NBA (se han de conseguir dos columnas, una con el número de equipos y otra con la conferencia a la que pertenece ese número o al revés).
Select count(*) numEquipos, conferencia from equipos group by conferencia;


-- 6.	Obtener cuánto pesa el jugador más pesado de toda la NBA.
select max(peso) from jugadores;


-- 7.	Obtener cuánto mide el jugador más bajo de cada equipo NBA (se han de conseguir dos columnas, una con el nombre del equipo y otra con la altura de su jugador más bajo).
Select nombre_equipo, min(altura) from jugadores group by nombre_equipo;


-- 8.	Obtener el peso medio de los jugadores de los Celtics.
select round(avg(peso),2) as pesomedio from jugadores where nombre_equipo="Celtics";


-- 9.	Obtener la altura media de los jugadores españoles y alemanes de la NBA (se han de conseguir dos columnas como con otras consultas).
Select procedencia, avg(altura) from jugadores where procedencia in ('Spain', 'Germany')
group by procedencia;


-- 10.	Obtener los nombres y procedencia de todos los jugadores cuya procedencia contenga la sílaba “pa” en cualquier posición.
Select nombre, procedencia from jugadores where procedencia like '%pa%';

-- 11.	Obtener los nombres y procedencia de todos los jugadores cuya procedencia contenga los caracteres p y a  en cualquier posición.
Select nombre, procedencia from jugadores where procedencia like '%p%a%';


-- 12.  Obtener la media de puntos marcados por los equipos visitantes en la temporada 02/03.
select round(avg(puntos_visitante), 3) from partidos where temporada = '02/03';


-- 13.  Obtener la media de puntos marcados por los Lakers como locales en la temporada 00/01.

select round(avg(puntos_visitante), 3) media from partidos 
where equipo_local='Lakers' and temporada = '00/01';


-- 14.  Conseguir el mayor número de asistencias que se han efectuado entre todos los registrados.
select max(asistencias_por_partido) as maxAsistencias from estadisticaS;


-- 15.  Mostrar el código del jugador y la temporada en la 
-- que se obtuvo el mayor número de asistencias por partido 
-- sabiendo el dato de la consulta anterior.
Select temporada, jugador, asistencias_por_partido
From estadisticas
Where asistencias_por_partido = (select max(asistencias_por_partido) 
								from estadisticaS);
 


-- 16. Obtén la media de puntos que ha recibido cada equipo 
-- en su campo en la temporada 01/02. 
-- Debe aparecer en los resultados primero el equipo que más puntos haya recibido en contra.
Select equipo_local, avg(puntos_local) media From partidos
Where temporada='01/02' 
group by equipo_local
Order By 2 desc;


-- 17. Obtén la media de puntos que ha anotado cada equipo 
-- en campo contrario en la temporada 01/02. 
-- Debe aparecer en los resultados primero el equipo 
-- que más puntos haya anotado a su favor.
Select equipo_local, avg(puntos_visitante) media From partidos
Where temporada='01/02' 
group by equipo_local
Order By 2 desc;

-- 18.  Encuentra la altura del base (posición G) más alto de cada equipo.
Select nombre_equipo, max(altura) maxAltura from jugadores
where posicion='G' group by nombre_equipo;


-- 19. Obtén el número de puntos más alto de anotación 
-- que haya conseguido un jugador por temporada.
Select temporada, max(puntos_por_partido) as "max ptos partido"
From Estadisticas
group by Temporada;


-- 20.  Recupera la altura del jugador más bajo de cada procedencia.
Select procedencia, min(altura) as "min altura" from jugadores
group by procedencia;
