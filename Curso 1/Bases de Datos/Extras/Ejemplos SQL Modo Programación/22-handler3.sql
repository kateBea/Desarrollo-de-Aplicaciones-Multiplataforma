/*Ejemplo de uso de manejadores.*/
use curso;
DROP PROCEDURE IF EXISTS handler3a;
DELIMITER //
CREATE PROCEDURE handler3a (id int, nombre varchar(14), localidad varchar(10), out resultado varchar(50)) modifies sql data 
BEGIN  
	DECLARE CONTINUE HANDLER FOR 1062 -- captura error de pk duplicada
		set resultado =  CONCAT ('Num Dpto ', id , ' ya existe') ;
    DECLARE CONTINUE HANDLER FOR 1048 -- captura error de pk null
		set resultado = 'Num Dpto no puede ser NULL';
    set resultado = 'ok';    
	insert into departamentos values(id, nombre, localidad);
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE IF EXISTS handler3b;
CREATE PROCEDURE handler3b () 
BEGIN  
	DECLARE resul varchar(50);
    call handler3a (10, 'Otro', 'Madrid', resul);
    if resul = 'ok' then
		select 'Registro dado de alta' as 'Inserción';
	else
		select resul  as 'Error';
	end if;
END //
DELIMITER ;
call handler3b();