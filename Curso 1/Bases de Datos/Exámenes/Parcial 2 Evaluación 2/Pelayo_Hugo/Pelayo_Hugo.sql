-- Examen 2ª evaluación de Bases de Datos.
-- NOMBRE Y APELLIDOS: Hugo Pelayo Aseko

-- **********  Realizar las siguientes consultas, justo debajo de su enunciado. *********************************************************

--  Cuántas peliculas se están proyectando en alguna sala. [0,25 PUNTOS]
select nombre, count(id_pelicula) AS 'Películas por Sala'
from salas
group by nombre;

--  Mostrar las distintas calificaciones de edad (sin que se repitan) que existen. [0,5 PUNTOS]
select distinct edad_minima
from peliculas
where edad_minima is not null;

--  Mostrar todas las películas que no han sido calificadas. [ 0,5 PUNTOS]
select *
from peliculas
where edad_minima is null;

--  Mostrar la información de todas las películas  cuya calificación de edad es menor que 13. [0,5 PUNTOS]
select *
from peliculas
where edad_minima is not null and edad_minima < 13;

-- Mostrar la información de todas las películas cuya calificación de edad esté comprendida entre 7 y 13, ambos inclusive. 
-- Hacerlo de dos formas con los operadores que se indica

/*1ª forma: con AND  [0,5 PUNTOS]*/
select *
from peliculas
where edad_minima is not null and (edad_minima >= 7 and edad_minima <= 13);

/*2ª forma con BETWEEN [0,5 PUNTOS]*/
select *
from peliculas
where edad_minima is not null and (edad_minima between 7 and 13);


-- Mostrar la calificación de edad más alta de todas las películas. [0,5 PUNT0S]
select max(edad_minima) as 'Calificación más alta de edad'
from peliculas;


--  Mostrar la media de calificación de edad de todas las películas. [0,5 PUNTOS]
select avg(edad_minima) as 'Calificación media de edad'
from peliculas;



-- Mostrar la información de las salas cuyo nombre termine por un espacio, luego un carácter y luego la letra ‘a’. [0,5 PUNTOS]
select *
from salas
where nombre like '% _a';


-- Mostrar el número de películas (mostrar como 'Num Peliculas') de cada una de las distintas calificaciones de edad que existen. [0,5 PUNTOS]
select edad_minima, count(nombre) as 'Num Peliculas'
from peliculas
where edad_minima is not null
group by edad_minima;


-- Mostrar el número de de salas (mostrar como 'Nº Salas')en las que se proyectan cada una de las películas que existen (sólo hace falta mostrar el id de la película). [0,5 PUNTOS]
select peliculas.nombre as nombre_pelicula, count(salas.nombre) as 'Nº Salas'
from peliculas inner join salas on salas.id_pelicula = peliculas.id_pelicula and salas.id_pelicula is not null
group by peliculas.nombre;



-- Mostrar la información de todas las salas y, si se proyecta alguna película en la sala,  mostrar también la información de la película. [0,5 PUNTOS]
select *
from salas left outer join peliculas on salas.id_pelicula is not null and salas.id_pelicula = peliculas.id_pelicula;




-- Mostrar la información de todas las películas y, si se proyecta en alguna sala, mostrar también la información de la sala. [0,5 PUNTOS]
select *
from peliculas left outer join salas on salas.id_pelicula is not null and salas.id_pelicula = peliculas.id_pelicula;



-- Mostrar los nombres de las películas que no se proyectan en ninguna sala. 

/* Con JOIN  [0,75 PUNTO]*/
select *
from peliculas
where id_pelicula not in
(select distinct salas.id_pelicula
from peliculas inner join salas on salas.id_pelicula is not null and salas.id_pelicula = peliculas.id_pelicula);

/* Con Subconsulta [0,75 PUNTO] */
select nombre
from peliculas
where not exists (select id_pelicula 
				from salas 
                where salas.id_pelicula is not null and salas.id_pelicula = peliculas.id_pelicula);


-- Mostrar la información de todas las películas, incluyendo el número de salas en las que se proyecta.

/* Con JOIN [0,75 PUNTO] */
select peliculas.id_pelicula, peliculas.nombre, edad_minima, count(salas.nombre) as 'Salas en que se proyecta'
from peliculas inner join salas on salas.id_pelicula is not null and salas.id_pelicula = peliculas.id_pelicula
group by peliculas.id_pelicula, peliculas.nombre, edad_minima;

/* Con Subconsulta [0,75 PUNTO]*/
select peliculas.id_pelicula, peliculas.nombre, edad_minima, count(distinct salas.nombre) as 'Salas en que se proyecta'
from peliculas, salas
where peliculas.id_pelicula = (select distinct id_pelicula 
										from salas 
                                        where salas.id_pelicula is not null and salas.id_pelicula = peliculas.id_pelicula)
group by peliculas.id_pelicula, peliculas.nombre, edad_minima;

-- Mostrar la información de las salas que proyecten películas ordenando el listado por la calificación de edad de mayor a menor. [0,75 PUNTOS] 
select salas.id_sala, salas.nombre, salas.id_pelicula
from peliculas inner join salas on salas.id_pelicula is not null and salas.id_pelicula = peliculas.id_pelicula
order by edad_minima;

