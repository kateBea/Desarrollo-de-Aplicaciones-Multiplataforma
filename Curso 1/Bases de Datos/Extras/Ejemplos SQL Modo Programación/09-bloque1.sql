use curso;

DROP PROCEDURE IF EXISTS bloque1;
DELIMITER //
CREATE PROCEDURE bloque1()
BEGIN	
	DECLARE externa VARCHAR(45) DEFAULT 'Vble visible en todo el procedimiento';
    BEGIN
		DECLARE interna varchar(45);
        SET interna ='Solo accesible dentro';
        select externa; -- correcto es visible
    END;
    /* select interna; -- error */
END//
DELIMITER ;
CALL bloque1(); 










