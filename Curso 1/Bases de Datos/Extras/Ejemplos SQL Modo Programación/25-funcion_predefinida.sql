/*Ejemplo de uso de manejadores con función predefinida
En este ejemplo se observa error al crear tabla que ya existe*/
use curso;
DROP PROCEDURE IF EXISTS handler_funcPreda;
DELIMITER //
CREATE PROCEDURE handler_funcPreda ()
BEGIN  
	
	create table alumnos (id int primary key, nombre varchar(50));
	
END //
DELIMITER ;
call handler_funcPreda(); -- Saltará el error 1050 que habrá que tratar


DROP PROCEDURE IF EXISTS handler_funcPredb;
DELIMITER //
CREATE PROCEDURE handler_funcPredb ()
BEGIN  
	declare tabla_Existe condition for 1050;
    declare exit handler for tabla_Existe
		select ('La tabla que intentas crear ya existe') as 'Aviso de error';
	create table alumnos (id int primary key, nombre varchar(50));
	
END //
DELIMITER ;
call handler_funcPredb(); 