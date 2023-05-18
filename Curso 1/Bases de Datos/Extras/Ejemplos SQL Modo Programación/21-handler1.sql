/*Ejemplo de uso de manejadores.
Se intenta insertar un departamento que ya existe*/
use curso;
DROP PROCEDURE IF EXISTS handler1;
DELIMITER //
CREATE PROCEDURE handler1 () modifies sql data
BEGIN  
	-- Se intenta insertar un registro que ya existe en la tabla
    insert into departamentos values(10,'Otro Dpto', 'Madrid');
END //
DELIMITER ;
call handler1();


