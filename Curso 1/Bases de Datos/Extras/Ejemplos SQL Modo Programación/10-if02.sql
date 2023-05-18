use curso;

DROP PROCEDURE IF EXISTS if02;
DELIMITER //
CREATE PROCEDURE if02()
bloque_externo: BEGIN	
	DECLARE v int default 800;
    bloque_interno: BEGIN
		IF v<500 then
			leave bloque_interno;
		end if;
        select 'No llega a esta línea';
    END bloque_interno;
END bloque_externo//
DELIMITER ;
CALL if02(); 










