/*Ejemplo de uso de manejadores.
Se intenta insertar un departamento que ya existe para evitar el error anterior se crea un handler para ese código*/
use curso;
DROP PROCEDURE IF EXISTS handler1b;
DELIMITER //
CREATE PROCEDURE handler1b () modifies sql data
BEGIN  
	DECLARE CONTINUE HANDLER FOR 1062
		SELECT ('Num Dpto ya existe') as 'Aviso de error';
    
    insert into departamentos values(10,'Otro Dpto', 'Madrid');
END //
DELIMITER ;
call handler1b();


