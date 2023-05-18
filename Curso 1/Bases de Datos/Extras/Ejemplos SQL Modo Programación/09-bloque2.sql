use curso;

DROP PROCEDURE IF EXISTS bloque2;
DELIMITER //
CREATE PROCEDURE bloque2()
BEGIN	
	DECLARE externa VARCHAR(45) DEFAULT 'Vble visible en todo el procedimiento';
    BEGIN		
        SET externa ='Solo accesible dentro';       
    END;
     select externa; 
END//
DELIMITER ;
CALL bloque2(); 










