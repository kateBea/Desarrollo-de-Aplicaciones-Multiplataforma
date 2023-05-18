use curso;
DROP PROCEDURE IF EXISTS handler_orden2;
DELIMITER //
CREATE PROCEDURE handler_orden2 ()
BEGIN  
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
		SELECT 'Ocurrió un error. Fin del programa';
	declare exit handler for 1062
		select 'Clave repetida. Código Mysql 1062';
	declare exit handler for sqlstate '23000'
		Select 'Ocurrió error SQL State 23000'; --  Error: SQLSTATE[23000]: Integrity constraint violation:
	BEGIN
		insert into departamentos values(10, 'otro', 'madrid');
	END;	
END //
DELIMITER ;
call handler_orden2(); 

DROP PROCEDURE IF EXISTS handler_orden3;
DELIMITER //
CREATE PROCEDURE handler_orden3 () -- Si se atrapa en un bloque interno, ya no se propaga a la del bloque superior externo
BEGIN  
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
		SELECT 'Ocurrió un error. Fin del programa';
	declare exit handler for 1062
		select 'Clave repetida. Código Mysql 1062';
	declare exit handler for sqlstate '23000'
		Select 'Ocurrió error SQL State 23000'; --  Error: SQLSTATE[23000]: Integrity constraint violation:
	BEGIN
		DECLARE EXIT HANDLER FOR SQLEXCEPTION
			SELECT 'Bloque interno. Ocurrió un error. Fin del programa';
		declare exit handler for 1062
			select 'Bloque interno.Clave repetida. Código Mysql 1062';
		declare exit handler for sqlstate '23000'
			Select 'Bloque interno. Ocurrió error SQL State 23000'; --  Error: SQLSTATE[23000]: Integrity constraint violation:
        
        insert into departamentos values(10, 'otro', 'madrid');
	END;	
END //
DELIMITER ;
call handler_orden3(); 
