/*Ejemplo de uso de manejadores.
Procedimiento que recibe como parámetros los valores del nuevo dpto que inserta*/
use curso;
DROP PROCEDURE IF EXISTS handler2a;
DELIMITER //
CREATE PROCEDURE handler2a (id int, nombre varchar(14), localidad varchar(10)) modifies sql data 
BEGIN  
	DECLARE CONTINUE HANDLER FOR 1062
		SELECT CONCAT ('Num Dpto ya existe') as 'Aviso de error';
    
    insert into departamentos values(id, nombre, localidad);
END //
DELIMITER ;
call handler2a(10,'Otro Dpto', 'Madrid');
call handler2a(null,'Otro Dpto', 'Madrid');


