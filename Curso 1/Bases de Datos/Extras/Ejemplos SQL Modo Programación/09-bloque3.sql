use curso;

DROP PROCEDURE IF EXISTS bloque3;
DELIMITER //
CREATE PROCEDURE bloque3()
BEGIN	
	DECLARE v int default 500;
    BEGIN	
		DECLARE v int;
		set v=200;
        select v; -- 200
    END;
     select v; -- 500
END//
DELIMITER ;
CALL bloque3(); 










