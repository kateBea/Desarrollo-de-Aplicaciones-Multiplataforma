/******************************************************************************************************************************************
                                                         Examen Bases de Datos 3ª Evaluación
 INSTRUCCIONES:
 -Durante la realización del examen, no se podrá hablar ni compartir materiales con otros compañeros. Tampoco será posible salir de clase durante el examen, a no ser por una situación excepcional. El móvil debe permanecer apagado y fuera del alcance del alumno. 
 -Está prohibido el uso de Internet, apuntes u otros recursos. 
 -Sólo se podrá tener una pestaña abierta en Workbench con este fichero.
 -El no cumplimiento de alguno de los puntos anteriores supondrá un suspenso.
 -Responde debajo de cada pregunta con la sentencia SQL que da respuesta al ejercicio, añade los comentarios que consideres oportunos.
 -La solución SQL propuesta debe tener en cuenta evitar posibles errores de ejecución SQL (por ejemplo, si ya existiera o no ese objeto)
 -Guarda el fichero con las soluciones como examen_Apellidos_Nombre.sql y súbelo al aula virtual.
 -El examen consta de 20 preguntas SQL, todas valen 0,5 puntos
 -Duración 1h 30 min. 
**********************************************************************************************************************************************/

/* 
NOMBRE Y APELLIDOS: Hugo Pelayo
*/

/* REQUSITOS: Antes de comenzar, ejecuta el script de creación de la base de datos RentACar.
	      Los ejercicios del examen se realizan sobre dicha BD
*/


use rentacar;
/* Ejercicio 1
Inserta tres coches. Los valores para el campo ID_Vehiculo serán 513, 514 y 515 y en Estado aparecerá “En uso”; 
el resto de los campos han de respetar la configuración de la BD pero con libertad para introducir los valores que prefieras
*/
INSERT INTO Vehiculos (id_vehiculo, estado, matricula, marca, modelo, tipocarnet) 
VALUES (513, "En uso", "4562YYY", "Toyota", "Yaris", "Coche"),
		(514, "En uso", "3651YZY", "Toyota", "Corola", "Coche"),
		(515, "En uso", "4391TVY", "Nissa", "PF", "Coche");
        
SELECT * 
FROM Vehiculos 
WHERE id_vehiculo IN (513, 514, 515);

SELECT * FROM Vehiculos;

/*Ejercicio 2
 Inserta tres motos más, de la misma marca que las que ya tenemos, pero modelo 
“City-Cruiser”. Sus ID_Vehiculo serán 516, 517 y 518 y en Estado aparecerá “En uso” 
Completa los datos con valores adecuados. 
Nota: Haz las tres incorporaciones con una sola sentencia*/
INSERT INTO Vehiculos (ID_Vehiculo, Matricula, Marca, Modelo, TipoCarnet, Estado) 
VALUES (516, '1111BBB', 'Yamaha', 'City-Cruiser', 'Moto', 'En uso'),
       (517, '2222CCC', 'Yamaha', 'City-Cruiser', 'Moto', 'En uso'),
       (518, '3333DDD', 'Yamaha', 'City-Cruiser', 'Moto', 'En uso');

SELECT * FROM Vehiculos WHERE TipoCarnet LIKE 'Moto';
        
/* Ejercicio 3
 Tenemos dos furgonetas averiadas (ID_Vehiculo 511 y 512) cambia su Estado a  “Averiado”. */
UPDATE Vehiculos
SET estado = 'Averiado'
WHERE id_vehiculo in (511, 512);

SELECT * FROM Vehiculos WHERE ID_VEHICULO IN (511, 512);

/* Ejercicio 4
Como nos hemos quedado casi sin furgonetas también hay que ampliar la flota de estos vehículos.
Inserta dos nuevas furgonetas del modelo y marca que prefieras, con ID_Vehiculo 519 y 520; 
matrículas “4554LKK” y “4555LKK” respectivamente y estarán en uso inicialmente.
 NOTA: Deberás hacerlo con una sola sentencia 
*/
INSERT INTO Vehiculos (id_vehiculo, estado, matricula, marca, modelo, tipocarnet) 
VALUES (519, "En uso", "4554LKK", "Toyota", "X44", "Furgoneta"),
		(520, "En uso", "4555LKK", "Renault", "R114", "Furgoneta");



/* Ejercicio 5
La clientela también aumenta. Da de alta a 1 mujer y a 1 hombre 
con unos valores adecuados para los campos de la BD. Los ID_Cliente será 111 y 112
 NOTA: Deberás hacerlo con una sola sentencia 
*/
INSERT INTO Clientes (id_cliente, nombre, apellido1, apellido2, mediopago, tipocarnet, numcarnet, telefono, direccion1, ciudad, email)
VALUES (111, 'Clara', 'López', 'Rodriguez', '1234567890765432', 'Todos', '6547834521', '644895461', 'Gil de Andrade, 26', 'Alcalá de H.', 'claralrod1@trollmail.com'),
	   (112, 'Carlos', 'Gonzalo', null, '4657396571385764', 'Coche', '5738591235', '687364783', 'Santiago, 9', 'Madrid', 'carlos772@trollmail.com');

SELECT * FROM Clientes;

/* Ejercicio 6
Inserta un alquiler para dos de los nuevos clientes anteriores, uno alquilará un coche y otro una moto, ambos de los vehículos recién incorporados a la flota.
NOTA: Deberás hacerlo con una sola sentencia 
*/
INSERT INTO Alquileres (ID_Alquiler, InicioAlquiler, ID_Cliente, ID_Vehiculo, SeguroExtra)
VALUES 
    (1041, CURRENT_TIMESTAMP(), 111, (SELECT id_vehiculo FROM Vehiculos WHERE tipoCarnet LIKE 'Moto' ORDER BY id_vehiculo DESC LIMIT 1), 'Sí'),
    (1042, CURRENT_TIMESTAMP(), 112, (SELECT id_vehiculo FROM Vehiculos WHERE tipoCarnet LIKE 'Coche' ORDER BY id_vehiculo DESC LIMIT 1), 'No');

SELECT * FROM Vehiculos;
SELECT * FROM Alquileres;
                    
/* Ejercicio 7
Ya tenemos de vuelta en el servicio activo todas las furgonetas que estaban en “Averiado”, cambia de nuevo su estado a “En uso”.*/
update vehiculos
set estado = 'En uso'
where id_vehiculo in (select id_vehiculo from vehiculos where estado like 'Averidado' and tipocarnet like 'Furgoneta');


/* Ejercicio 8
Crea una vista llamada “VistaAlquileresFebrero” con los datos de los alquileres de vehículos que se han iniciado en febrero. 
¿Cuántas filas tiene? */
create or replace view VistaAlquileresFebrero as
select id_alquiler, inicioalquiler, finalquiler, id_cliente, alquileres.id_vehiculo, seguroextra, marca, modelo, matricula 
from alquileres inner join vehiculos on alquileres.id_vehiculo = vehiculos.id_vehiculo
where month(inicioalquiler) = 2;

-- número de filas de la vista (tiene 4 filas)
select count(*) from VistaAlquileresFebrero;


/* Ejercicio 9
Crea una vista llamada “VistaAlquilerFinDeSemana” con todos los datos de los alquileres que comienzan en fin de semana (viernes, sábado o domingo). ¿Cuántas filas tiene? */
CREATE OR REPLACE VIEW VistaAlquilerFinDeSemana AS
SELECT id_alquiler, inicioalquiler, finalquiler, id_cliente, alquileres.id_vehiculo, seguroextra, marca, modelo, matricula 
FROM alquileres INNER JOIN vehiculos ON alquileres.id_vehiculo = vehiculos.id_vehiculo
where dayofweek(inicioalquiler) in (6, 7, 1);

-- número de filas de la vista (tiene 18 filas)
select count(*) from VistaAlquilerFinDeSemana;


/* Ejercicio 10
Elimina, sin que nos pueda dar ningún error,  la vista “VistaAlquileresFebrero”, ya ha dejado de ser útil. */
drop view VistaAlquileresFebrero;


/* Ejercicio 11
Se ha ampliado la plantilla de personal. Crea un usuario con el nombre Consultor y las pass que consideres */
 create user Consultor identified by 'createUser';

/* Ejercicio 12
Da permiso de SELECT e INSERT a la tabla Clientes de RentACar al usuario “consultor”.
*/
grant select, insert on RentACar.Clientes to Consultor;

/* Ejercicio 13
Todos los vehículos con más de 4 alquileres tienen que pasar por el taller. Cambia su estado de “En uso” a “Revisión”. 
*/
update vehiculos
set estado = 'Revisión'
where id_vehiculo in 
(select vehiculos.id_vehiculo
from vehiculos inner join alquileres on vehiculos.id_vehiculo = alquileres.id_vehiculo
group by vehiculos.id_vehiculo
having count(distinct id_alquiler) > 4);

                        
/* Ejercicio 14
 Nos han comunicado el positivo por covid-19 del cliente con ID 109, hay pasar todos los vehículos que se alquilaran entre el 1 y el 15 de marzo a una
 desinfección exhaustiva que conducirá su Estado a “Revisión”.
 Es indiferente si acabó o empezó el alquiler en ese lapso, si estuvo algún vehículo en contacto con el cliente tiene que ser desinfectado.*/
update vehiculos
set estado = 'Revisión'
where vehiculos.id_vehiculo in
(select alquileres.id_vehiculo 
from alquileres inner join vehiculos on vehiculos.id_vehiculo = alquileres.id_vehiculo
where id_cliente = 109 and ((month(inicioalquiler) = 3 and day(inicioalquiler) between 1 and 15) or
		(month(finalquiler) = 3 and day(finalquiler) between 1 and 15)));
 


/* Ejercicio 15
Todos los vehículos no afectados por el coronavirus que estaban en revisión pasan de nuevo al estado “En uso”.*/
update vehiculos
set estado = 'En uso'
where estado = 'Revisión' and vehiculos.id_vehiculo not in
(select alquileres.id_vehiculo 
from alquileres inner join vehiculos on vehiculos.id_vehiculo = alquileres.id_vehiculo
where id_cliente = 109 and ((month(inicioalquiler) = 3 and day(inicioalquiler) between 1 and 15) or
		(month(finalquiler) = 3 and day(finalquiler) between 1 and 15)));

 
 /* Ejercicio 16
Crea una vista llamada “VistaAlquileresCortos” con el ID_Alquiler, InicioAlquiler, FinAlquiler y la duración del mismo, con los alquileres que duren menos de dos horas. 
Nota: puedes usar la función TIMESTAMPDIFF(unit,datetime_expr1,datetime_expr2). 
Returns datetime_expr2 − datetime_expr1, where datetime_expr1 and datetime_expr2 are date or datetime expressions. 
One expression may be a date and the other a datetime; a date value is treated as a datetime having the time part '00:00:00' where necessary. 
The unit for the result (an integer) is given by the unit argument. 
Ejemplo:
mysql> SELECT TIMESTAMPDIFF(MINUTE,'2003-02-01','2003-05-01 12:05:55');
        -> 128885*/
create or replace view VistaAlquileresCortos
(ID_Alquiler, InicioAlquiler, FinAlquiler) as
select ID_Alquiler, InicioAlquiler, FinAlquiler
where day(FinAlquiler) = day(FinAlquiler) and hour(FinAlquiler) - hour(FinAlquiler) < 3;

select * from VistaAlquileresCortos;


/* Ejercicio 17
Crea una vista "VistaContactosClientesAlquieleresFurgoneta" con los campos
'Nombre_Cliente', 'TfnoCliente', 'Email', 'FechaInicio', 'FechaFin', 'Marca', 'Modelo'
. Muestra el contenido de la vista
*/
create or replace view VistaContactosClientesAlquieleresFurgoneta
(Nombre_Cliente, TfnoCliente, Email, FechaInicio, FechaFin, Marca, Modelo) as
select concat(nombre, ' ', apellido1, ' ', ifnull(apellido2,'')), telefono, email, inicioalquiler, finalquiler, marca, modelo
from clientes inner join alquileres inner join vehiculos on alquileres.id_cliente = clientes.id_cliente and alquileres.id_vehiculo = vehiculos.id_vehiculo;

select * from VistaContactosClientesAlquieleresFurgoneta;

/* Ejercicio 18
 Crea una vista "AlquileresMotos" donde se muestre el nombre, tfno y email de los clientes que han alquilado motos. Muestra el contenido de la vista
*/
create or replace view AlquileresMotos
(Nombre_Cliente, Email, TfnoCliente) as
select distinct concat(nombre, ' ', apellido1, ' ', ifnull(apellido2,'')), email, telefono
from clientes inner join alquileres inner join vehiculos on alquileres.id_cliente = clientes.id_cliente and alquileres.id_vehiculo = vehiculos.id_vehiculo
where vehiculos.tipocarnet like 'Moto';


select * from AlquileresMotos;

/* Ejercicio 19
Crea una vista "AlquileresTipo" que muestre el número de alquileres que hay para cada tipo de vehiculo */
create or replace view AlquileresTipo
(Tipo, Cantidad) as
select tipoCarnet, count(id_alquiler)
from alquileres inner join vehiculos on alquileres.id_vehiculo = vehiculos.id_vehiculo
group by tipoCarnet;

select * from AlquileresTipo;


/* Ejercicio 20
Insertar tres vehículos nuevos con los datos que consideres apropiados pero de la misma marca y modelo del vehículo que ha sido más alquilado.*/
INSERT INTO Vehiculos (ID_Vehiculo, Matricula, Marca, Modelo, TipoCarnet, Estado) 
VALUES ((SELECT 519, '1231BTB', marca, modelo, tipoCarnet, 'En uso' FROM Vehiculos WHERE id_vehiculo = 501),
		(SELECT 520, '7521CEC', marca, modelo, tipoCarnet, 'En uso' FROM Vehiculos WHERE id_vehiculo = 501),
		(SELECT 521, '3213WDD', marca, modelo, tipoCarnet, 'En uso' FROM Vehiculos WHERE id_vehiculo = 501));

select id_vehiculo, count(*)
from alquileres
group by id_vehiculo
order by count(*) desc;

    
/*Usar al acabar para limpieza*/
DROP DATABASE rentacar;