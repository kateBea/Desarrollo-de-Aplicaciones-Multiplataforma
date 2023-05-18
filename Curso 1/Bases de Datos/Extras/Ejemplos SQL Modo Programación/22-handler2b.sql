/*Ejemplo de uso de manejadores.
Procedimiento que recibe como parámetros los valores del nuevo dpto que inserta*/
use curso;
DROP PROCEDURE IF EXISTS handler2b;
DELIMITER //
CREATE PROCEDURE handler2b (id int, nombre varchar(14), localidad varchar(10)) modifies sql data 
BEGIN  
	DECLARE CONTINUE HANDLER FOR 1062 -- captura error de pk duplicada
		SELECT CONCAT ('Num Dpto ', id , ' ya existe') as 'Aviso de error';
    DECLARE CONTINUE HANDLER FOR 1048 -- captura error de pk null
		SELECT ('Num Dpto no puede ser NULL') as 'Aviso de error';
    insert into departamentos values(id, nombre, localidad);
END //
DELIMITER ;
call handler2b(10,'Otro Dpto', 'Madrid');
call handler2b(null,'Otro Dpto', 'Madrid');


