
use curso;
DROP PROCEDURE IF EXISTS handler_orden;
DELIMITER //
CREATE PROCEDURE handler_orden ()
BEGIN  
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
		SELECT 'Ocurrió un error. Fin del programa';
	declare exit handler for 1062
		select 'Clave repetida. Código Mysql 1062';
	declare exit handler for sqlstate '23000'
		Select 'Ocurrió error SQL State 23000'; --  Error: SQLSTATE[23000]: Integrity constraint violation:
	insert into departamentos values(10, 'otro', 'madrid');
	
END //
DELIMITER ;
call handler_orden(); 


